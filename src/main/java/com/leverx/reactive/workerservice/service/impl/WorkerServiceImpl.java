package com.leverx.reactive.workerservice.service.impl;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import com.leverx.reactive.workerservice.entity.JobWorker;
import com.leverx.reactive.workerservice.mapper.WorkerMapper;
import com.leverx.reactive.workerservice.repository.WorkerRepository;
import com.leverx.reactive.workerservice.service.JobWorkerService;
import com.leverx.reactive.workerservice.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;
    private final JobWorkerService jobWorkerService;

    @Override
    public Flux<WorkerDto> findAll() {
        return workerRepository
                .findAll()
                .map(workerMapper::mapEntityToDto);
    }

    @Override
    public Mono<WorkerDto> findById(UUID id) {
        return workerRepository
                .findById(id)
                .map(workerMapper::mapEntityToDto);
    }

    @Override
    @Transactional
    public Mono<WorkerDto> create(WorkerDto workerDto) {
        log.info("WorkerServiceImpl.create() with data : " + workerDto);
        if (Objects.isNull(workerDto)) {
            throw new RuntimeException("You have to pass existing jobs with ids ))");
        }
        return workerRepository
                .save(workerMapper.mapDtoToEntity(workerDto))
                .flatMap(savedWorker -> {
                            if (Objects.nonNull(workerDto.getJobs())) {
                                log.info("--IF-- section. Jobs: {}", workerDto.getJobs());
                                workerDto.getJobs().forEach(System.out::println);
                                workerDto.getJobs().stream()
                                        .map(jobDto -> new JobWorker(savedWorker.getId(), jobDto.getId()))
                                        .forEach(System.out::println);
                                return jobWorkerService.saveAll(workerDto.getJobs().stream()
                                        .map(jobDto -> new JobWorker(savedWorker.getId(), jobDto.getId()))
                                        .collect(Collectors.toSet())
                                ).then(Mono.just(savedWorker));
                            }
                            log.info("--ELSE-- section. Is deleted ? {}", savedWorker.getDeleted());
                            return Mono.just(savedWorker);
                        }
                )
                .map(workerMapper::mapEntityToDto);
    }

    @Override
    public void deleteById(UUID id) {
        workerRepository.deleteById(id);
    }

    @Override
    public Mono<WorkerDto> update(WorkerDto workerDto) {
        return workerRepository
                .save(workerMapper.mapDtoToEntity(workerDto))
                .map(workerMapper::mapEntityToDto);
    }
}

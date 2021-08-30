package com.leverx.reactive.workerservice.service.impl;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import com.leverx.reactive.workerservice.entity.JobWorker;
import com.leverx.reactive.workerservice.entity.Worker;
import com.leverx.reactive.workerservice.mapper.WorkerMapper;
import com.leverx.reactive.workerservice.repository.WorkerRepository;
import com.leverx.reactive.workerservice.service.JobWorkerService;
import com.leverx.reactive.workerservice.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;
    private final JobWorkerService jobWorkerService;

    @Override
    @Transactional(readOnly = true)
    public Flux<WorkerDto> findAll() {
        return workerRepository
                .findAll()
                .map(workerMapper::mapEntityToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<WorkerDto> findById(UUID id) {
        return workerRepository
                .findById(id)
                .map(workerMapper::mapEntityToDto);
    }

    @Override
    @Transactional
    public Mono<WorkerDto> create(@NonNull WorkerDto workerDto) {
        return workerRepository
                .save(workerMapper.mapDtoToEntity(workerDto))
                .flatMap(savedWorker -> jobWorkerService
                        .saveAll(extractJobWorkerSet(workerDto, savedWorker))
                        .then(Mono.just(savedWorker))
                )
                .doOnSuccess(worker -> {
                    System.out.println(worker.getId());
                    if (Objects.nonNull(worker.getJobWorkers())) {
                        worker.getJobWorkers().forEach(System.out::println);
                    }
                })
                .map(workerMapper::mapEntityToDto);
    }

    private Set<JobWorker> extractJobWorkerSet(WorkerDto workerDto, Worker savedWorker) {
        return workerDto.getJobs().stream()
                .map(jobDto -> new JobWorker(savedWorker.getId(), jobDto.getId()))
                .collect(toSet());
    }

    @Override
    @Transactional
    public Mono<Void> deleteById(UUID id) {
        return jobWorkerService.deleteAllWorkerById(id)
                .thenEmpty(workerRepository.deleteById(id));
    }

    @Override
    public Mono<WorkerDto> update(WorkerDto workerDto) {
        return workerRepository
                .save(workerMapper.mapDtoToEntity(workerDto))
                .map(workerMapper::mapEntityToDto);
    }
}

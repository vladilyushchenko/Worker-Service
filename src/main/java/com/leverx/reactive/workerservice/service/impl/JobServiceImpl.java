package com.leverx.reactive.workerservice.service.impl;

import com.leverx.reactive.workerservice.dto.JobDto;
import com.leverx.reactive.workerservice.mapper.JobMapper;
import com.leverx.reactive.workerservice.repository.JobRepository;
import com.leverx.reactive.workerservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public Mono<JobDto> create(JobDto jobDto) {
        return jobRepository.save(jobMapper.mapDtoToEntity(jobDto))
                .map(jobMapper::mapEntityToDto);
    }

    @Override
    public Flux<JobDto> findAll() {
        return jobRepository.findAll()
                .map(jobMapper::mapEntityToDto);
    }
}

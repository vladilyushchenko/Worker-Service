package com.leverx.reactive.workerservice.service;

import com.leverx.reactive.workerservice.dto.JobDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JobService {

    Mono<JobDto> create(JobDto jobDto);

    Flux<JobDto> findAll();
}

package com.leverx.reactive.workerservice.service;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkerService {

    Flux<WorkerDto> findAll();

    Mono<WorkerDto> findById(UUID id);

    Mono<WorkerDto> create(WorkerDto worker);

    void deleteById(UUID id);

    Mono<WorkerDto> update(WorkerDto worker);
}

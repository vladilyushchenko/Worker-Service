package com.leverx.reactive.workerservice.service;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkerService {

    @NonNull
    Flux<WorkerDto> findAll();
    
    Mono<WorkerDto> findById(UUID id);

    @NonNull
    Mono<WorkerDto> create(@NonNull WorkerDto worker);

    Mono<Void> deleteById(UUID id);

    Mono<WorkerDto> update(WorkerDto worker);
}

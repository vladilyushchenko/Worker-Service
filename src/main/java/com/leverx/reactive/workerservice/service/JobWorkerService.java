package com.leverx.reactive.workerservice.service;

import com.leverx.reactive.workerservice.entity.JobWorker;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.UUID;

public interface JobWorkerService {

    Flux<JobWorker> findAllByWorkerId(UUID workerId);

    Flux<Void> deleteAllWorkerById(UUID workerId);

    Flux<JobWorker> saveAll(Collection<JobWorker> jobWorkers);
}

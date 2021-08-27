package com.leverx.reactive.workerservice.service;

import com.leverx.reactive.workerservice.entity.JobWorker;
import reactor.core.publisher.Flux;

import java.util.Collection;

public interface JobWorkerService {

    Flux<JobWorker> saveAll(Collection<JobWorker> jobWorkers);
}

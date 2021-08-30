package com.leverx.reactive.workerservice.repository;

import com.leverx.reactive.workerservice.entity.JobWorker;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface JobWorkerRepository extends ReactiveCrudRepository<JobWorker, Long> {

    Flux<JobWorker> findAllByWorkerId(UUID workerId);

    Flux<Void> deleteAllByWorkerId(UUID workerId);
}

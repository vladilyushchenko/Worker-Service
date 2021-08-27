package com.leverx.reactive.workerservice.repository;

import com.leverx.reactive.workerservice.entity.JobWorker;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface JobWorkerRepository extends ReactiveCrudRepository<JobWorker, Long> {
}

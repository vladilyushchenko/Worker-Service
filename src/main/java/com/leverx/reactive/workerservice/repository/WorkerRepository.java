package com.leverx.reactive.workerservice.repository;

import com.leverx.reactive.workerservice.entity.Worker;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerRepository extends ReactiveCrudRepository<Worker, UUID> {
}

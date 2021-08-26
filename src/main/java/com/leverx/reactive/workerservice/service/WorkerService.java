package com.leverx.reactive.workerservice.service;

import com.leverx.reactive.workerservice.entity.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {

    List<Worker> findAll();

    Worker findById(UUID id);

    void deleteById(UUID id);

    Worker update(Worker worker);
}

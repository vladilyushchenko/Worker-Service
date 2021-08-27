package com.leverx.reactive.workerservice.service.impl;

import com.leverx.reactive.workerservice.entity.JobWorker;
import com.leverx.reactive.workerservice.repository.JobWorkerRepository;
import com.leverx.reactive.workerservice.service.JobWorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class JobWorkerServiceImpl implements JobWorkerService {

    private final JobWorkerRepository jobWorkerRepository;

    @Override
    public Flux<JobWorker> saveAll(Collection<JobWorker> jobWorkers) {
        return jobWorkerRepository.saveAll(jobWorkers);
    }
}

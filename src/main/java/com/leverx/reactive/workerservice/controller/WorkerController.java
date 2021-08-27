package com.leverx.reactive.workerservice.controller;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import com.leverx.reactive.workerservice.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public Flux<WorkerDto> findAll() {
        return workerService.findAll();
    }

    @PostMapping
    public Mono<WorkerDto> createWorker(@RequestBody WorkerDto workerDto) {
        return workerService.create(workerDto);
    }
}

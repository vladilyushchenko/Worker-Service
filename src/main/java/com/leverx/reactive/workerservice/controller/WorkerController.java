package com.leverx.reactive.workerservice.controller;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import com.leverx.reactive.workerservice.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping("/{id}")
    public Mono<WorkerDto> findAll(@PathVariable UUID id) {
        return workerService.findById(id);
    }

    @GetMapping
    public Flux<WorkerDto> findAll() {
        return workerService.findAll();
    }

    @PostMapping
    public Mono<WorkerDto> create(@Valid @RequestBody WorkerDto workerDto) {
        return workerService.create(workerDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return workerService.deleteById(id);
    }
}

package com.leverx.reactive.workerservice.controller;

import com.leverx.reactive.workerservice.dto.JobDto;
import com.leverx.reactive.workerservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public Mono<JobDto> createJob(@Valid @RequestBody JobDto jobDto) {
        return jobService.create(jobDto);
    }
}

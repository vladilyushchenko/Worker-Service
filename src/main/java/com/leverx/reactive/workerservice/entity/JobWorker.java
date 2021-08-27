package com.leverx.reactive.workerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("jobs_workers")
public class JobWorker {

    @Id
    private Long id;

    private UUID workerId;

    private UUID jobId;

    public JobWorker(UUID workerId, UUID jobId) {
        this.workerId = workerId;
        this.jobId = jobId;
    }
}

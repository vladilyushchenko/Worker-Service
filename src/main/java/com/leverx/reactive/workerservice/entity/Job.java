package com.leverx.reactive.workerservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@Table("jobs")
@NoArgsConstructor
public class Job extends BaseEntity {

    private String name;

    @Transient
    private Set<JobWorker> jobWorkers;
}

package com.leverx.reactive.workerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Worker extends BaseEntity {

    private String name;

    private String password;

    private Set<Job> jobs;

    public void addJob(Job job) {
        if (this.jobs == null) {
            jobs = newHashSet();
        }
        this.jobs.add(job);
        job.getWorkers().add(this);
    }

    public void removeJob(Job job) {
        if (this.jobs != null) {
            this.jobs.remove(job);
            job.getWorkers().remove(this);
        }
    }
}

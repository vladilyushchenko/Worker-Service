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
public class Job extends BaseEntity {

    private String name;

    private Set<Worker> workers;

    private Short version;

    public void addWorker(Worker worker) {
        if (this.workers == null) {
            this.workers = newHashSet();
        }
        this.workers.add(worker);
        worker.getJobs().add(this);
    }

    public void removeWorker(Worker worker) {
        if (this.workers != null) {
            this.workers.remove(worker);
            worker.getJobs().remove(this);
        }
    }
}

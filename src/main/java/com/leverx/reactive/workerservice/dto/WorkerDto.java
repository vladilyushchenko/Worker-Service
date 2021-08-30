package com.leverx.reactive.workerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WorkerDto extends ShortcutWorkerDto {

    private Set<ShortcutJobDto> jobs = newHashSet();
}

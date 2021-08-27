package com.leverx.reactive.workerservice.dto;

import lombok.*;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

// TODO: delete @ToString
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto extends ShortcutWorkerDto {

    private Set<ShortcutJobDto> jobs = newHashSet();
}

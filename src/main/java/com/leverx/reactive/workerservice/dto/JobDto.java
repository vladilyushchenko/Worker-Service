package com.leverx.reactive.workerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto extends ShortcutJobDto {

    private Set<ShortcutWorkerDto> workers = newHashSet();
}

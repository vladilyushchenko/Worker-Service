package com.leverx.reactive.workerservice.mapper;

import com.leverx.reactive.workerservice.dto.ShortcutJobDto;
import com.leverx.reactive.workerservice.entity.Job;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ShortcutJobMapper {

    ShortcutJobDto mapEntityToShortcutDto(Job job);

    Set<ShortcutJobDto> mapEntitySetToShortCutDto(Set<Job> jobs);
}

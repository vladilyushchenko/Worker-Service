package com.leverx.reactive.workerservice.mapper;

import com.leverx.reactive.workerservice.dto.JobDto;
import com.leverx.reactive.workerservice.entity.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ShortcutWorkerMapper.class)
public interface JobMapper {

    JobDto mapEntityToDto(Job job);

    Job mapDtoToEntity(JobDto jobDto);
}
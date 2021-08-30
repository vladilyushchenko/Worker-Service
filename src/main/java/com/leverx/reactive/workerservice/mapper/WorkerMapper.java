package com.leverx.reactive.workerservice.mapper;

import com.leverx.reactive.workerservice.dto.WorkerDto;
import com.leverx.reactive.workerservice.entity.Worker;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", uses = ShortcutJobMapper.class)
public interface WorkerMapper {

    WorkerDto mapEntityToDto(Worker worker);

    Worker mapDtoToEntity(WorkerDto workerDto);

    Set<WorkerDto> mapEntitySetToDto(Set<Worker> workers);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateWorkerFromDto(WorkerDto workerDto, @MappingTarget Worker worker);
}
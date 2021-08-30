package com.leverx.reactive.workerservice.mapper;

import com.leverx.reactive.workerservice.dto.ShortcutWorkerDto;
import com.leverx.reactive.workerservice.entity.Worker;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ShortcutWorkerMapper {

     ShortcutWorkerDto mapEntityToShortcutDto(Worker worker);

     Set<ShortcutWorkerDto> mapEntitySetToShortcutDto(Set<Worker> workers);
}

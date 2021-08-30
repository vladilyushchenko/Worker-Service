package com.leverx.reactive.workerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static java.lang.Boolean.FALSE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortcutJobDto {

    private UUID id;

    private Boolean deleted = FALSE;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    private String name;
}

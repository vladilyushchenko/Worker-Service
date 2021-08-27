package com.leverx.reactive.workerservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import static java.lang.Boolean.FALSE;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortcutWorkerDto {

    private UUID id;

    private Boolean deleted = FALSE;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    private String name;

    private String password;
}

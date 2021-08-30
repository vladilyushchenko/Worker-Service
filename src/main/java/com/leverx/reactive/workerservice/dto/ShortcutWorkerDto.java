package com.leverx.reactive.workerservice.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

import static java.lang.Boolean.FALSE;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ShortcutWorkerDto {

    private UUID id;

    private Boolean deleted = FALSE;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    @NotBlank(message = "Name should not be null.")
    private String name;

    @NotBlank(message = "Password should not be null.")
    private String password;
}

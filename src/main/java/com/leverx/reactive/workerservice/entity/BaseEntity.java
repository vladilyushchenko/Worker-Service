package com.leverx.reactive.workerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.LocalDate;
import java.util.UUID;

import static lombok.AccessLevel.PUBLIC;

@Getter(PUBLIC)
@Setter(PUBLIC)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    protected UUID id;

    protected Boolean deleted;

    @CreatedDate
    protected LocalDate createdAt;

    @LastModifiedDate
    protected LocalDate lastModifiedAt;

    @Version
    protected Short version;
}

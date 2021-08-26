package com.leverx.reactive.workerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

import static lombok.AccessLevel.PUBLIC;

@Getter(PUBLIC)
@Setter(PUBLIC)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    protected UUID id;

    protected Boolean deleted;

    protected Date createdAt;

    protected Date lastModifiedAt;
}

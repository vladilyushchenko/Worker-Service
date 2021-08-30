package com.leverx.reactive.workerservice.service.impl;

import com.leverx.reactive.workerservice.controller.WorkerController;
import com.leverx.reactive.workerservice.dto.WorkerDto;
import com.leverx.reactive.workerservice.service.WorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WorkerServiceImplTest {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private WorkerController workerController;

    @Test
    void create_NullDto_ShouldThrowException() throws Exception {
        workerService.create(null);

        throw new Exception("Not what I expected(((");
    }
}
package com.practice.controller;


import com.practice.dto.BankCodeRequestDto;
import com.practice.service.BankService;
import com.practice.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/employee")
@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 204, message = "Successful, no content."),
        @ApiResponse(code = 400, message = "Bad request. Validation failure."),
        @ApiResponse(code = 201, message = "Entity created"),
        @ApiResponse(code = 404, message = "Entity not found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
public class EmployeeController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get list of all employee", notes = "Get list of all employee")
    public ResponseEntity<Object> getEmployeeDetails() {
        logger.debug("Get employee details called at EmployeeController");
        return ResponseEntity.ok(employeeService.getAllEmployeeDetails());
    }
}
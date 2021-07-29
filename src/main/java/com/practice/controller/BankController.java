package com.practice.controller;


import com.practice.dto.BankCodeRequestDto;
import com.practice.service.BankService;
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
import java.util.List;

@RestController
@RequestMapping(value = "/bank")
@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 204, message = "Successful, no content."),
        @ApiResponse(code = 400, message = "Bad request. Validation failure."),
        @ApiResponse(code = 201, message = "Entity created"),
        @ApiResponse(code = 404, message = "Entity not found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
public class BankController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService bankService;

    @PostMapping(value = "/names", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get bank names by bankCode", notes = "Get bank names by bankCode")
    public ResponseEntity<Object> getBankDetails(@Valid @RequestBody BankCodeRequestDto bankCodeRequest) {
        logger.debug("Get bank details called at BankController");
        return ResponseEntity.ok(bankService.getBankNames(bankCodeRequest.getBankCodes()));
    }

}

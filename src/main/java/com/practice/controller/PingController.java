package com.practice.controller;

import com.practice.response.DataResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 204, message = "Successful, no content."),
        @ApiResponse(code = 400, message = "Bad request. Validation failure."),
        @ApiResponse(code = 201, message = "Entity created"),
        @ApiResponse(code = 404, message = "Entity not found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
public class PingController extends BaseController {

    Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping(value = "/status")
    @ApiOperation(value = "Ping application")
    public ResponseEntity<Object> getPingStatus() {
        logger.debug("Get ping for status is OK");
        return ResponseEntity.ok(new DataResponse(HttpStatus.OK.value(), "Success", HttpStatus.OK, null));
    }
}

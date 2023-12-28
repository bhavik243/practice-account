package com.practice.pubsub;

import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import com.practice.controller.BaseController;
import com.practice.controller.EmployeeController;
import com.practice.dto.EmployeeDto;
import com.practice.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/publish")
@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 204, message = "Successful, no content."),
        @ApiResponse(code = 400, message = "Bad request. Validation failure."),
        @ApiResponse(code = 201, message = "Entity created"),
        @ApiResponse(code = 404, message = "Entity not found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
public class PubSubPublishController extends BaseController {

    Logger logger = LoggerFactory.getLogger(PubSubPublishController.class);

    @Autowired
    private EmployeeService employeeService;

    private Publisher publisher;

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Publish Employee by Id", notes = "Publish Employee by Id")
    public ResponseEntity<Object> publishMessage(@PathVariable Integer id) {
        logger.debug("Get employee details called at EmployeeController");
        EmployeeDto employee = employeeService.getEmployeeById(id);
        if(publish(employee)) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    private boolean publish(EmployeeDto employee) {
        Publisher publisher = this.publisher;
        try {
            String topicId = "topic-test-1";
            // create a publisher on the topic
            if (publisher == null) {
                ProjectTopicName topicName =
                        ProjectTopicName.newBuilder()
                                .setProject(ServiceOptions.getDefaultProjectId())
                                .setTopic(topicId)
                                .build();
                publisher = Publisher.newBuilder(topicName).build();
            }
            // construct a pubsub message from the payload
            String payload = new Gson().toJson(employee);

            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(payload)).build();
            publisher.publish(pubsubMessage);
            // redirect to home page
            return true;
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage(), e);
            return false;
        }
    }

}

package com.fetcher.graphql.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface FetcherGraphQLController {
    //****************************************************************************
    @ApiOperation(value = "Fetcher with GraphQL version 1.0")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Error! Bad request"),
            @ApiResponse(code = 404, message = "Error! Data not found"),
            @ApiResponse(code = 408, message = "Error! Request Timeout"),
            @ApiResponse(code = 409, message = "Error! Conflict")
    })
    @PostMapping("/api/v1/fetch")
    ResponseEntity<Object> fetchQuestion(@RequestBody String request) throws IOException;
    //****************************************************************************
}

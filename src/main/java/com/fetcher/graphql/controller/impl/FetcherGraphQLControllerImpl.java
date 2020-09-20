package com.fetcher.graphql.controller.impl;

import com.fetcher.graphql.controller.FetcherGraphQLController;
import com.fetcher.graphql.service.FetcherGraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping
public class FetcherGraphQLControllerImpl implements FetcherGraphQLController {
    private final FetcherGraphQLService fetcherGraphQLService;

    @Autowired
    public FetcherGraphQLControllerImpl(FetcherGraphQLService fetcherGraphQLService) {
        this.fetcherGraphQLService = fetcherGraphQLService;
    }

    @Override
    public ResponseEntity<Object> fetchQuestion(String request) throws IOException {
        return new ResponseEntity<>(fetcherGraphQLService.getResult(request), HttpStatus.OK);
    }
}

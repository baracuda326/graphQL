package com.fetcher.graphql.service;

import graphql.ExecutionResult;

import java.io.IOException;

public interface FetcherGraphQLService {
    ExecutionResult getResult(String request) throws IOException;
}

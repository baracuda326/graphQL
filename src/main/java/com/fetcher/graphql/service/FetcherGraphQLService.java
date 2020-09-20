package com.fetcher.graphql.service;

import java.io.IOException;
import java.util.LinkedHashMap;

public interface FetcherGraphQLService {
    LinkedHashMap getResult(String request) throws IOException;
}

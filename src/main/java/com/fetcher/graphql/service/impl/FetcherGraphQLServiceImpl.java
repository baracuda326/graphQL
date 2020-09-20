package com.fetcher.graphql.service.impl;

import com.fetcher.graphql.model.Apartment;
import com.fetcher.graphql.repository.ApartmentRepository;
import com.fetcher.graphql.service.FetcherGraphQLService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service
public class FetcherGraphQLServiceImpl implements FetcherGraphQLService {
    private final ApartmentRepository apartmentRepository;
    private final AllApartmentDataFetcherImpl dataFetcherAll;
    private final ApartmentDataFetcherImpl apartmentDataFetcher;
    @Value("classpath:apartment.graphql")
    private Resource resource;
    private GraphQL graphQL;

    @Autowired
    public FetcherGraphQLServiceImpl(ApartmentRepository apartmentRepository
            , AllApartmentDataFetcherImpl dataFetcherAll
            , ApartmentDataFetcherImpl apartmentDataFetcher) {
        this.apartmentRepository = apartmentRepository;
        this.dataFetcherAll = dataFetcherAll;
        this.apartmentDataFetcher = apartmentDataFetcher;
    }

    @PostConstruct
    private void init() throws IOException {
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(Apartment.builder()
                .id("1")
                .apartmentUuid(UUID.randomUUID().toString())
                .description("test description 1")
                .floor("2")
                .imagesUrl("https://res.cloudinary.com/dvde7hpxw/image/upload/v1600451058/qsqigihuspnjhmooitfs.jpg")
                .title("title test")
                .livingSpace("150.0")
                .roomsNumber("5")
                .totalSpace("130.0")
                .build());
        apartments.add(Apartment.builder()
                .id("2")
                .apartmentUuid(UUID.randomUUID().toString())
                .description("test description 2")
                .floor("2")
                .imagesUrl("https://res.cloudinary.com/dvde7hpxw/image/upload/v1600451058/qsqigihuspnjhmooitfs.jpg")
                .title("title test")
                .livingSpace("100.0")
                .roomsNumber("3")
                .totalSpace("120.0")
                .build());
        apartmentRepository.saveAll(apartments);
        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allApartments", dataFetcherAll)
                        .dataFetcher("apartment", apartmentDataFetcher))
                .build();
    }

    @Override
    public LinkedHashMap getResult(String request) {
        return graphQL.execute(request).getData();
    }
}

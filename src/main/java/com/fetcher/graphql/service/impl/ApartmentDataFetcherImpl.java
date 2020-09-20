package com.fetcher.graphql.service.impl;

import com.fetcher.graphql.model.Apartment;
import com.fetcher.graphql.repository.ApartmentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApartmentDataFetcherImpl implements DataFetcher<Apartment> {
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentDataFetcherImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public Apartment get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        String id = dataFetchingEnvironment.getArgument("id");
        return apartmentRepository.findById(id).get();
    }
}

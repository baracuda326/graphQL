package com.fetcher.graphql.service.impl;

import com.fetcher.graphql.model.Apartment;
import com.fetcher.graphql.repository.ApartmentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllApartmentDataFetcherImpl implements DataFetcher<List<Apartment>> {
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public AllApartmentDataFetcherImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public List<Apartment> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        return apartmentRepository.findAll();
    }
}

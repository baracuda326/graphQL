package com.fetcher.graphql.repository;

import com.fetcher.graphql.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment,String> {
}

package com.fetcher.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Apartment {
    @Id
    private String id;
    private String apartmentUuid;
    private String title;
    private String imagesUrl;
    private String description;
    private String totalSpace;
    private String livingSpace;
    private String floor;
    private String roomsNumber;
}

package com.blood.donation.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Search {
    private String type;
    private String city;
}

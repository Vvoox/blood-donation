package com.blood.donation.models;


import com.blood.donation.enumurations.BloodType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Search {
    private String bloodType;
    private String city;
}

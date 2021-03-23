package com.blood.donation.models;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TypeSearch {
    private List<String> bloodType;
}

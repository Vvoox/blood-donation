package com.blood.donation.models;


import com.blood.donation.enumurations.BloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate demandDate;
    private String city;
    private String hospital;
    private String type;
    private String description;
    private BloodType bloodType;

    @OneToMany
    private List<User> subscribedUser;
}

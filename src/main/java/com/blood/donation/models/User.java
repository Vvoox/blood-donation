package com.blood.donation.models;


import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate date;
    private UserStatus status;
    private String address;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
    private BloodType bloodType;

    @CreatedDate
    private Timestamp creationDate;
    @LastModifiedDate
    private Timestamp modifiedDate;


}

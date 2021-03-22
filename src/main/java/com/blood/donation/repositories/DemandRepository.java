package com.blood.donation.repositories;

import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import com.blood.donation.models.Demand;
import com.blood.donation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand,Long> {

}

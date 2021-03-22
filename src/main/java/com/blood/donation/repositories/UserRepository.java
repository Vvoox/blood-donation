package com.blood.donation.repositories;

import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import com.blood.donation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByBloodType(BloodType bloodType);
    List<User> findAllByCityAndBloodType(String city , BloodType bloodType);
    List<User> findAllByStatusAndBloodTypeAndCity(UserStatus userStatus,BloodType bloodType,String city);
    List<User> findAllByCityAndBloodTypeAndStatusIsNot(String city,BloodType bloodType,UserStatus userStatus);
}

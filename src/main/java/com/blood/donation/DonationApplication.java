package com.blood.donation;

import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import com.blood.donation.models.Demand;
import com.blood.donation.models.User;
import com.blood.donation.repositories.DemandRepository;
import com.blood.donation.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class DonationApplication implements CommandLineRunner{

    private final UserRepository userRepository;
    private final DemandRepository demandRepository;
    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        User user = User.builder()
                .firstName("Khalil")
                .lastName("Daoulat")
                .city("MARRAKECH")
                .country("Morocco")
                .address("Massira 1")
                .status(UserStatus.GIVER)
                .bloodType(BloodType.O_POSITIVE)
                .phoneNumber("+21212345679")
                .date(LocalDate.now())
                .build();
        User user1 = User.builder()
                .firstName("Oussama")
                .lastName("Lahmidi")
                .city("EL Kalaa")
                .country("Morocco")
                .status(UserStatus.BENEFICIARY)
                .bloodType(BloodType.A_POSITIVE)
                .address("Kalaa 11")
                .phoneNumber("+212874859621")
                .date(LocalDate.now())
                .build();
        User user2 = User.builder()
                .firstName("Ghani")
                .lastName("Lahmidi")
                .city("Marrakech")
                .country("Morocco")
                .bloodType(BloodType.A_NEGATIVE)
                .address("Kalaa 11")
                .status(UserStatus.BOTH)
                .phoneNumber("+212874859621")
                .date(LocalDate.now())
                .build();

        Demand demand = Demand.builder()
                .demandDate(LocalDate.now())
                .city("Marrakech")
                .hospital("CHU")
                .bloodType(BloodType.O_POSITIVE)
                .build();
        Demand demand1 = Demand.builder()
                .demandDate(LocalDate.now())
                .city("Marrakech")
                .hospital("RAZI")
                .bloodType(BloodType.O_NEGATIVE)
                .build();



        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        demandRepository.save(demand);
        demandRepository.save(demand1);


    }
}

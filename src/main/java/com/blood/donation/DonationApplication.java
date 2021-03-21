package com.blood.donation;

import com.blood.donation.models.Beneficiary;
import com.blood.donation.models.Giver;
import com.blood.donation.models.User;
import com.blood.donation.repositories.BeneficiaryRepository;
import com.blood.donation.repositories.GiverRepository;
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
    private final GiverRepository giverRepository;
    private final BeneficiaryRepository beneficiaryRepository;
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
                .phoneNumber("+21212345679")
                .date(LocalDate.now())
                .build();
        User user1 = User.builder()
                .firstName("Oussama")
                .lastName("Lahmidi")
                .city("EL Kalaa")
                .country("Morocco")
                .address("Kalaa 11")
                .phoneNumber("+212874859621")
                .date(LocalDate.now())
                .build();

        Giver giver = Giver.builder()
                .typeBlood("O+")
                .user(user)
                .build();

        Beneficiary beneficiary = Beneficiary.builder()
                .user(user1)
                .build();

        userRepository.save(user1);
        userRepository.save(user);
        beneficiaryRepository.save(beneficiary);
        giverRepository.save(giver);

    }
}

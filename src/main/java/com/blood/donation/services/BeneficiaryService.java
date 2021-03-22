//package com.blood.donation.services;
//
//import com.blood.donation.models.Beneficiary;
//import com.blood.donation.repositories.BeneficiaryRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class BeneficiaryService {
//
//    private final BeneficiaryRepository beneficiaryRepository;
//
//    public Beneficiary getBeneficiary(long id){
//        return beneficiaryRepository.findById(id).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Beneficiary not found")
//        );
//    }
//}

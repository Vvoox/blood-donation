package com.blood.donation.services;


import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import com.blood.donation.models.Demand;
import com.blood.donation.models.Search;
import com.blood.donation.models.User;
import com.blood.donation.repositories.DemandRepository;
import com.blood.donation.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class DemandService {

    private final DemandRepository demandRepository;

    public List<Demand> getAllDemand(){ return demandRepository.findAll();}

    public Demand getDemandById(long id){
        return demandRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Demand not found")
        );
    }

    public Demand addDemand(Demand demand){
        BloodType bloodType = BloodType.valueOf(demand.getType().toUpperCase(Locale.ROOT));
        demand.setBloodType(bloodType);
        return demandRepository.save(demand);
    }

    public Demand modifyDemand(long id , Demand demand){

        BloodType bloodType = BloodType.valueOf(demand.getType().toUpperCase(Locale.ROOT));
        getDemandById(id);
        demand.setId(id);
        demand.setBloodType(bloodType);
        return demandRepository.save(demand);
    }
    public Map<String, String> deleteDemand(long id){
        getDemandById(id);
        demandRepository.deleteById(id);
        return Map.of("Success","true");
    }


}

//package com.blood.donation.services;
//
//import com.blood.donation.models.Beneficiary;
//import com.blood.donation.models.Giver;
//import com.blood.donation.models.Search;
//import com.blood.donation.models.User;
//import com.blood.donation.repositories.GiverRepository;
//import com.blood.donation.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class GiverService {
//
////    private final GiverRepository giverRepository;
////    private final UserRepository userRepository;
////
////    public Giver getGiverById(long id){
////        return giverRepository.findById(id).orElseThrow(
////                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Giver not found!")
////        );
////    }
////    public List<Giver> getGiversByTypeBlood(String typeBlood){
////        String type = typeBlood.toUpperCase(Locale.ROOT);
////        return giverRepository.findAllByTypeBlood(type);
////    }
////    public List<Giver> getGiversByCity(String city){
////        String ct = city.toUpperCase(Locale.ROOT);
////        return giverRepository.findAllByUser_City(city);
////    }
////    public List<Giver> getGiversByTypeBloodAndCity(Search search){
////        log.info(search);
////        String type = search.getType().toUpperCase(Locale.ROOT);
////        String currentCity = search.getCity().toUpperCase(Locale.ROOT);
////        return giverRepository.findAllByTypeBloodAndUser_City(type,currentCity);
////    }
////
////    public List<Giver> getAllGivers(){
////        return giverRepository.findAll(); }
////
////    public Giver addGiver(Giver giver){
////        User user = giver.getUser();
////        userRepository.save(user);
////        return giverRepository.save(giver);
////    }
////    public Giver  modifyGiver(long id,Giver giver){
////        Giver oldGiver = getGiverById(id);
////        giver.setId(oldGiver.getId());
////        return giverRepository.save(giver);
////    }
////
////    public Map<String,String> deleteGiver(long id){
////        Giver giver = getGiverById(id);
////        giverRepository.deleteById(giver.getId());
////        return Map.of("Success","true");
////    }
//
//
//}

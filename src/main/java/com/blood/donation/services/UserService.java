package com.blood.donation.services;


import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import com.blood.donation.models.Search;
import com.blood.donation.models.TypeSearch;
import com.blood.donation.models.User;
import com.blood.donation.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")
        );
    }

    public List<User> getUserByType(String type){
        BloodType bloodType = BloodType.valueOf(type.toUpperCase(Locale.ROOT));
        return userRepository.findAllByBloodType(bloodType);
    }

    public List<User> findGiversByCityAndBloodType(Search search){
        String blood  = search.getBloodType().toUpperCase(Locale.ROOT);
        BloodType bloodType = BloodType.valueOf(blood);
        String currentCity = search.getCity().toUpperCase(Locale.ROOT);
        return userRepository.findAllByCityAndBloodTypeAndStatusIsNot(currentCity,bloodType,UserStatus.BENEFICIARY);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User modifyUser(long id , User user){
        getUserById(id);
        user.setId(id);
        return userRepository.save(user);
    }
    
    public Map<String,String> deleteUser(long id){
        User user = getUserById(id);
        userRepository.deleteById(user.getId());
        return Map.of("Success","true");
    }

    public  Map<String,String> changeUserStatus(long id , String status){
        UserStatus userStatus = UserStatus.valueOf(status.toUpperCase(Locale.ROOT));
        User user = getUserById(id);
        user.setStatus(userStatus);
        userRepository.save(user);
        return Map.of("Success","true");
    }

    public List<User> getAllTypes(List<String> typeSearch){
        List<User> allUsers = new ArrayList<>();
       typeSearch.forEach(type ->{
           log.info(type);
           BloodType bloodType = BloodType.valueOf(type.toUpperCase(Locale.ROOT));
           allUsers.addAll(userRepository.findAllByBloodType(bloodType));
       });
       log.info(allUsers);
       return allUsers;
    }
}

package com.blood.donation.services;


import com.blood.donation.enumurations.BloodType;
import com.blood.donation.enumurations.UserStatus;
import com.blood.donation.models.Search;
import com.blood.donation.models.User;
import com.blood.donation.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
}

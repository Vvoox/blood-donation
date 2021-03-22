package com.blood.donation.controllers;

import com.blood.donation.models.Search;
import com.blood.donation.models.User;
import com.blood.donation.repositories.UserRepository;
import com.blood.donation.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
@Log4j2
@RequiredArgsConstructor
@Api(description = "User APIs")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/all")
    private List<User> getUser(){
        log.info("Fetch All User");
        return userRepository.findAll();
    }

    @GetMapping("/type")
    private List<User> getUserByType(@RequestParam String type){
        log.info("Fetch User by type");
        try{
            return userService.getUserByType(type);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @GetMapping()
    @ApiOperation(value = "Get All Givers with city and blood type")
    public List<User> getGiversByTypeAndCity(@RequestBody Search search){
        return userService.findGiversByCityAndBloodType(search);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add user")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}/modify")
    @ApiOperation(value = "Modify user")
    public User modifyUser(@PathVariable long id , @RequestBody User user){
        return userService.modifyUser(id,user);
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation(value = "Delete User")
    public Map<String, String> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }


}

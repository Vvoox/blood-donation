package com.blood.donation.controllers;

import com.blood.donation.models.Search;
import com.blood.donation.models.User;
import com.blood.donation.repositories.UserRepository;
import com.blood.donation.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

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

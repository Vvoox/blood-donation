//package com.blood.donation.controllers;
//
//import com.blood.donation.models.Giver;
//import com.blood.donation.models.Search;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/giver")
//@RequiredArgsConstructor
//@CrossOrigin("*")
//@Log4j2
//public class GiverController {
//
////    private final GiverService giverService;
////
////    @GetMapping("/{type}")
////    public List<Giver> getGiverByTypeBlood(@PathVariable String type){
////        return giverService.getGiversByTypeBlood(type);
////    }
////
////    @GetMapping("/search")
////    public List<Giver> getGiverByTypeBlood(@RequestBody Search search){
////        return giverService.getGiversByTypeBloodAndCity(search);
////    }
////
////
////    @GetMapping("/all")
////    public List<Giver> getAllGiver(){
////        log.info("Fetch all givers");
////        return giverService.getAllGivers();
////    }
////
////    @PostMapping("/add")
////    public Giver addGiver(@RequestBody Giver giver){
////        return giverService.addGiver(giver);
////    }
////
////    @PutMapping("/{id}/modify")
////    public Giver modifyGiver(@PathVariable long id , @RequestBody Giver giver){
////        return giverService.modifyGiver(id,giver);
////    }
////
////    @DeleteMapping("/{id}/delete")
////    public Map<String,String> deleteGiver(@PathVariable long id){
////        return giverService.deleteGiver(id);
////    }
//
//}

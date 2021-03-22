package com.blood.donation.controllers;

import com.blood.donation.models.Demand;
import com.blood.donation.models.Search;
import com.blood.donation.models.User;
import com.blood.donation.services.DemandService;
import com.blood.donation.services.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/demand")
@Log4j2
@RequiredArgsConstructor
@Api(description = "Demand APIs")
public class DemandController {

    private final DemandService demandService;

    @GetMapping
    public List<Demand> getDemands(){return demandService.getAllDemand();}

    @GetMapping("/{id}")
    public Demand getDemandById(@PathVariable long id){
        return demandService.getDemandById(id);
    }

    @PostMapping("/add")
    public Demand addDemand(@RequestBody Demand demand){
        return demandService.addDemand(demand);
    }

    @PutMapping("/{id}/modify")
    public Demand modifyDemand(@PathVariable long id,@RequestBody Demand demand){
        return demandService.modifyDemand(id,demand);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String, String> deleteDemand(@PathVariable long id){
        return demandService.deleteDemand(id);
    }
}

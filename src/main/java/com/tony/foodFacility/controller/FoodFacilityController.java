package com.tony.foodFacility.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tony.foodFacility.entity.FoodFacilityType;
import com.tony.foodFacility.service.FoodFacilityService;
/**
 * @author Tony
 */
@RestController
@RequestMapping("/foodFacility/v1")
public class FoodFacilityController {

    private FoodFacilityService foodFacilityService;

    public FoodFacilityController(FoodFacilityService foodFacilityService) {
        this.foodFacilityService = foodFacilityService;
    }

    // get all shops
    @GetMapping("/getAll")
    public ResponseEntity<List<FoodFacilityType>> getAll() {
        List<FoodFacilityType> foodFacilityList = foodFacilityService.getAll();
        return new ResponseEntity<>(foodFacilityList, HttpStatus.OK);
    }

    // get list by its applicant
    @GetMapping("/{applicant}")
    public ResponseEntity<List<FoodFacilityType>> getShopByLocationId(@PathVariable String applicant) throws ExecutionException {
        List<FoodFacilityType> foodFacilityList = foodFacilityService.getByApplicant(applicant);
        if (foodFacilityList != null) {
            return new ResponseEntity<>(foodFacilityList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

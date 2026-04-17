package com.example.housepriceanalyticsapi.controller;

import com.example.housepriceanalyticsapi.model.AveragePriceByLocationDto;
import com.example.housepriceanalyticsapi.model.House;
import com.example.housepriceanalyticsapi.service.HouseService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/saveAll")
    public List<House> saveAllData(@RequestBody List<House> houseList) {
        return houseService.saveAll(houseList);
    }

    @GetMapping("/averagePrice")
    public BigDecimal AverageHouseSellPrice() {
        return houseService.AverageHouseSellPrice();
    }

    @GetMapping("/averagePriceByLocation")
    public List<AveragePriceByLocationDto> averagePriceByLocationDto() {
        return houseService.averagePriceByLocationDto();
    }

    @GetMapping("/maxPrice")
    public BigDecimal maxPrice() {
        return houseService.maxPrice();
    }

    @GetMapping("/averagePriceByGivenLocation")
    public Double averagePriceByGivenLocation(@RequestParam String location) {
        return houseService.averagePriceByGivenLocation(location);
    }

}

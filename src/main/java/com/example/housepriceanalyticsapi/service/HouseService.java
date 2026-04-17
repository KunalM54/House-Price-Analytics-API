package com.example.housepriceanalyticsapi.service;

import com.example.housepriceanalyticsapi.model.AveragePriceByLocationDto;
import com.example.housepriceanalyticsapi.model.House;
import com.example.housepriceanalyticsapi.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> saveAll(List<House> houseList) {
        return houseRepository.saveAll(houseList);
    }

    public BigDecimal AverageHouseSellPrice() {
        return houseRepository.averageSellPrice();
    }

    public List<AveragePriceByLocationDto> averagePriceByLocationDto() {
        return houseRepository.averagePriceByLocation();
    }

    public BigDecimal maxPrice(){
        return houseRepository.maxPrice();
    }

    public Double averagePriceByGivenLocation(String location) {
        return houseRepository.averagePriceByGivenLocation(location);
    }
}

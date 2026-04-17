package com.example.housepriceanalyticsapi.model;

import java.math.BigDecimal;
import java.util.List;

public class AveragePriceByLocationDto {
    private String location;
    private Double averagePrice;

    public AveragePriceByLocationDto(String location, Double averagePrice) {
        this.location = location;
        this.averagePrice = averagePrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

}

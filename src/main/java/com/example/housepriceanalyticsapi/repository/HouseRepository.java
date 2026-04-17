package com.example.housepriceanalyticsapi.repository;

import com.example.housepriceanalyticsapi.model.AveragePriceByLocationDto;
import com.example.housepriceanalyticsapi.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query(value = "select AVG(sale_price) from house", nativeQuery = true)
    BigDecimal averageSellPrice();


    @Query("select new com.example.housepriceanalyticsapi.model.AveragePriceByLocationDto(h.location, avg(h.salePrice)) from House h group by h.location")
    List<AveragePriceByLocationDto> averagePriceByLocation();

    @Query(value = "select max(sale_price) from house",nativeQuery = true)
    BigDecimal maxPrice();

    @Query(value = "SELECT AVG(sale_price) FROM house WHERE location = ?1",
            nativeQuery = true)
    Double averagePriceByGivenLocation(String location);
}

# House Price Analytics API

A Spring Boot REST API for analyzing house price data with aggregated statistics by location and price metrics.

## Overview

This application provides analytics capabilities for real estate data. It stores house information with bedrooms, bathrooms, square footage, location, and sale price. The API offers aggregated price analytics including average, maximum, and location-based price calculations.

## Features

* House Data Management
* Average Sale Price Calculation
* Maximum Sale Price
* Average Price by Location
* Location-Specific Price Query

## Tech Stack

* Java 17
* Spring Boot 4.0.3
* Spring Data JPA
* Spring Web MVC
* MySQL

## System Design / How It Works

1. House data is saved with bedrooms, bathrooms, square footage, location, and sale price
2. Average sell price is calculated using native SQL AVG query
3. Maximum price is retrieved using native SQL MAX query
4. Average price grouped by location uses JPQL query with custom DTO projection
5. Location-specific average price is queried using parameterized native SQL

## Project Structure

```text
com.example.housepriceanalyticsapi
├── HouseApplication.java
├── controller
│   └── HouseController.java
├── service
│   └── HouseService.java
├── repository
│   └── HouseRepository.java
└── model
    ├── House.java
    └── AveragePriceByLocationDto.java
```

## Setup & Installation

1. Ensure Java 17 and Maven are installed
2. Create MySQL database
3. Configure `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
4. Run `mvn spring-boot:run`

## API Endpoints

Base path: `http://localhost:8080/house`

### 1) Save All Houses

* **POST** `/house/saveAll`
* **Request Body**: Array of house objects

```http
POST /house/saveAll
[
  {"bedrooms":3,"bathrooms":2.5,"squareFootage":1500,"location":"New York","salePrice":450000}
]
```

### 2) Get Average Price

* **GET** `/house/averagePrice`

```http
GET /house/averagePrice
```

### 3) Get Average Price By Location

* **GET** `/house/averagePriceByLocation`

```http
GET /house/averagePriceByLocation
```

### 4) Get Max Price

* **GET** `/house/maxPrice`

```http
GET /house/maxPrice
```

### 5) Get Average Price By Given Location

* **GET** `/house/averagePriceByGivenLocation`
* **Query Params**: location

```http
GET /house/averagePriceByGivenLocation?location=New York
```

## Database Schema

### `house`

* `id` (PK)
* `bedrooms`
* `bathrooms`
* `squareFootage`
* `location`
* `salePrice`

## Configuration Notes

* `spring.application.name=house-price-analytics-api`
* `spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name`
* `spring.datasource.username=your_username`
* `spring.datasource.password=your_password`
* `spring.jpa.hibernate.ddl-auto=update`
* `spring.jpa.show-sql=true`

## Future Improvements

* Add price prediction endpoint
* Implement date range filtering
* Add pagination support
* Support additional aggregation metrics

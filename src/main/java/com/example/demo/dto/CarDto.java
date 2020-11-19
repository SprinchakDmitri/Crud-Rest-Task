package com.example.demo.dto;

import com.example.demo.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private long id;
    private String carModel;
    private String carType;
    private String carBrand;
    private int carPrice;
    private double engineVolume;

    public CarDto(Car car){
        this.id = car.getId();
        this.carModel = car.getCarModel();
        this.carPrice = car.getCarPrice();
        this.engineVolume = car.getEngineVolume();
        this.carType = car.getCarType();
        this.carBrand = car.getBrandName();
    }
}

package com.example.demo.model;


import com.example.demo.dto.CarDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
@NoArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    long id;

    @Column(name = "car_model")
    String carModel;

    @Column(name = "car_type")
    String carType;

    @Column(name = "engine_volume")
    double engineVolume;

    @Column(name = "car_price")
    int carPrice;

    @Column(name = "car_brand")
    String brandName;

    public Car(CarDto carDto){
        this.id = carDto.getId();
        this.carModel = carDto.getCarModel();
        this.carPrice = carDto.getCarPrice();
        this.carType = carDto.getCarType();
        this.brandName = carDto.getCarBrand();
    }
}
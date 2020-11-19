package com.example.demo.service;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Car;
import com.example.demo.dto.CarDto;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

     @Autowired
    private CarRepository carRepository;


    public CarDto getCarById(final Long id) throws CustomException {
        try {
            return new CarDto(carRepository.findCarById(id));
        } catch (Exception e) {
            throw new CustomException(e);
        }
    }


    public List<CarDto> getAllCars() throws CustomException {

       try {
           List<CarDto> carDtos = new ArrayList<>();

           for (Car car : carRepository.findAll()) {
               carDtos.add(new CarDto(car));
           }
           return carDtos;

       }catch (Exception e){
           throw new CustomException(e);
       }

    }

    public void deleteCarById(final Long id) throws CustomException {
        try{
            carRepository.deleteById(id);
        }catch (Exception e){
            throw new CustomException(e);
        }

    }

    public void updateCarById(CarDto carDto) throws CustomException {
        Optional<Car> optionalCar = carRepository.findById(carDto.getId());

        if(optionalCar.isEmpty()) throw new IllegalArgumentException();
        Car updatedCar = optionalCar.get();
        updatedCar.setCarModel(carDto.getCarModel());
        updatedCar.setBrandName(carDto.getCarBrand());
        updatedCar.setCarPrice(carDto.getCarPrice());
        updatedCar.setCarType(carDto.getCarType());
        updatedCar.setEngineVolume(carDto.getEngineVolume());
        try{
            carRepository.save(updatedCar);
        }catch (Exception e){
            throw new CustomException(e);
        };

    }


    public void saveCar(CarDto carDto) throws CustomException {
        try{
            carRepository.save(new Car(carDto));
        }catch (Exception e){
            throw new CustomException(e);
        }

    }
}

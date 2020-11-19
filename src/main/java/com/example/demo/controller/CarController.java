package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<CarDto> getAllCars() throws Exception {
        return carService.getAllCars();
    }

    @GetMapping("/id/{id}")
    public CarDto getCarById(@PathVariable Long id) throws Exception {
        return carService.getCarById(id);
    }

    @PostMapping("/save")
    public void saveCar(@RequestBody CarDto carDto) throws Exception {
        carService.saveCar(carDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable Long id) throws Exception {
        carService.deleteCarById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCarById(@RequestBody CarDto carDto,@PathVariable Long id) throws Exception{
        carDto.setId(id);
        carService.updateCarById(carDto);
    }



}

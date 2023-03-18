package com.javamasterclass.car;

import java.math.BigDecimal;
import java.util.UUID;

public class CarDAO {
    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("1289",
                        UUID.fromString("2aca6627-7808-4d88-b733-315890813606"),Brand.TESLA,TypeOfCar.ELECTRIC
                        , new BigDecimal("90.0")),
                new Car("5732",
                        UUID.fromString("0cd3f325-c918-44ee-86a5-1ab8262c6a32"),Brand.AUDI,TypeOfCar.PETROL,
                        new BigDecimal("50.0")),
                new Car("2435"
                        ,UUID.fromString("35db43ef-2d03-45ac-8043-514eb3bb2e5b"),Brand.DODGE, TypeOfCar.PETROL,
                        new BigDecimal("86.0")),
                new Car("1473",
                        UUID.fromString("98e9e89a-5166-4cf1-9584-e45da721f30c"),Brand.BMW,TypeOfCar.ELECTRIC,
                        new BigDecimal("95.0")),
                new Car("9483",
                        UUID.fromString("3488c095-22ab-45d9-a1cd-daf6ddd349f0"),Brand.AUDI,TypeOfCar.ELECTRIC,
                        new BigDecimal("100.0"))
        };
    }
    public Car[] getAllCars(){
        return cars;
    }
}

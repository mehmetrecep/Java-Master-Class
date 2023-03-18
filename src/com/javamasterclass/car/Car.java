package com.javamasterclass.car;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Car {
    private UUID uuid;
    private Brand brand;
    private TypeOfCar typeOfCar;
    private boolean isElectrical;
    private BigDecimal price;
    private String regNum;
    private boolean isBooked;

    public Car(String regNum,UUID uuid, Brand brand, TypeOfCar typeOfCar,BigDecimal price) {
        this.regNum = regNum;
        this.uuid = uuid;
        this.brand = brand;
        this.typeOfCar = typeOfCar;
        if(typeOfCar.equals(TypeOfCar.ELECTRIC)){
            isElectrical = true;
        }else isElectrical = false;
        this.price = price;
       this.isBooked = false;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public boolean isElectrical() {
        return isElectrical;
    }

    public void setElectrical(boolean electrical) {
        isElectrical = electrical;
    }

    public Car(Brand brand, TypeOfCar typeOfCar) {
        this.brand = brand;
        this.typeOfCar = typeOfCar;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(uuid, car.uuid) && brand == car.brand && typeOfCar == car.typeOfCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, brand, typeOfCar);
    }

    @Override
    public String toString() {
        return "Car{" +
                "uuid=" + uuid +
                ", brand=" + brand +
                ", typeOfCar=" + typeOfCar +
                ", isElectrical=" + isElectrical +
                ", price=" + price +
                ", regNum=" + regNum +
                ", isBooked=" + isBooked +
                '}';
    }
}

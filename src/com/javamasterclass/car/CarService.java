package com.javamasterclass.car;

public class CarService {
    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public Car[] getAllCars(){
        return carDAO.getAllCars();
    }
    public Car getCar(String regNum){
        for(Car car : getAllCars()){
            if(car.getRegNum().equals(regNum)){
                return car;
            }
        }
        throw new IllegalStateException("There's no car with this number ");
    }

    public Car[] getElectricCars(){
        Car[] cars = getAllCars();

        if(cars.length==0){
            return new Car[0];
        }

        int count = 0;
        int index = 0;

        for(Car car : cars){
            if(car.isElectrical()){
                count++;
            }
        }
        if(count == 0){
            return new Car[0];
        }
        Car[] electricCars = new Car[count];
        for (Car car : cars){
            if(car.isElectrical()){
                electricCars[index++]= car;
            }
        }
        return electricCars;
    }
}

package com.javamasterclass.bookingcar;

import com.javamasterclass.car.Car;
import com.javamasterclass.car.CarService;
import com.javamasterclass.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarBookingService {
    private CarBookingDAO carBookingDAO;
    private CarService carService;

    public CarBookingService(CarBookingDAO carBookingDAO, CarService carService) {
        this.carBookingDAO = carBookingDAO;
        this.carService = carService;
    }



    public Car[] getBookedCarsForUser(UUID userId) {

        CarBooking[] carBookings = carBookingDAO.getCarBookings();

        int bookedCars = 0;
        for (CarBooking carb : carBookings) {
            if (carb != null && carb.getUser().getUuid().equals(userId)) {
                ++bookedCars;
            }
        }
        if (bookedCars == 0) {
            return new Car[0];
        }
        Car[] numberOfBookedCarForUser = new Car[bookedCars];

        int newIndex = 0;
        for (CarBooking carB : carBookings) {
            if (carB != null && carB.getUser().getUuid().equals(userId)) {
                numberOfBookedCarForUser[newIndex++] = carB.getCar();
            }
        }
        return numberOfBookedCarForUser;
    }

    public Car[] getAvailableCars(){

//        CarBooking[] carBookings = carBookingDAO.getCarBookings();
//
//        int availableCar = 0;
//        for(CarBooking cb : carBookings){
//            if(!cb.getCar().isBooked() && cb != null ){
//                availableCar++;
//            }
//        }
//
//        Car[] availableCars = new Car[availableCar];
//
//        int count = 0;
//        for (CarBooking car : carBookings){
//            if(!car.getCar().isBooked()){
//                availableCars[count++] = car.getCar();
//            }
//        }
//        return availableCars;
       return getCars(carService.getAllCars());
    }

    public UUID bookingCar(User user, String regisNumber ){
        Car[] availableCars = getAvailableCars();
        if(availableCars.length==0){
            throw new IllegalStateException("Unfortunately, No available Car");
        }
        for(Car car : availableCars){
            if(car.getRegNum().equals(regisNumber)){
                Car c = carService.getCar(regisNumber);
                UUID bookingId = UUID.randomUUID();
                carBookingDAO.booked(new CarBooking(c,user, LocalDateTime.now()));
                return bookingId;
            }
        }
        throw new IllegalStateException("Car with "+regisNumber+" is already booked");
    }

    public CarBooking[] getBookings(){

        CarBooking[] carBookings = carBookingDAO.getCarBookings();

        int index = 0;
        for(CarBooking cb : carBookings){
            if(cb != null){
                ++index;
            }
        }
        if(index == 0){
            return new CarBooking[0];
        }

        CarBooking[] bookings = new CarBooking[index];

        int count = 0;
        for(CarBooking cab : carBookings){
            if (cab != null){
                bookings[count++] = cab;
            }
        }
        return bookings;
    }

    public Car[] getElectricCars(){
        return getCars(carService.getElectricCars());
    }
    private Car[] getCars(Car[] cars){
        if(cars.length==0){
            return new Car[0];
        }
        CarBooking[] bookings = carBookingDAO.getCarBookings();
        if(bookings.length == 0){
            return cars;
        }
        int availableCarsCount = 0;
        for(Car car : cars){
            boolean booked = false;
            for(CarBooking carBooking : bookings){
                if(carBooking == null || !carBooking.getCar().equals(car)){
                    continue;
                }
                booked = true;
            }
            if(!booked){
                ++availableCarsCount;
            }
        }
        Car[] availableCars = new Car[availableCarsCount];
        int idex = 0;
        for(Car car : cars){
            boolean booked = false;
            for(CarBooking carBooking : bookings){
                if(carBooking == null || !carBooking.getCar().equals(car)){
                    continue;
                }
                booked = true;
            }
            if(!booked){
                availableCars[idex++] = car;
            }
        }
        return availableCars;
    }

}

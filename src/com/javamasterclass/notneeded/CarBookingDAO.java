//package com.javamasterclass.notneeded;
//
//import com.javamasterclass.bookingcar.CarBooking;
//import com.javamasterclass.car.Car;
//import com.javamasterclass.car.CarDAO;
//import com.javamasterclass.car.CarService;
//import com.javamasterclass.user.UserService;
//
//public class CarBookingDAO {
//    private static final CarBooking[] CAR_BOOKINGS;
//    private UserService userService;
//
//    public CarBookingDAO(UserService userService, CarDAO carDAO) {
//        this.userService = userService;
//        this.carDAO = carDAO;
//    }
//
//    public CarBookingDAO() {
//    }
//
//    private CarDAO carDAO;
//
//    static {
//        //CAR_BOOKINGS = new CarBooking[CarBooking.CAR_BOOKINGS.length];
//    }
//
//    public Car[] car(CarDAO carDAO) {
//        return carDAO.getCars();
//    }
//
//    public CarBooking[] carBookings(){
//        return CAR_BOOKINGS;
//    }
//}

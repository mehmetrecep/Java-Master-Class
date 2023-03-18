package com.javamasterclass;

//import com.javamasterclass.notneeded.CarBookingDAO;
//import com.javamasterclass.notneeded.CarBookingService2;
import com.javamasterclass.bookingcar.CarBooking;
import com.javamasterclass.bookingcar.CarBookingDAO;
import com.javamasterclass.bookingcar.CarBookingService;
import com.javamasterclass.car.Car;
import com.javamasterclass.car.CarDAO;
import com.javamasterclass.car.CarService;
import com.javamasterclass.user.User;
import com.javamasterclass.user.UserArrayDataAccessService;
import com.javamasterclass.user.UserDAO;
import com.javamasterclass.user.UserService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

//        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
//        UserService userService = new UserService(userArrayDataAccessService);
//        System.out.println(Arrays.toString(userService.getAllUsers(userArrayDataAccessService.getUsers())));
//        System.out.println();
//        CarDAO carDAO = new CarDAO();
//        CarService carService = new CarService(carDAO);
//        System.out.println(Arrays.toString(carService.getAllCars()));
//        System.out.println();
//        CarBookingDAO carBookingDAO = new CarBookingDAO();
//        System.out.println(Arrays.toString(carBookingDAO.car(carDAO)));
//        System.out.println();
//        CarBookingService carBookingService  = new CarBookingService(carBookingDAO,carDAO);
//        System.out.println(Arrays.toString(carBookingService.getAllAvailableCars(carBookingDAO)));
//        System.out.println();
//        carBookingService.bookingCar(9483,UUID.fromString("0f163d56-adeb-4bd2-b63a-b1a730e32cb3"));
//        System.out.println();
//        carBookingService.bookingCar(1289,UUID.fromString("2aca6627-7808-4d88-b733-315890813606"));
//        System.out.println();
//        carBookingService.bookingCar(1473,UUID.fromString("98e9e89a-5166-4cf1-9584-e45da721f30c"));
//        CarDAO carDAO = new CarDAO();
//        CarService carService = new CarService(carDAO);
//        CarBookingDAO carBookingDAO = new CarBookingDAO();
//        CarBookingService2 carBookingService2 = new CarBookingService2(carBookingDAO,carService);
//        carBookingService2.bookingCar(1473, UUID.fromString("98e9e89a-5166-4cf1-9584-e45da721f30c"));
//        carBookingService2.bookingCar(9483, UUID.fromString("3488c095-22ab-45d9-a1cd-daf6ddd349f0"));
//        System.out.println();
//        System.out.println(Arrays.toString(carBookingService2.getAllAvailableCars(carBookingDAO)));

        UserDAO userDAO = new UserDAO();
        UserArrayDataAccessService uADAService = new UserArrayDataAccessService();
        UserService userService =  new UserService(uADAService);

        CarDAO carDAO = new CarDAO();
        CarService carService = new CarService(carDAO);

        CarBookingDAO carBookingDAO = new CarBookingDAO();
        CarBookingService carBookingService = new CarBookingService(carBookingDAO,carService);

        Scanner scanner = new Scanner(System.in);

        boolean looping = true;

        while (looping){
            try{
                displayMenu();
                String choice = scanner.nextLine();
                switch (Integer.parseInt(choice)){
                    case 1 -> bookCar(userService, carBookingService, scanner);
                    case 2 -> displayAllUserBookedCars(carBookingService,userService,scanner);
                    case 3 -> allBookings(carBookingService);
                    case 4 -> displayAllAvailableCars(carBookingService,false);
                    case 5 -> displayAllAvailableCars(carBookingService, true);
                    case 6 -> displayAllUsers(userService);
                    case 7 -> looping = false;
                    //default: System.out.println(choice+" not a valid option");
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


    }


    private static void allBookings(CarBookingService carBookingService){
        CarBooking[] carBookings =  carBookingService.getBookings();
        if(carBookings.length==0){
            System.out.println("There's no available cars 😔");
            return;
        }
        for(CarBooking carBooking : carBookings){
            System.out.println("Booking cars = "+ carBooking);
        }
    }

    private static void displayAllUsers(UserService userService){
        User[] users = userService.getUsers();
        if(users.length==0){
            System.out.println("❌ No users in the system");
        }
        for(User user : users){
            System.out.println(user);
        }
        System.out.println();
    }

    private static void displayAllAvailableCars(CarBookingService carBookingService, boolean isElectric){
        Car[] availableCars = isElectric ? carBookingService.getElectricCars() :
                carBookingService.getAvailableCars();

        if(availableCars.length==0){
            System.out.println("❌ No cars available for renting");
            return;
        }
        for (Car availableCar : availableCars) {
            System.out.println(availableCar);
        }
    }

    private static void displayAllUserBookedCars(CarBookingService bookingService, UserService userService, Scanner scanner){
        displayAllUsers(userService);

        System.out.println("_select user id: ");

        String userId = scanner.nextLine();
        User user = userService.getUserById(UUID.fromString(userId));
        if (user == null){
            System.out.printf("❌ User not found with id %s ", userId);
            return;
        }
        Car[] userBookedCars = bookingService.getBookedCarsForUser(user.getUuid());

        if(userBookedCars.length == 0){
            System.out.printf("❌ User %s has no car booked ", user);
            return;
        }
        for (Car car : userBookedCars){
            System.out.println(car);
        }
    }
    private static void bookCar(UserService userService, CarBookingService carBookingService, Scanner scanner){
        displayAllAvailableCars(carBookingService,false);

        System.out.println("_select car register number :");
        String regNumber = scanner.nextLine();
        System.out.println();
        displayAllUsers(userService);

        System.out.println("_ select user id: ");
        String userId = scanner.nextLine();

        try{
            User user = userService.getUserById(UUID.fromString(userId));
            if(user == null){
                System.out.printf("❌ User not found with id %s ", userId);
            }else {
                UUID bookingId = carBookingService.bookingCar(user,regNumber);
                String confirmationMessage = (" 🎉 Successfully booked car with register number %s " +
                        "for user %s \n Booking id : %s ").formatted(regNumber,user,bookingId);
                System.out.println(confirmationMessage);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void displayMenu(){
        System.out.println("""
                \n
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View All Users
                7️⃣ - Exit""");
    }
}
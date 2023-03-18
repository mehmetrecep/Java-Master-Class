//package com.javamasterclass.notneeded;
//
//import com.javamasterclass.car.Car;
//import com.javamasterclass.car.CarDAO;
//import com.javamasterclass.car.CarService;
//
//import java.util.Arrays;
//import java.util.Objects;
//import java.util.UUID;
//
//public class CarBookingService2 {
//    private final CarBookingDAO carBookingDAO;
//    private int capacity;
//    private Car[] cars;
//    private CarDAO carDAO;
//    private int size;
//    private  Car[] availableCar = new Car[carDAO.getCars().length+1];
//    private int count = 0;
//    private CarService carService;
//
//
//    public CarBookingService2(CarBookingDAO carBookingDAO, CarService carService) {
//        this.carBookingDAO = carBookingDAO;
//        this.carService = carService;
//    }
//
//    public CarDAO getCarDAO() {
//        return carDAO;
//    }
//
//    public void setCarDAO(CarDAO carDAO) {
//        this.carDAO = carDAO;
//    }
//
//    public void addingCars(Car car){
//        if(size >= capacity){
//            grow();
//        }
//        cars[size] = car;
//        size++;
//    }
//
//    private void grow() {
//    }
//    public Car[] deletingCar(Car car){
//        for(int i = 0; i < size; i++){
//            if(cars[i].equals(car)){
//                for (int j = 0; j < (size - i - 1); i++){
//                    cars[i+j] = cars[i+j+1];
//                }
//            }
//        }
//        return cars;
//    }
//
//
//    public void bookingCar(int regNum, UUID uuid) {
//        for(Car c : carBookingDAO.car(carDAO)){
//            if(c.getClass() != null && c.getRegNum()==regNum){
//                c.setBooked(true);
//                System.out.println(" 🎉 Successfully booked with register number: "+regNum+
//                        "\n and id: "+c.getUuid());
//                System.out.println("And the available cars are "+ Arrays.toString(deletingCar(c)));
//                System.out.println();
//                return;
//            }
//        }
//        System.out.println(" 😢 Unfortunately, there's no car with this register number");
//    }
//
//
//    public Car[] getAllAvailableCars(CarBookingDAO carBookingDAO){
//        //Car[] unAvailableCar = new Car[carDAO.getCars().length];
//        for(Car c : carBookingDAO.car(carDAO)){
//            if(!c.isBooked()){
//                availableCar[count++] = c;
//            }
//        }
//        return availableCar;
//    }
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public Car[] getCars() {
//        return cars;
//    }
//
//    public void setCars(Car[] cars) {
//        this.cars = cars;
//    }
//
//    @Override
//    public String toString() {
//        return "CarBookingService2{" +
//                "carBooking=" + Arrays.toString(cars) +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CarBookingService2 that = (CarBookingService2) o;
//        return size == that.size && capacity == that.capacity && Objects.equals(carBookingDAO, that.carBookingDAO) && Arrays.equals(cars, that.cars);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(carBookingDAO, size, capacity);
//        result = 31 * result + Arrays.hashCode(cars);
//        return result;
//    }
//}

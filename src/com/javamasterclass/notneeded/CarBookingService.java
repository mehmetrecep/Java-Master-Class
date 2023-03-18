//package com.javamasterclass.notneeded;
//
//import com.javamasterclass.bookingcar.CarBooking;
//import com.javamasterclass.car.Car;
//import com.javamasterclass.car.CarDAO;
//
//import java.util.UUID;
//
//public class CarBookingService extends CarBooking {
//    private final CarBookingDAO carBookingDAO;
//    //private static Car[] newAvailableCar = new Car[CAR_BOOKINGS.length-1];
//    private final CarDAO carDAO;
//    private  Car[] availableCar;
//    private int count = 0;
//
//
//    public CarBookingService(CarBookingDAO carBookingDAO, CarDAO carDAO) {
//        this.carBookingDAO = carBookingDAO;
//        this.carDAO = carDAO;
//    }
//
//
//    public Car[] getAllAvailableCars(CarBookingDAO carBookingDAO){
//        //Car[] unAvailableCar = new Car[carDAO.getCars().length];
//        for(Car c : carBookingDAO.car(carDAO)){
//            if(!c.isBooked() && c != null){
//                availableCar[count] = c;
//                count++;
//            }
//        }
//        return availableCar;
//    }
//
//
//    public void bookingCar(int regNum, UUID uuid){
////        for(Car c : getAllAvailableCars(carBookingDAO)){
////            if(c != null && c.getRegNum()==regNum){
////                c.setBooked(true);
////                System.out.println(" 🎉 Successfully booked with register number: "+regNum+"
////                          \n and id: "+c.getUuid());
////                return;
////            }
////        }
////        System.out.println(" 😢 Unfortunately, there's no car with this register number");
////        for (int i = 0, k = -1; i < availableCar.length; i++) {
////            if(availableCar[i] != null && availableCar[i].getRegNum() == regNum && !availableCar[i].isBooked()){
////                availableCar[i].setBooked(true);
////                System.out.println(" 🎉 Successfully booked with register number: "+regNum+"\n and id: "+availableCar[i].getUuid());
////            }
////            else {
////                newAvailableCar[++k] = availableCar[i];
////
////            }
////        }
////        System.out.println(Arrays.toString(newAvailableCar) +"ab");
//   }
//
//}

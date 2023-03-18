package com.javamasterclass.bookingcar;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;

public class CarBookingDAO {
    private static final CarBooking[] CAR_BOOKINGS;

    static{
        CAR_BOOKINGS  = new CarBooking[10];
    }

    public CarBooking[] getCarBookings(){
        return CAR_BOOKINGS;
    }



    public void booked(CarBooking carBooking){
        int nextFreeIndex = -1;

        for (int i = 0; i < CAR_BOOKINGS.length; i++){
            if(CAR_BOOKINGS[i] == null){
                nextFreeIndex = i;
            }
        }
        if(nextFreeIndex > -1){
            CAR_BOOKINGS[nextFreeIndex] = carBooking;
            return;
        }

        CarBooking[] newCarBooking = new CarBooking[CAR_BOOKINGS.length+10];

        for(int i =0; i < CAR_BOOKINGS.length; i++){
            newCarBooking[i] = CAR_BOOKINGS[i];
        }

        newCarBooking[CAR_BOOKINGS.length] = carBooking;

    }

//    public void addBookingCars(CarBooking car){
//        enSureCapacity(CAR_BOOKINGS.length+1);
//        CAR_BOOKINGS[CAR_BOOKINGS.length+1]=car;
//    }
//
//    private void enSureCapacity(int length) {
//        int oldCapacity = CAR_BOOKINGS.length;
//        if(length>oldCapacity){
//            int newLength = oldCapacity*2;
//            if(newLength<length){
//                newLength=length;
//            }
//            CAR_BOOKINGS= Arrays.copyOf(CAR_BOOKINGS,newLength);
//        }
//    }



}

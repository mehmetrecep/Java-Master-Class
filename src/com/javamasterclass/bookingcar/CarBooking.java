package com.javamasterclass.bookingcar;

import com.javamasterclass.car.Car;
import com.javamasterclass.car.CarDAO;
import com.javamasterclass.car.CarService;
import com.javamasterclass.user.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class CarBooking {
  private Car car;
  private User user;
  private LocalDateTime localDateTime;
  private boolean isCanceled;

    public CarBooking(Car car, User user, LocalDateTime localDateTime, boolean isCanceled) {
        this.car = car;
        this.user = user;
        this.localDateTime = LocalDateTime.now();
        this.isCanceled = false;
    }

    public CarBooking(Car car, User user, LocalDateTime localDateTime) {
        this.car = car;
        this.user = user;
        this.localDateTime = localDateTime;
    }

    public Car getCar() {
        return car;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return Objects.equals(car, that.car) && Objects.equals(user, that.user) && Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, user, localDateTime);
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "car= " + car +
                ", user= " + user +
                ", localDateTime= " + localDateTime +
                '}';
    }
}

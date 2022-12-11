package com.valloyd.carbooking.booking;

import com.valloyd.carbooking.car.Car;
import com.valloyd.carbooking.user.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class Booking {

    private UUID bookingReference;
    private final Car car;
    private final User user;
    private LocalDateTime bookingTime;
    private boolean isCancelled;

    public Booking(Car car, User user) {
        this.car = car;
        this.user = user;

        isCancelled = false;
    }

    public UUID getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(UUID bookingReference) {
        this.bookingReference = bookingReference;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingReference=" + bookingReference +
                ", car=" + car +
                ", user=" + user +
                ", bookingTime=" + bookingTime +
                ", isCancelled=" + isCancelled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isCancelled == booking.isCancelled && Objects.equals(bookingReference, booking.bookingReference) && Objects.equals(car, booking.car) && Objects.equals(user, booking.user) && Objects.equals(bookingTime, booking.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingReference, car, user, bookingTime, isCancelled);
    }
}

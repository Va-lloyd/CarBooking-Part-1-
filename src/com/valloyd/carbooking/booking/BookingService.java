package com.valloyd.carbooking.booking;

import com.valloyd.carbooking.car.Car;
import com.valloyd.carbooking.car.CarService;
import com.valloyd.carbooking.user.User;
import com.valloyd.carbooking.user.UserService;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public final class BookingService {

    private static final Scanner SCANNER = new Scanner(System.in);

    BookingDAO bookingDAO;

    public BookingService() {
        bookingDAO = new BookingDAO();
    }

    /**
     * This method handles the booking process, which instantiates a new Booking object using an existing Car and User object.
     * The application user is prompted to enter the relevant input as the method progresses.
     */
    public void bookCar() {

        Car car;
        User user = null;
        CarService carService = new CarService();
        UserService userService = new UserService();
        String regNumber;
        String userID;

        // Prints the Car DB and prompts application user to input the car's registration number to get the Car object.
        do {
            if (!(carService.getCars() == null))
                for (int i = 0; i < carService.getCars().length; i++) {
                    System.out.println(carService.getCars()[i]);
                }
            System.out.println("⏩ Enter car's registration number...");
            regNumber = SCANNER.nextLine();
            car = carService.getCarByRegNumber(regNumber);
            System.out.println();
        } while (car == null || isCarBooked(car));

        // Prints the User DB and prompts the application user to input the user's ID to get the User object.
        do {
            if (!(userService.getUsers() == null)) {
                for (int i = 0; i < userService.getUsers().length; i++) {
                    System.out.println(userService.getUsers()[i]);
                }
            }
            System.out.println("⏩ Enter user's ID (Case Sensitive)...");
            userID = SCANNER.nextLine();
            try {
                user = userService.getUserByID(UUID.fromString(userID));
            } catch (IllegalArgumentException e) {
                System.out.println("🚫 Must be a valid user ID...");
                System.out.println();
                continue;
            }
            System.out.println();
        } while (user == null);

        Booking booking = new Booking(car, user);
        // Called for validation checks on the new Booking object.
        registerBooking(booking);

        System.out.println("🎇 Successfully booked car (" + regNumber + ") for " + user + ".\nBooking reference: " + booking.getBookingReference());
    }

    public Booking[] getBookings() {
        var bookingAmount = 0;

        for (int i = 0; i < bookingDAO.getBookings().length; i++) {
            if (!(bookingDAO.getBookings()[i] == null)) {
                bookingAmount++;
            }
        }

        if (bookingAmount > 0) {
            Booking[] bookings = new Booking[bookingAmount];
            var index = 0;

            for (int i = 0; i < bookingDAO.getBookings().length; i++) {
                if (!(bookingDAO.getBookings()[i] == null)) {
                    bookings[index++] = bookingDAO.getBookings()[i];
                }
            }
            return bookings;
        } else {
            System.out.println("🚫 No bookings...");
            return null;
        }
    }

    public void getBookedCarsByUserID() {
        UserService userService = new UserService();

        if (!(getBookings() == null || userService.getUsers() == null)) {
            String userUUID;
            User user;

            for (int i = 0; i < userService.getUsers().length; i++) {
                System.out.println(userService.getUsers()[i]);
            }
            System.out.println("⏩ Enter user's ID (Case Sensitive)...");
            userUUID = SCANNER.nextLine();

            try {
                user = userService.getUserByID(UUID.fromString(userUUID));
            } catch (IllegalArgumentException e) {
                System.out.println("🚫 Must be a valid user ID...");
                return;
            }

            var bookingAmount = 0;
            for (int i = 0; i < getBookings().length; i++) {
                if (getBookings()[i].getUser().equals(user)) {
                    System.out.println(getBookings()[i].getCar());
                    bookingAmount++;
                }
            }
            if (bookingAmount == 0) {
                System.out.println("🚫 No cars booked for " + user);
            }
        }
    }

    private boolean isCarBooked(Car car) {
        for (int i = 0; i < bookingDAO.bookings.length; i++) {
            if (bookingDAO.bookings[i] == null) {
                continue;
            }

            if (bookingDAO.bookings[i].getCar().getRegNumber().equalsIgnoreCase(car.getRegNumber())) {
                System.out.println("Car is already booked...");
                System.out.println();
                return true;
            }
        }
        return false;
    }

    public int registerBooking(Booking booking) {
        booking.setBookingReference(UUID.randomUUID());
        booking.setBookingTime(LocalDateTime.now());

        bookingDAO.setBooking(booking);
        return 1;
    }
}

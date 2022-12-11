package com.valloyd.carbooking.ui;

import com.valloyd.carbooking.booking.BookingService;
import com.valloyd.carbooking.car.CarService;
import com.valloyd.carbooking.user.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class manages the UI, which is called from Main when the program runs.
 */
public final class UserInterface {

    /**
     * This method is called from {@link com.valloyd.carbooking.Main#main(String[])}.
     * <p>
     * This method contains all the functionality this program has to offer.
     */
    public void menu() {
        BookingService bookingService = new BookingService();
        CarService carService = new CarService();
        UserService userService = new UserService();

        Scanner scanner = new Scanner(System.in);
        var intInput = 0;

        while (intInput != 7) {
            menuOptions();

            try {
                intInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Must be a valid number.");
                continue;
            } finally {
                scanner.nextLine();
            }

            switch (intInput) {

                case 1 -> {
                    try {
                        bookingService.bookCar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                case 2 -> {
                    try {
                        bookingService.getBookedCarsByUserID();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                case 3 -> {
                    try {
                        if (!(bookingService.getBookings() == null)) {
                            for (int i = 0; i < bookingService.getBookings().length; i++) {
                                System.out.println(bookingService.getBookings()[i]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                case 4 -> {
                    try {
                        if (!(carService.getCars() == null))
                            for (int i = 0; i < carService.getCars().length; i++) {
                                System.out.println(carService.getCars()[i]);
                            }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                case 5 -> {
                    try {
                        if (!(carService.getElectricCars() == null)) {
                            for (int i = 0; i < carService.getElectricCars().length; i++) {
                                System.out.println(carService.getElectricCars()[i]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                case 6 -> {
                    try {
                        if (!(userService.getUsers() == null)) {
                            for (int i = 0; i < userService.getUsers().length; i++) {
                                System.out.println(userService.getUsers()[i]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                case 7 -> System.out.println("👋 Exiting program...");
            }
        }
    }

    /**
     * This method simply displays text to the user to aid with their input.
     */
    private void menuOptions() {
        System.out.println();
        System.out.println("1️⃣ - Book Car");
        System.out.println("2️⃣ - View All User Booked Cars");
        System.out.println("3️⃣ - View All Bookings");
        System.out.println("4️⃣ - View Available Cars");
        System.out.println("5️⃣ - View Available Electric Cars");
        System.out.println("6️⃣ - View All Users");
        System.out.println("7️⃣ - Exit");
    }
}

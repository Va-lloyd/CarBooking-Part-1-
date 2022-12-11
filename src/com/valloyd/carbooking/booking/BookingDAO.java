package com.valloyd.carbooking.booking;

final class BookingDAO {

    private static int CAPACITY = 100;

    Booking[] bookings = new Booking[CAPACITY];

    public void setBooking(Booking booking) {
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                bookings[i] = booking;
                break;
            }
        }
    }

    public Booking[] getBookings() {
        return bookings;
    }
}

package ru.practicum.shareit.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.booking.model.Booking;

public class BookingTest {

    @Test
    void testBookingModelConstructorAndGetters() {
        Booking booking = new Booking();
        booking.setId(1L);
        assertEquals(1L, booking.getId());
        booking.toString();
        booking.hashCode();
        Booking otherBooking = new Booking();
        otherBooking.setId(1L);
        assertTrue(booking.equals(otherBooking));
    }
}
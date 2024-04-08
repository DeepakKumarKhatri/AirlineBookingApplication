package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.custom_exceptions.BookingNotFoundException;
import com.application.airlinebookingapp.models.Aircraft;
import com.application.airlinebookingapp.models.Booking;
import com.application.airlinebookingapp.repo.BookingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {
    private final BookingRepo bookingRepo;

    @Autowired
    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public List<Booking> findAllBookings(){
        return bookingRepo.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepo.findBookingById(id).
                orElseThrow(() ->
                        new BookingNotFoundException("Booking with ID: " + id + " Not Found!"));
    }

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Optional<Booking> optionalBooking = bookingRepo.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setFlight(updatedBooking.getFlight());
            booking.setPassenger(updatedBooking.getPassenger());
            return bookingRepo.save(booking);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}

package com.example.loadbooking.service;

import com.example.loadbooking.entity.Booking;
import com.example.loadbooking.entity.Load;
import com.example.loadbooking.exception.InvalidRequestException;
import com.example.loadbooking.exception.ResourceNotFoundException;
import com.example.loadbooking.repository.BookingRepository;
import com.example.loadbooking.repository.LoadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final LoadRepository loadRepository;

    public BookingService(BookingRepository bookingRepository, LoadRepository loadRepository) {
        this.bookingRepository = bookingRepository;
        this.loadRepository = loadRepository;
    }

    @Transactional
    public Booking createBooking(Booking booking) {

        Load load = loadRepository.findById(booking.getLoad().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Load not found"));

        if (load.getStatus() == Load.Status.CANCELLED) {
            throw new InvalidRequestException("Cannot book a cancelled load");
        }
        if (load.getStatus() == Load.Status.BOOKED) {
            throw new InvalidRequestException("Load is already booked");
        }

        // Update Load status
        load.setStatus(Load.Status.BOOKED);
        loadRepository.save(load);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(UUID id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    }

    @Transactional
    public void deleteBooking(UUID id) {
        Booking booking = getBookingById(id);
        Load load = booking.getLoad();

        // Change Load status back to POSTED when a booking is deleted
        load.setStatus(Load.Status.POSTED);
        loadRepository.save(load);

        bookingRepository.deleteById(id);
    }

    // Validate that booking fields are properly set

}

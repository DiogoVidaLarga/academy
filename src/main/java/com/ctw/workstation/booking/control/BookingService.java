package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.booking.entity.BookingMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepository;

    public List<BookingDTO> getAllBookings() {
        return bookingRepository
                .listAll()
                .stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO getBookingById(UUID id) {
        Booking booking = bookingRepository.findById(id);
        return BookingMapper.toDTO(booking);
    }

    @Transactional
    public BookingDTO createBooking(BookingDTO dto) {
        Booking booking = BookingMapper.toEntity(dto);
        booking.setCreatedAt(java.time.LocalDateTime.now());
        booking.setModifiedAt(java.time.LocalDateTime.now());
        bookingRepository.persist(booking);
        return BookingMapper.toDTO(booking);
    }

    @Transactional
    public BookingDTO updateBooking(UUID id, BookingDTO dto) {
        Booking booking = bookingRepository.findById(id);
        if (booking == null) {
            return null;
        }
        booking.setRackId(dto.getRackId());
        booking.setRequesterId(dto.getRequesterId());
        booking.setBookFrom(dto.getBookFrom());
        booking.setBookTo(dto.getBookTo());
        booking.setModifiedAt(java.time.LocalDateTime.now());
        return BookingMapper.toDTO(booking);
    }

    @Transactional
    public boolean deleteBooking(UUID id) {
        Booking booking = bookingRepository.findById(id);
        if (booking == null) {
            return false;
        }

        bookingRepository.delete(booking);
        return true;
    }
}

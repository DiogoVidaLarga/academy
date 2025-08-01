package com.ctw.workstation.booking.entity;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        if (booking == null) {
            return null;
        }
        return new BookingDTO(
                booking.getId(),
                booking.getRackId(),
                booking.getRequesterId(),
                booking.getBookFrom(),
                booking.getBookTo()
        );
    }

    public static Booking toEntity(BookingDTO dto) {
        if (dto == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setRackId(dto.getRackId());
        booking.setRequesterId(dto.getRequesterId());
        booking.setBookFrom(dto.getBookFrom());
        booking.setBookTo(dto.getBookTo());
        return booking;
    }
}

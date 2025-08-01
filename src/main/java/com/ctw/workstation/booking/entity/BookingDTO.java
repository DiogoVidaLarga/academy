package com.ctw.workstation.booking.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingDTO {

    public UUID id;
    public UUID rackId;
    public UUID requesterId;
    public LocalDateTime bookFrom;
    public LocalDateTime bookTo;

    public BookingDTO(UUID id, UUID rackId, UUID requesterId, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.id = id;
        this.rackId = rackId;
        this.requesterId = requesterId;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }
}

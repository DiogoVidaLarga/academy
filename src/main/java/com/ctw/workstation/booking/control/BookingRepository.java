package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;


@ApplicationScoped
public class BookingRepository implements PanacheRepositoryBase<Booking, UUID> {

    public List<Booking> findByRackId(UUID rackId) {
        return list("rackId", rackId);
    }

    public List<Booking> findByRequesterId(UUID requesterId) {
        return list("requesterId", requesterId);
    }

}

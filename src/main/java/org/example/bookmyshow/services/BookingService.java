package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repos.BookingRepo;
import org.example.bookmyshow.repos.ShowRepo;
import org.example.bookmyshow.repos.ShowSeatRepo;
import org.example.bookmyshow.repos.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepo userRepo;
    private ShowRepo showRepo;
    private ShowSeatRepo showSeatRepo;
    private BookingRepo bookingRepo;

    public BookingService(UserRepo userRepo,
                          ShowRepo showRepo,
                          ShowSeatRepo showSeatRepo,
                          BookingRepo bookingRepo) {
        this.userRepo = userRepo;
        this.bookingRepo = bookingRepo;
        this.showRepo = showRepo;
        this.showSeatRepo = showSeatRepo;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId,
                                 Long showId,
                                 List<Long> showSeatIds) {

        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User doesn't exist");
        }

        Optional<Show_> showOptional = showRepo.findById(showId);
        if(showOptional.isEmpty()) {
            throw new ShowNotFoundException("invalid showId");
        }

        List<ShowSeat> showSeats = showSeatRepo.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Please select some other seats");
            }
        }

        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepo.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setUser(userOptional.get());
        booking.setShow_(showOptional.get());
        booking.setShowSeat(showSeats);
        //booking.setPayments();
        //booking.setAmount(); ToDo : to be done by Nikhil

        return bookingRepo.save(booking);
    }
}

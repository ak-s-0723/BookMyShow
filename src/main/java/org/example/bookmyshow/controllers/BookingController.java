package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.CreateBookingRequestDto;
import org.example.bookmyshow.dtos.CreateBookingResponseDto;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto bookingRequestDto ) {
        CreateBookingResponseDto createBookingResponseDto = new CreateBookingResponseDto();
        try {
            Booking booking = bookingService.createBooking(bookingRequestDto.getUserId(),
                    bookingRequestDto.getShowId(),
                    bookingRequestDto.getShowSeatIds());

            createBookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            createBookingResponseDto.setBookingId(booking.getId());
            return createBookingResponseDto;
        } catch (Exception exception) {
             createBookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
             createBookingResponseDto.setBookingId(null);
             return createBookingResponseDto;
        }
    }
}

//
//    "name" : "anurag",
//        "age" : 29,
//        "professions" : ["instructor","engineer"],
//        "family" : {
//
//        }
//        }
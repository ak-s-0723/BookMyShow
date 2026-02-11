package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookingResponseDto {
    ResponseStatus responseStatus;
    Long bookingId;
}

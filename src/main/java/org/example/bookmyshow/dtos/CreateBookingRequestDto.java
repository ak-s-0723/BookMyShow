package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateBookingRequestDto {
    Long userId;
    Long showId;
    List<Long> showSeatIds;
}

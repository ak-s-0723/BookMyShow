package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat  extends BaseModel {
    private String seatNumber;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private Integer rn;
    private Integer cn;
}

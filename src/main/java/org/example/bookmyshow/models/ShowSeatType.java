package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show_ show_;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private Double price;
}

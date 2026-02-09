package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Booking extends BaseModel {
    @ManyToOne
    private User user;
    @ManyToOne
    private Show_ show_;
    private int amount;
    @OneToMany
    private List<Payment> payments;
    private Date bookingDate;
    @OneToMany
    private List<ShowSeat> showSeat;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;

}

//1            1
//Booking     User
//M             1
//
//M :  1


//1          M
//booking     payment
//1             1
//
//1 : M
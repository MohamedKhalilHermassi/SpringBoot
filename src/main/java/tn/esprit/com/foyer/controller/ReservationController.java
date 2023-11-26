package tn.esprit.com.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.foyer.entities.Reservation;
import tn.esprit.com.foyer.services.ReservationServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    ReservationServices reservationServices;

    @GetMapping("/retrieve-all-reservation")
    public List<Reservation> retrieveAllReservation(){
        return reservationServices.retrieveAllReservation();
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId){
        return reservationServices.retrieveReservation(reservationId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r){
        return reservationServices.addReservation(r);
    }

    @DeleteMapping("/delete-reservation/{reservation-id}")
    public void deleteReservation(@PathVariable("reservation-id") Long reservationId){
        reservationServices.removeReservation(reservationId);
    }
}

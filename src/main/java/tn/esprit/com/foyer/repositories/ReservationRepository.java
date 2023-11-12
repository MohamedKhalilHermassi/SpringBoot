package tn.esprit.com.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.foyer.entities.Reservation;

import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {


    public Reservation findByanneeReservation(Date annee);
}

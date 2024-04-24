package com.example.pfe.Repository;

import com.example.pfe.Entities.Benefit;
import com.example.pfe.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}

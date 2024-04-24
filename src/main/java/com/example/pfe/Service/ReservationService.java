package com.example.pfe.Service;

import com.example.pfe.Dto.Benefit.RequestBenefit;
import com.example.pfe.Dto.Benefit.ResponseBenefit;
import com.example.pfe.Dto.Reservation.RequestReservation;
import com.example.pfe.Dto.Reservation.ResponseReservation;
import com.example.pfe.Entities.Benefit;
import com.example.pfe.Entities.Reservation;

import java.util.List;

public interface ReservationService {
    List<ResponseReservation> getAllReservations();
   boolean deleteReservation(Long id);
    void createReservation(RequestReservation requestReservation);
    Reservation updateReservation(Long id, RequestReservation requestReservation);
    ResponseReservation getReservationById(Long id);
   // ResponseBenefit getBenefitWithCategory(Long id);
}

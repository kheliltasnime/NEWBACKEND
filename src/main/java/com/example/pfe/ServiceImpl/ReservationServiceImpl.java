package com.example.pfe.ServiceImpl;

import com.example.pfe.Dto.Benefit.RequestBenefit;
import com.example.pfe.Dto.Benefit.ResponseBenefit;
import com.example.pfe.Dto.Reservation.RequestReservation;
import com.example.pfe.Dto.Reservation.ResponseReservation;
import com.example.pfe.Entities.Benefit;
import com.example.pfe.Entities.Reservation;
import com.example.pfe.Repository.BenefitRepository;
import com.example.pfe.Repository.ReservationRepository;
import com.example.pfe.Service.EquipmentsService;
import com.example.pfe.Service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ResponseReservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ResponseReservation> reservationFormated = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ResponseReservation benefit1 = ResponseReservation.makeReservation(reservation);
            reservationFormated.add(benefit1);
        }
        return reservationFormated;
    }

    @Override
    public boolean deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            return false;
        }
        reservationRepository.deleteById(id);
        return true;
    }

    @Override
    public void createReservation(RequestReservation requestReservation) {
        Reservation reservation = Reservation.builder()
                .Depart_Date(requestReservation.getDepart_Date())
                .Depart_Hour(requestReservation.getDepart_Hour())
                .Return_Date(requestReservation.getReturn_Date())
                .Return_Hour(requestReservation.getReturn_Hour())
                .build();
        reservationRepository.save(reservation);

    }

    @Override
    public Reservation updateReservation(Long id, RequestReservation requestReservation) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        if (requestReservation.getDepart_Date() != null) {
            reservation.setDepart_Date(requestReservation.getDepart_Date());
        }
        if (requestReservation.getReturn_Date() != null) {
            reservation.setReturn_Date(requestReservation.getReturn_Date());
        }
        if (requestReservation.getDepart_Hour() != null) {
            reservation.setDepart_Hour(requestReservation.getDepart_Hour());
        }
        if (requestReservation.getReturn_Hour() != null) {
            reservation.setReturn_Hour(requestReservation.getReturn_Hour());
        }

        return reservationRepository.save(reservation);
    }


    @Override
    public ResponseReservation getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return ResponseReservation.makeReservation((reservation.get()));

    }





}
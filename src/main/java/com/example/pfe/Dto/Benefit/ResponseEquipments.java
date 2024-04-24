package com.example.pfe.Dto.Benefit;

import com.example.pfe.Dto.Reservation.ResponseReservation;
import com.example.pfe.Entities.Equipments;
import com.example.pfe.Entities.Reservation;
import com.example.pfe.Entities.Rooms;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEquipments {
    Long id;
    String name;
    String type;  //type d'equipment info , securite ..
    String manufactuer; // societe eli san3t el equip
    String model;
    Date purchase_date; //date d'achat
    Integer quantity;
    Integer price;
    String maintenance_status;
    Long benefitId;
    private Instant createdAt;
    private Instant updatedAt;
    private ResponseBenefit benefit;
    private List<ResponseReservation> reservationList;
    public static ResponseEquipments makeEquipments(Equipments equipments){
        return ResponseEquipments.builder()
                .id(equipments.getId())
                .name(equipments.getName())
                .type(equipments.getType())
                .manufactuer(equipments.getManufactuer())
                .model(equipments.getModel())
                .purchase_date(equipments.getPurchase_date())
                .quantity(equipments.getQuantity())
                .price(equipments.getPrice())
                .maintenance_status(equipments.getMaintenance_status())
                .benefit(ResponseBenefit.makeBenefit(equipments.getBenefit()))
                .createdAt(equipments.getCreatedAt())
                .updatedAt(equipments.getUpdatedAt())
                .build();
    }
    public static ResponseEquipments makeEquipmentsList(Equipments equipments){
        List<Reservation> reservations = equipments.getReservations();

        List<ResponseReservation> reservationFormated = new ArrayList<>();

        for (Reservation reservation : reservations){
            ResponseReservation member = ResponseReservation.makeReservation(reservation);
            reservationFormated.add(member);
        }

        return ResponseEquipments.builder()
                .id(equipments.getId())
                .name(equipments.getName())
                .type(equipments.getType())
                .manufactuer(equipments.getManufactuer())
                .model(equipments.getMaintenance_status())
                .purchase_date(equipments.getPurchase_date())
                .quantity(equipments.getQuantity())
                .price(equipments.getPrice())
                .maintenance_status(equipments.getMaintenance_status())
                .createdAt(equipments.getCreatedAt())
                .benefit(ResponseBenefit.makeBenefit(equipments.getBenefit()))
                .updatedAt(equipments.getUpdatedAt())
                .reservationList(reservationFormated)
                .build();
    }

}

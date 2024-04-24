package com.example.pfe.Dto.Reservation;

import com.example.pfe.Dto.Benefit.ResponseBenefit;
import com.example.pfe.Dto.Benefit.ResponseEquipments;
import com.example.pfe.Dto.Benefit.ResponseRooms;
import com.example.pfe.Dto.Employee.ResponseEmployee;
import com.example.pfe.Entities.Benefit;
import com.example.pfe.Entities.Equipments;
import com.example.pfe.Entities.Reservation;
import com.example.pfe.Entities.Rooms;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseReservation {
    Long id;
    String Depart_Date;
    String Return_Date;
    String Depart_Hour;
    String Return_Hour;
    private Instant createdAt;
    private Instant updatedAt;
    private List<ResponseEquipments> equipmentsList;
    private List<ResponseRooms> roomsList ;
    private ResponseEmployee employee;
    Long employeId;


    public static ResponseReservation makeReservation(Reservation reservation){
        return ResponseReservation.builder()
                .id(reservation.getId())
                .Depart_Date(reservation.getDepart_Date())
                .Return_Date(reservation.getReturn_Date())
                .Depart_Hour(reservation.getDepart_Hour())
                .Return_Hour(reservation.getReturn_Hour())
                .employee(ResponseEmployee.makeEmployee(reservation.getEmployee()))
                .createdAt(reservation.getCreatedAt())
                .updatedAt(reservation.getUpdatedAt())
                .build();
    }
















}

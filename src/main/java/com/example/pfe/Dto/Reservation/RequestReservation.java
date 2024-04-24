package com.example.pfe.Dto.Reservation;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String Depart_Date;
    String Return_Date;
    String Depart_Hour;
    String Return_Hour;

    @Min(value = 1 , message = "benefit is required")
    Long employeeId;
}

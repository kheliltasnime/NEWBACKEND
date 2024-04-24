package com.example.pfe.Dto.Employee;

import com.example.pfe.Dto.Benefit.ResponseBenefit;
import com.example.pfe.Dto.Benefit.ResponseEquipments;
import com.example.pfe.Dto.Benefit.ResponseRooms;
import com.example.pfe.Dto.Reservation.ResponseReservation;
import com.example.pfe.Entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployee {
    Long id;
    String firstName;
    String lastName;
    int phoneNumber;
    String address;
    String email;
    String password;
    String account_type;
    String department;
    String job;
    String state="Enabled";

    private List<ResponseReservation> reservationList;
    private Instant createdAt;
    private Instant updatedAt;

    public static ResponseEmployee makeEmployee(Employee employee){
        return ResponseEmployee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .phoneNumber(employee.getPhoneNumber())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .account_type(employee.getAccount_type())
                .department(employee.getDepartment())
                .state(employee.getState())
                .job(employee.getJob())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();
    }
    public static ResponseEmployee makeEmployeeList(Employee employee){
        List<Reservation> reservations = employee.getReservations();

        List<ResponseReservation> reservationFormated = new ArrayList<>();

        for (Reservation reservation : reservations){
            ResponseReservation member = ResponseReservation.makeReservation(reservation);
            reservationFormated.add(member);
        }

        return ResponseEmployee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .phoneNumber(employee.getPhoneNumber())
                .address(employee.getAddress())
                .email(employee.getEmail())
                .account_type(employee.getAccount_type())
                .job(employee.getJob())
                .state(employee.getState())
                .department(employee.getDepartment())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .reservationList(reservationFormated)
                .build();
    }
}

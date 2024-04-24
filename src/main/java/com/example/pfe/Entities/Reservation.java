package com.example.pfe.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Date;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String Depart_Date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String Return_Date;

    @Pattern(regexp = "^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Invalid time format. Please use HH:mm:ss")
    String Depart_Hour;
    @Pattern(regexp = "^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Invalid time format. Please use HH:mm:ss")
    String Return_Hour;




    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipments equipments;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms rooms;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;













}

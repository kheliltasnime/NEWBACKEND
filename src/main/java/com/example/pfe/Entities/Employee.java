package com.example.pfe.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@Builder
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String firstName;
    String lastName;
    int phoneNumber;
    String address;
    String email;
    String password;
    String account_type;
    String department;
    String job;
    String state ;




    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "employee")
    private List<Reservation> reservations ;

}

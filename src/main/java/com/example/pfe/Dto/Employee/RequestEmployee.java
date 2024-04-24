package com.example.pfe.Dto.Employee;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import jakarta.validation.constraints.*;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployee {

    Long id;
    String firstName;
    String lastName;
    @Max(value = 99999999 , message = "Phone number invalid ")
    @Min(value = 10000000 , message = "Phone number invalid ")
    int phoneNumber;
    String address;
    @NotBlank(message = "email is required")
    @Email(message = "Email not valid")
    String email;
    @NotBlank(message = "password is required")
    String password;
    String account_type;
    @NotBlank(message = "Department name is required")
    String department;
    String job;
    @NotBlank(message = "State is required")
    @Pattern(regexp = "Enabled|Disabled", message = "State must be 'ENABLED' or 'DISABLED'")

    // Initialisation par défaut à "enabled"
    String state = "enabled";



}

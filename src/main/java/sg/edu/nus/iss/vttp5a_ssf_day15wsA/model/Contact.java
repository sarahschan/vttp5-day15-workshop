package sg.edu.nus.iss.vttp5a_ssf_day15wsA.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.validation.ValidDate;

public class Contact {
    
    private String id;

        @NotBlank(message = "Name is mandatory ") 
        @Size(min = 3, max = 64, message = "Name must be between 3 and 64 characters")
        @Pattern(regexp = "^[a-zA-Z@\\-\\s]*$", message = "Name can only contain alphabets, spaces, '@', or '-'")
    private String name;

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Please enter a valid email address")
    private String email;

        @NotBlank(message = "Phone number is mandatory")
        @Pattern(regexp = "^\\d{7,}$", message = "Phone number can only contain digits, must be at least 7 digits long")
    private String phone;

        @NotNull(message = "Date of birth is mandatory")
        @Past(message = "Birth date must be a past date")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @ValidDate
    private LocalDate dob;



    public Contact() {
    }

    public Contact(String name, String email, String phone, LocalDate dob) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public Contact(String id, String name, String email, String phone, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + phone + "," + dob;
    }

}

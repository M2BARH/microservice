package za.co.protogen.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

// user entity class
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "user-sequence", sequenceName = "user-sequence", allocationSize = 1)
    // user properties
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "rsa_id")
    private String rsaId;

    // user empty constructor
    public User() {
    }

    public User(Long id, String firstName, String lastName,
                LocalDate dateOfBirth,
                String rsaId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.rsaId = rsaId;
    }

    // start of user getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRsaId() {
        return rsaId;
    }

    public void setRsaId(String rsaId) {
        this.rsaId = rsaId;
    }

    // end of user getters and setters

    // toString method, that return formatted result
    @Override
    public String toString() {
        return "User: {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", rsaId='" + rsaId + '\'' +
                '}';
    }
}

package za.co.protogen.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

// Reservation entity
@Entity
@Table
public class Reservation {

    // reservation properties
    @Id
    @SequenceGenerator(name = "reservation-sequence", sequenceName = "reservation-sequence", allocationSize = 1)
    private Long id;
    private Long userId;
    private Long carId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String pickUpLocation;
    private String dropOffLocation;

    // reservation null args constructor
    public Reservation() {
    }

    public Reservation(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOffLocation) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    // beginning of getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
    // end of getters and setters
}

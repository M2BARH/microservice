//package za.co.protogen.persistance.repository.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//// Reservation entity
//@Entity
//@Table(name = "reservation")
//public class ReservationEntity {
//
//    // reservation properties
//    @Id
//    @Column(name = "id")
//    @SequenceGenerator(name = "reservation-sequence", sequenceName = "reservation-sequence", allocationSize = 1)
//    private Long id;
//    @Column(name = "user_id")
//    private Long userId;
//    @Column(name = "car_id")
//    private Long carId;
//    @Column(name = "from_date")
//    private LocalDate fromDate;
//    @Column(name = "to_date")
//    private LocalDate toDate;
//    @Column(name = "pick_up_location")
//    private String pickUpLocation;
//    @Column(name = "drop_of_location")
//    private String dropOffLocation;
//
//    // reservation null args constructor
//    public ReservationEntity() {
//    }
//
//    public ReservationEntity(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOffLocation) {
//        this.id = id;
//        this.userId = userId;
//        this.carId = carId;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
//        this.pickUpLocation = pickUpLocation;
//        this.dropOffLocation = dropOffLocation;
//    }
//
//    // beginning of getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getCarId() {
//        return carId;
//    }
//
//    public void setCarId(Long carId) {
//        this.carId = carId;
//    }
//
//    public LocalDate getFromDate() {
//        return fromDate;
//    }
//
//    public void setFromDate(LocalDate fromDate) {
//        this.fromDate = fromDate;
//    }
//
//    public LocalDate getToDate() {
//        return toDate;
//    }
//
//    public void setToDate(LocalDate toDate) {
//        this.toDate = toDate;
//    }
//
//    public String getPickUpLocation() {
//        return pickUpLocation;
//    }
//
//    public void setPickUpLocation(String pickUpLocation) {
//        this.pickUpLocation = pickUpLocation;
//    }
//
//    public String getDropOffLocation() {
//        return dropOffLocation;
//    }
//
//    public void setDropOffLocation(String dropOffLocation) {
//        this.dropOffLocation = dropOffLocation;
//    }
//    // end of getters and setters
//}

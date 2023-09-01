package za.co.protogen.controller.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ReservationDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-08-21T00:50:30.701153200+02:00[Africa/Johannesburg]")


public class ReservationDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("cardId")
  private Long carId = null;

  @JsonProperty("fromDate")
  private String fromDate = null;

  @JsonProperty("toDate")
  private String toDate = null;

  @JsonProperty("pickUpLocation")
  private String pickUpLocation = null;

  @JsonProperty("dropOffLocation")
  private String dropOffLocation = null;

  public ReservationDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ReservationDTO userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @Schema(description = "")

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ReservationDTO cardId(Long cardId) {
    this.carId = cardId;
    return this;
  }

  /**
   * Get cardId
   * @return cardId
   **/
  @Schema(description = "")

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public ReservationDTO fromDate(String fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
   **/
  @Schema(description = "")

  @Valid
  public String getFromDate() {
    return fromDate;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public ReservationDTO toDate(String toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
   **/
  @Schema(description = "")

  @Valid
  public String getToDate() {
    return toDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public ReservationDTO pickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
    return this;
  }

  /**
   * Get pickUpLocation
   * @return pickUpLocation
   **/
  @Schema(description = "")

  public String getPickUpLocation() {
    return pickUpLocation;
  }

  public void setPickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
  }

  public ReservationDTO dropOffLocation(String dropOffLocation) {
    this.dropOffLocation = dropOffLocation;
    return this;
  }

  /**
   * Get dropOffLocation
   * @return dropOffLocation
   **/
  @Schema(description = "")

  public String getDropOffLocation() {
    return dropOffLocation;
  }

  public void setDropOffLocation(String dropOffLocation) {
    this.dropOffLocation = dropOffLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationDTO reservationDTO = (ReservationDTO) o;
    return Objects.equals(this.id, reservationDTO.id) &&
            Objects.equals(this.userId, reservationDTO.userId) &&
            Objects.equals(this.carId, reservationDTO.carId) &&
            Objects.equals(this.fromDate, reservationDTO.fromDate) &&
            Objects.equals(this.toDate, reservationDTO.toDate) &&
            Objects.equals(this.pickUpLocation, reservationDTO.pickUpLocation) &&
            Objects.equals(this.dropOffLocation, reservationDTO.dropOffLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, carId, fromDate, toDate, pickUpLocation, dropOffLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationDTO {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    cardId: ").append(toIndentedString(carId)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
    sb.append("    pickUpLocation: ").append(toIndentedString(pickUpLocation)).append("\n");
    sb.append("    dropOffLocation: ").append(toIndentedString(dropOffLocation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

package za.co.protogen.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Objects;

/**
 * CarDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-08-21T03:43:43.329248900+02:00[Africa/Johannesburg]")


public class CarDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("vin")
  private String vin = null;

  @JsonProperty("make")
  private String make = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("carYear")
  private Integer carYear = null;

  @JsonProperty("color")
  private String color = null;

  @JsonProperty("engine")
  private String engine = null;

  @JsonProperty("transmission")
  private String transmission = null;

  @JsonProperty("fuelType")
  private String fuelType = null;

  @JsonProperty("mileage")
  private String mileage = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("ownerId")
  private Double ownerId = null;

  @JsonProperty("features")
  private ArrayList features = null;

  public CarDTO carId(Long carId) {
    this.id = carId;
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

  public CarDTO vin(String vin) {
    this.vin = vin;
    return this;
  }

  /**
   * Get vin
   * @return vin
   **/
  @Schema(description = "")
  
    public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public CarDTO make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
   **/
  @Schema(description = "")
  
    public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public CarDTO model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
   **/
  @Schema(description = "")
  
    public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public CarDTO carYear(Integer carYear) {
    this.carYear = carYear;
    return this;
  }

  /**
   * Get carYear
   * @return carYear
   **/
  @Schema(description = "")
  
    public Integer getCarYear() {
    return carYear;
  }

  public void setCarYear(Integer carYear) {
    this.carYear = carYear;
  }

  public CarDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
   **/
  @Schema(description = "")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public CarDTO engine(String engine) {
    this.engine = engine;
    return this;
  }

  /**
   * Get engine
   * @return engine
   **/
  @Schema(description = "")
  
    public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public CarDTO transmission(String transmission) {
    this.transmission = transmission;
    return this;
  }

  /**
   * Get transmission
   * @return transmission
   **/
  @Schema(description = "")
  
    public String getTransmission() {
    return transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public CarDTO fuelType(String fuelType) {
    this.fuelType = fuelType;
    return this;
  }

  /**
   * Get fuelType
   * @return fuelType
   **/
  @Schema(description = "")
  
    public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public CarDTO mileage(String mileage) {
    this.mileage = mileage;
    return this;
  }

  /**
   * Get mileage
   * @return mileage
   **/
  @Schema(description = "")
  
    public String getMileage() {
    return mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public CarDTO price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(description = "")
  
    public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public CarDTO ownerId(Double ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
   **/
  @Schema(description = "")
  
    public Double getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Double ownerId) {
    this.ownerId = ownerId;
  }

  public CarDTO features(ArrayList features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
   **/
  @Schema(description = "")
  
    @Valid
    public ArrayList getFeatures() {
    return features;
  }

  public void setFeatures(ArrayList features) {
    this.features = features;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarDTO carDTO = (CarDTO) o;
    return Objects.equals(this.vin, carDTO.vin) &&
        Objects.equals(this.make, carDTO.make) &&
        Objects.equals(this.model, carDTO.model) &&
        Objects.equals(this.carYear, carDTO.carYear) &&
        Objects.equals(this.color, carDTO.color) &&
        Objects.equals(this.engine, carDTO.engine) &&
        Objects.equals(this.transmission, carDTO.transmission) &&
        Objects.equals(this.fuelType, carDTO.fuelType) &&
        Objects.equals(this.mileage, carDTO.mileage) &&
        Objects.equals(this.price, carDTO.price) &&
        Objects.equals(this.ownerId, carDTO.ownerId) &&
        Objects.equals(this.features, carDTO.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vin, make, model, carYear, color, engine, transmission, fuelType, mileage, price, ownerId, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarDTO {\n");
    
    sb.append("    vin: ").append(toIndentedString(vin)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    carYear: ").append(toIndentedString(carYear)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    transmission: ").append(toIndentedString(transmission)).append("\n");
    sb.append("    fuelType: ").append(toIndentedString(fuelType)).append("\n");
    sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

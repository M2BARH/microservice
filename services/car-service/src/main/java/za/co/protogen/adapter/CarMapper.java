package za.co.protogen.adapter;

import za.co.protogen.controller.models.CarDTO;
import org.mapstruct.Mapper;
import za.co.protogen.domain.Car;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO carToDTO(Car car);
    List<CarDTO> carToDTO(List<Car> car);
    Car dtoToCar(CarDTO carDTO);
}

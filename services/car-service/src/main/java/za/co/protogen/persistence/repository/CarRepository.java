package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import za.co.protogen.domain.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    void deleteByVin(String vin);
    boolean existsByVin(String vin);
    Car findByVin(String vin);
    List<Car> findByMake(String make);
    List<Car> findByCarYear(int carYear);
    List<Car> findByColor(String color);
}

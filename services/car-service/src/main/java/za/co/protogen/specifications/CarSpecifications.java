package za.co.protogen.specifications;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import za.co.protogen.domain.Car;
import za.co.protogen.searchCriteria.CarSearchCriteria;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CarSpecifications {

    public static Specification<Car> builderSpecification(CarSearchCriteria criteria) {
        return  (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), criteria.getId()));
            }

            if (criteria.getVin() != null) {
                predicates.add(criteriaBuilder.equal(root.get("vin"), criteria.getVin()));
            }

            if (criteria.getMake() != null) {
                predicates.add(criteriaBuilder.equal(root.get("make"), criteria.getMake()));
            }

            if (criteria.getModel() != null) {
                predicates.add(criteriaBuilder.equal(root.get("model"), criteria.getModel()));
            }

            if (criteria.getColor() != null) {
                predicates.add(criteriaBuilder.equal(root.get("color"), criteria.getColor()));
            }

            if (criteria.getEngine() != null) {
                predicates.add(criteriaBuilder.equal(root.get("engine"), criteria.getEngine()));
            }

            if (criteria.getTransmission() != null) {
                predicates.add(criteriaBuilder.equal(root.get("transmission"), criteria.getTransmission()));
            }

            if (criteria.getFuelType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), criteria.getFuelType()));
            }

            if (criteria.getCarYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("carYear"), criteria.getCarYear()));
            }

            if (criteria.getMileage() != null) {
                predicates.add(criteriaBuilder.equal(root.get("mileage"), criteria.getMileage()));
            }

            if (criteria.getPrice() != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), criteria.getPrice()));
            }

            if (criteria.getOwnerId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("ownerId"), criteria.getOwnerId()));
            }

            if (criteria.getFeatures() != null) {
                predicates.add(criteriaBuilder.equal(root.get("features"), criteria.getFeatures()));
            }

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}

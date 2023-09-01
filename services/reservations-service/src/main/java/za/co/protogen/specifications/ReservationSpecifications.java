package za.co.protogen.specifications;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import za.co.protogen.domain.Reservation;
import za.co.protogen.searchCriteria.SearchCriteria;

@RequiredArgsConstructor
public class ReservationSpecifications {

    public static Specification<Reservation> buildSpecification(SearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getUserId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("userId"), criteria.getUserId()));
            }

            if (criteria.getCarId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("carId"), criteria.getCarId()));
            }

            if (criteria.getFromDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("fromDate"),
                        criteria.getFromDate()));
            }

            if (criteria.getToDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("toDate"),
                        criteria.getToDate()));
            }

            if (criteria.getPickUpLocation() != null) {
                predicates.add(criteriaBuilder.equal(root.get("pickUpLocation"),
                        criteria.getPickUpLocation()));
            }

            if (criteria.getDropOffLocation() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dropOffLocation"),
                        criteria.getDropOffLocation()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

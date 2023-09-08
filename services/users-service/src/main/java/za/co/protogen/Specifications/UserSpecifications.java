package za.co.protogen.Specifications;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import za.co.protogen.domain.User;
import za.co.protogen.searchCriteria.UserSearchCriteria;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserSpecifications {

    public static Specification<User> buildSpecification(UserSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), criteria.getId()));
            }

            if (criteria.getFirstName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("firstName"), criteria.getFirstName()));
            }

            if (criteria.getLastName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), criteria.getLastName()));
            }

            if (criteria.getDateOfBirth() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dateOfBirth"), criteria.getDateOfBirth()));
            }

            if (criteria.getRsaId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("rsaId"), criteria.getRsaId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

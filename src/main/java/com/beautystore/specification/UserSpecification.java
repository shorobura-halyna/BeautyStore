package com.beautystore.specification;

import com.beautystore.dto.request.filter.FilterUserRequest;
import com.beautystore.dto.request.filter.OneFilterUserRequest;
import com.beautystore.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserSpecification implements Specification<User> {

    private FilterUserRequest filterUserRequest;

    public UserSpecification(FilterUserRequest filterUserRequest) {
        this.filterUserRequest = filterUserRequest;
    }

    private Predicate filterByAge(Root<User> root, CriteriaBuilder criteriaBuilder, OneFilterUserRequest oneFilterUserRequest) {
        if (oneFilterUserRequest.getFirstValue() != null && oneFilterUserRequest.getSecondValue() != null) {
            return criteriaBuilder.between(root.get("age"), Integer.parseInt(oneFilterUserRequest.getFirstValue()),
                    Integer.parseInt(oneFilterUserRequest.getSecondValue()));
        } else {
            return criteriaBuilder.conjunction();
        }
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return createFilter(root, criteriaBuilder);
    }

    private Predicate createFilter(Root<User> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        filterUserRequest.getOneFilterUserRequests().forEach(oneFilterUserRequest -> {
            switch (oneFilterUserRequest.getUserSearchCriteria()) {
                case BY_AGE_BETWEEN: {
                    predicates.add(filterByAge(root, criteriaBuilder, oneFilterUserRequest));
                    break;
                }
            }
        });
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

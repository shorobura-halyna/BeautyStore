package com.beautystore.specification;

import com.beautystore.dto.request.filter.FilterCommodityRequest;
import com.beautystore.dto.request.filter.OneFilterCommodityRequest;
import com.beautystore.model.Brand;
import com.beautystore.model.Commodity;
import com.beautystore.model.Subcategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommoditySpecification implements Specification<Commodity> {
    private FilterCommodityRequest filterCommodityRequest;

    public CommoditySpecification(FilterCommodityRequest filterCommodityRequest) {
        this.filterCommodityRequest = filterCommodityRequest;
    }

    private Predicate filterByBrand(Root<Commodity> root, CriteriaBuilder criteriaBuilder, OneFilterCommodityRequest oneFilterCommodityRequest) {
        Join<Commodity, Brand> joinCommodityToBrand = root.join("brand");
        return criteriaBuilder.equal(joinCommodityToBrand.get("name"), oneFilterCommodityRequest.getFirstValue());
    }

    private Predicate filterByName(Root<Commodity> root, CriteriaBuilder criteriaBuilder, OneFilterCommodityRequest oneFilterCommodityRequest) {
        return criteriaBuilder.like(root.get("name"), "%" + oneFilterCommodityRequest.getFirstValue() + "%");
    }

    private Predicate filterByPriceBetween(Root<Commodity> root, CriteriaBuilder criteriaBuilder, OneFilterCommodityRequest oneFilterCommodityRequest) {
        if (oneFilterCommodityRequest.getFirstValue() != null && oneFilterCommodityRequest.getSecondValue() != null) {
            return criteriaBuilder.between(root.get("price"), Integer.parseInt(oneFilterCommodityRequest.getFirstValue()),
                    Integer.parseInt(oneFilterCommodityRequest.getSecondValue()));
        } else {
            return criteriaBuilder.conjunction();
        }
    }

    private Predicate filterBySubcategory(Root<Commodity> root, CriteriaBuilder criteriaBuilder, OneFilterCommodityRequest oneFilterCommodityRequest) {
        Join<Commodity, Subcategory> joinCommodityToBrand = root.join("subcategory");
        return criteriaBuilder.equal(joinCommodityToBrand.get("name"), oneFilterCommodityRequest.getFirstValue());
    }

    private Predicate filterByPriceLessThen(Root<Commodity> root, CriteriaBuilder criteriaBuilder, OneFilterCommodityRequest oneFilterCommodityRequest) {
        if (oneFilterCommodityRequest.getFirstValue() != null) {
            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), oneFilterCommodityRequest.getFirstValue());
        } else {
            return criteriaBuilder.conjunction();
        }
    }

    private Predicate filterByPriceMoreThen(Root<Commodity> root, CriteriaBuilder criteriaBuilder, OneFilterCommodityRequest oneFilterCommodityRequest) {
        if (oneFilterCommodityRequest.getFirstValue() != null) {
            return criteriaBuilder.greaterThan(root.get("price"), oneFilterCommodityRequest.getFirstValue());
        } else {
            return criteriaBuilder.conjunction();
        }
    }


    private Predicate createFilter(Root<Commodity> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        filterCommodityRequest.getOneFilterCommodityRequests().forEach(oneFilterCommodityRequest -> {
            switch (oneFilterCommodityRequest.getCommoditySearchCriteria()) {
                case BY_BRAND: {
                    predicates.add(filterByBrand(root, criteriaBuilder, oneFilterCommodityRequest));
                    break;
                }
                case BY_NAME: {
                    predicates.add(filterByName(root, criteriaBuilder, oneFilterCommodityRequest));
                    break;
                }
                case BY_SUBCATEGORY: {
                    predicates.add(filterBySubcategory(root, criteriaBuilder, oneFilterCommodityRequest));
                    break;
                }
                case BY_PRICE_BETWEEN: {
                    predicates.add(filterByPriceBetween(root, criteriaBuilder, oneFilterCommodityRequest));
                    break;
                }
                case BY_PRICE_MORE_THEN: {
                    predicates.add(filterByPriceMoreThen(root, criteriaBuilder, oneFilterCommodityRequest));
                    break;
                }
                case BY_PRICE_LESS_THEN: {
                    predicates.add(filterByPriceLessThen(root, criteriaBuilder, oneFilterCommodityRequest));
                    break;
                }
            }
        });
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    @Override
    public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return createFilter(root, criteriaBuilder);
    }

}

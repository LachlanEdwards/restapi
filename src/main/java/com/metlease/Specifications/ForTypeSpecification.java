package com.metlease.Specifications;

import com.metlease.Entity.ForLease;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForTypeSpecification {
    public static Specification<ForLease> findAllForTypeByParam(int id, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        return new Specification<ForLease>() {
            @Override
            public Predicate toPredicate(Root<ForLease> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.equal(root.join("apartment").join("building").get("id"), id));
                if (bed.isPresent()) {
                    predicates.add(cb.equal(root.join("apartment").get("bedroom"), bed.get()));
                }
                if (bath.isPresent()) {
                    predicates.add(cb.equal(root.join("apartment").get("bathroom"), bath.get()));
                }
                if (garage.isPresent()) {
                    predicates.add(cb.equal(root.join("apartment").get("garage"), garage.get()));
                }
                if (price.isPresent()) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("cost"), price.get()));
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    };
}

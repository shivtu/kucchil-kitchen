package com.example.retail.repository.edibleproducts;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class EdibleProductsInventoryRepositoryImpl extends EdibleProductsInventoryRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    // @Override
    // Custom native queries here, see example from VegetableInventoryRepositoryImpl
    // Add this method to EdibleProductsInventoryRepositoryCustom
}

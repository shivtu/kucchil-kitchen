package com.example.retail.models.vegetables.repository;

import com.example.retail.models.jsonmodels.InventoryAdditionDetails;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.query.NativeQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class VegetableInventoryRepositoryImpl implements VegetableInventoryRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int updateVegetablesAdditionDetails(String subId, List<InventoryAdditionDetails> updatedAdditionDetails) {

        String psqlQuery = "UPDATE vegetables_inventory SET vegetablesinventory_addtiondetails = vegetablesinventory_addtiondetails || :updatedAdditionDetails WHERE vegetable_subid=:subId";

        return entityManager.createNativeQuery(psqlQuery)
            .unwrap(NativeQuery.class)
            .setParameter("updatedAdditionDetails", updatedAdditionDetails, JsonBinaryType.INSTANCE)
            .setParameter("subId", subId)
            .executeUpdate();
    }
}

package com.example.retail.models.vegitables.repository;

import com.example.retail.models.vegitables.VegitableAdditionDetails;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.query.NativeQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class VegitableInventoryRepositoryImpl implements VegitableInventoryRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int updateVegitablesAdditionDetails(String subId, List<VegitableAdditionDetails> updatedAdditionDetails) {

        String psqlQuery = "UPDATE vegitables_inventory  SET vegitablesinventory_addtiondetails = vegitablesinventory_addtiondetails || :updatedAdditionDetails WHERE vegitable_subid=:subId";

        return entityManager.createNativeQuery(psqlQuery)
                .unwrap(NativeQuery.class)
                .setParameter("updatedAdditionDetails", updatedAdditionDetails, JsonBinaryType.INSTANCE)
                .setParameter("subId", subId)
                .executeUpdate();

    }
}

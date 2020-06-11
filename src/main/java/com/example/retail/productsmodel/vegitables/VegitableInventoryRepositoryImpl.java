package com.example.retail.productsmodel.vegitables;

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

        String psqlQuery = "UPDATE vegitables_inventory  SET vegitablesinventory_addtion_details = vegitablesinventory_addtion_details || :updatedAdditionDetails WHERE vegitable_subid=:subId";

        return entityManager.createNativeQuery(psqlQuery)
                .unwrap(NativeQuery.class)
                .setParameter("updatedAdditionDetails", updatedAdditionDetails, JsonBinaryType.INSTANCE)
                .setParameter("subId", subId)
                .executeUpdate();

    }
}

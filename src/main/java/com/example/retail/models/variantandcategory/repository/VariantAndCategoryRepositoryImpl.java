package com.example.retail.models.variantandcategory.repository;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class VariantAndCategoryRepositoryImpl implements VariantAndCategoryRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int addVariants(String itemCategorySubId, List<String> variantList) {
        String psqlQuery = "UPDATE variant_and_category SET variants = variants || :variantList WHERE item_category_sub_id=:itemCategorySubId";
        System.out.println(psqlQuery);
        return entityManager.createNativeQuery(psqlQuery)
            .unwrap(NativeQuery.class)
            .setParameter("variantList", variantList, JsonBinaryType.INSTANCE)
            .setParameter("itemCategorySubId", itemCategorySubId)
            .executeUpdate();
    }
}

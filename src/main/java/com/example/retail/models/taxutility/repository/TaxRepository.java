package com.example.retail.models.taxutility.repository;

import com.example.retail.models.taxutility.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository<Taxes, Integer> {

    @Query(value = "SELECT * FROM taxes WHERE tax_name = :applicableTax", nativeQuery = true)
    Optional<Taxes> findBytaxName(@Param("applicableTax") String applicableTax);
}

package com.example.retail.repository.deliveryutility;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryChargesRepository extends JpaRepository<DeliveryCharges, Integer> {
}

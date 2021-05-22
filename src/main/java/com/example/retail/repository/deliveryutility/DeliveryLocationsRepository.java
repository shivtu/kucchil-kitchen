package com.example.retail.repository.deliveryutility;

import com.example.retail.models.deliveryutility.DeliveryLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryLocationsRepository extends JpaRepository<DeliveryLocations, Long> {

    @Query(value = "SELECT * FROM delivery_locations WHERE  delivery_location_subid = :deliveryLocationsSubId", nativeQuery = true)
    public Optional<DeliveryLocations> findDeliveryLocationBySubId(@Param("deliveryLocationsSubId") String deliveryLocationsSubId);
}

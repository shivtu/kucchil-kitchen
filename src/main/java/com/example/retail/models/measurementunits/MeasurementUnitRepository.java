package com.example.retail.models.measurementunits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnits, Long> {
}

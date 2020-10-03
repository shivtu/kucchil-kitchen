package com.example.retail.models.measurementunits;

import com.example.retail.models.jsonmodels.DenominationList;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "measurement_units")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class MeasurementUnits {

    @Id
    @Column(name = "measurement_unit-table_id")
    private Long measurementUnitTableId;

    @NotEmpty
    @Column(name = "measurement_unit_name", unique = true)
    private String measurementUnitName;

    @Column(name = "denomination_list", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<DenominationList> denominationList;

    public MeasurementUnits() {}

    public MeasurementUnits(String measurementUnitName, List<DenominationList> denominationList) {
        this.measurementUnitName = measurementUnitName;
        this.denominationList = denominationList;
    }

    public String getMeasurementUnitName() {
        return measurementUnitName;
    }

    public void setMeasurementUnitName(String measurementUnitName) {
        this.measurementUnitName = measurementUnitName;
    }

    public List<DenominationList> getDenominationList() {
        return denominationList;
    }

    public void setDenominationList(List<DenominationList> denominationList) {
        this.denominationList = denominationList;
    }
}

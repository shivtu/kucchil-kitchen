package com.example.retail.models.vegitables.services;

import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.repository.VegitablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegitablesService {

    @Autowired
    private VegitablesRepository vegitablesRepository;

    public Iterable<Vegitables> getAllVegitables() {
        return vegitablesRepository.findAll();
    }

    public Optional<Vegitables> findById(Long id) {
        return vegitablesRepository.findById(id);
    }

    public Optional<Vegitables> findBySubId(String subId) { return vegitablesRepository.findBySubId(subId); }

    public Iterable<Vegitables> addAllVegitables(List<Vegitables> newVegitables) {
        return vegitablesRepository.saveAll(newVegitables);
    }

    public Vegitables addOneVegitable(Vegitables newVegitable) {
        return vegitablesRepository.save(newVegitable);
    }

    public Optional<Vegitables> getVegitableByTableId(Long vegitableTableId) {
        return vegitablesRepository.findById(vegitableTableId);
    }

    public Integer updateVegitablesQty(String subId, Float increamentCount) {
        return vegitablesRepository.updateVegitablesQty(subId, increamentCount);
    }
}

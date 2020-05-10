package com.example.retail.productsmodel.vegitables;

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

    public Iterable<Vegitables> addAllVegitables(List<Vegitables> newVegitables) {
        return vegitablesRepository.saveAll(newVegitables);
    }

    public Vegitables addOneVegitable(Vegitables newVegitable) {
        return vegitablesRepository.save(newVegitable);
    }

    public Optional<Vegitables> getVegitableByTableId(Long vegitableTableId) {
        return vegitablesRepository.findById(vegitableTableId);
    }
}

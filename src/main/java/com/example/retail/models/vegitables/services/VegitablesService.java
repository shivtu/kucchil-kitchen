package com.example.retail.models.vegitables.services;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.models.vegitables.VegitableRecipes;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.repository.VegitablesRepository;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.UnableToSetId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public Vegitables addVegitable(Vegitables vegitables) {
        return vegitablesRepository.save(vegitables);
    }

    public Optional<Vegitables> getVegitableByTableId(Long vegitableTableId) {
        return vegitablesRepository.findById(vegitableTableId);
    }

    public Integer updateVegitablesQty(String subId, Float increamentCount) {
        return vegitablesRepository.updateVegitablesQty(subId, increamentCount);
    }
}

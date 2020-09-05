package com.example.retail.models.edibleproducts.services;

import com.example.retail.controllers.retailer.edibleproducts_retailer.AddEdibleProductsRequestBody;
import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.repository.EdibleProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EdibleProductsService {

    @Autowired
    EdibleProductsRepository edibleProductsRepository;

    public String genearteEdibleProductSubId(
            String edibleProductManufacturer,
            String edibleProductName,
            String edibleProductVariant,
            String edibleProductFlavor,
            Float edibleProductDenomination,
            LocalDate edibleProductInventoryExpiry
    ) {
        return edibleProductManufacturer.toLowerCase()
                + edibleProductName.toLowerCase()
                + edibleProductVariant.toLowerCase()
                + edibleProductFlavor.toLowerCase()
                + edibleProductDenomination.toString().toLowerCase()
                + edibleProductInventoryExpiry.toString().toLowerCase();
    }

    public List<EdibleProducts> getAllProducts(){
        return  edibleProductsRepository.findAll();
    }

    public Optional<EdibleProducts> getProductById(Long productId) {
        return edibleProductsRepository.findById(productId);
    }

    public Iterable<EdibleProducts> addAllEdibleProducts(List<EdibleProducts> newProducts) {
        return edibleProductsRepository.saveAll(newProducts);
    }

    public EdibleProducts addEdibleProduct(AddEdibleProductsRequestBody newEdibleProduct){
        EdibleProducts edibleProducts = new EdibleProducts();
        edibleProducts.setEdibleProductManufacturer(newEdibleProduct.getEdibleProductManufacturer());
        edibleProducts.setEdibleProductName(newEdibleProduct.getEdibleProductName());
        edibleProducts.setEdibleProductVariant(newEdibleProduct.getEdibleProductVariant());
        edibleProducts.setEdibleProductFlavor(newEdibleProduct.getEdibleProductFlavor());
        edibleProducts.setEdibleProductType(newEdibleProduct.getEdibleProductType());
        edibleProducts.setEdibleProductDescription(newEdibleProduct.getEdibleProductDescription());
        edibleProducts.setEdibleProductGenericName(newEdibleProduct.getEdibleProductGenericName());
        edibleProducts.setEdibleProductAlternaleName(newEdibleProduct.getEdibleProductAlternaleName());
        edibleProducts.setItemClassificationName(newEdibleProduct.getItemClassificationName());
        edibleProducts.setItemClassificationCode(newEdibleProduct.getItemClassificationCode());
        edibleProducts.setEdibleProductForMinors(newEdibleProduct.getEdibleProductForMinors());
        edibleProducts.setEdibleProductAvailable(newEdibleProduct.getEdibleProductAvailable());
        edibleProducts.setEdibleProductMrp(newEdibleProduct.getEdibleProductMrp());
        edibleProducts.setEdibleProductOfferedDiscount(newEdibleProduct.getEdibleProductOfferedDiscount());
        edibleProducts.setEdibleProductsDiscountName(newEdibleProduct.getEdibleProductsDiscountName());
        edibleProducts.setEdibleProductApplicableTaxes(newEdibleProduct.getEdibleProductApplicableTaxes());
        edibleProducts.setEdibleProductQuantity(newEdibleProduct.getEdibleProductQuantity());
        edibleProducts.setEdibleProductsMeasureMentUnit(newEdibleProduct.getEdibleProductsMeasureMentUnit());
        edibleProducts.setEdibleProductDenomination(newEdibleProduct.getEdibleProductDenomination());

        return edibleProductsRepository.save(edibleProducts);
    }

}

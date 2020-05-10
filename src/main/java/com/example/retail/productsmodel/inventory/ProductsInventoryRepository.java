package com.example.retail.productsmodel.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsInventoryRepository extends JpaRepository<ProductsInventory, Integer> {
}

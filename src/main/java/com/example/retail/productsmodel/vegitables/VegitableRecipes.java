package com.example.retail.productsmodel.vegitables;

import java.io.Serializable;
import java.util.List;

public class VegitableRecipes implements Serializable {

    private String recipeName;
    private String recipeGuide;
    private List<String> recipeComponents;

    public VegitableRecipes(){}

    public VegitableRecipes(String recipeName, String recipeGuide, List<String> recipeComponents) {
        this.recipeName = recipeName;
        this.recipeGuide = recipeGuide;
        this.recipeComponents = recipeComponents;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeGuide() {
        return recipeGuide;
    }

    public void setRecipeGuide(String recipeGuide) {
        this.recipeGuide = recipeGuide;
    }

    public List<String> getRecipeComponents() {
        return recipeComponents;
    }

    public void setRecipeComponents(List<String> recipeComponents) {
        this.recipeComponents = recipeComponents;
    }
}

package edu.ewubd.food_ordering_mobileapp.Models;

public class FoodItem {

    private String name;
    private String description;
    private String price;
    private int image;

    public FoodItem() {
    }

    public FoodItem(String name, String description, String price, int image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

}

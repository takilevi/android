package hu.py82c7.homework.app.utils;

/**
 * Created by TAKI on 2016.12.11..
 */

public class Food {
    private String name, category;
    private int price;
    public Food(String name, String category, int price){
        this.name = name;
        this.category = category;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

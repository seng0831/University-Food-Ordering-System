/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hw
 */
public class MenuItem implements Displayable {
    private String foodcode;
    private String name;
    private double price;

    public MenuItem(String foodcode, String name, double price) {
        this.foodcode = foodcode;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return foodcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Implementing the displayInfo method from the Displayable interface
    @Override
    public void displayInfo() {
    }
}

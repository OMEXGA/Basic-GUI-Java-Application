/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CartItem {
    private final String name;
    private final String size;
    private final double price;
    private int quantity;
    private final String imagePath; 

    public CartItem(String name, String size, double price, int quantity, String imagePath) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getImagePath() { return imagePath; }

    public Icon getImage() {
        if (imagePath != null && !imagePath.isEmpty()) {
            return new ImageIcon(getClass().getResource(imagePath));
        }
        return null;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String toFileString(String userEmail) {
        return String.join(",", userEmail, name, size, String.valueOf(price), String.valueOf(quantity), imagePath);
    }


    public static CartItem fromFileString(String line) {
        String[] parts = line.split(",");
        // parts[0] is the email, which we don't need here
        String name = parts[1];
        String size = parts[2];
        double price = Double.parseDouble(parts[3]);
        int quantity = Integer.parseInt(parts[4]);
        String imagePath = parts[5];
        return new CartItem(name, size, price, quantity, imagePath);
    }
}
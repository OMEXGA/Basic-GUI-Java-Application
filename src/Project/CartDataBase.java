/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartDataBase {

    private static final String CART_FILE = "carts.txt";


    public static List<CartItem> loadCart(String userEmail) {
        List<CartItem> cart = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CART_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(userEmail + ",")) {
                    cart.add(CartItem.fromFileString(line));
                }
            }
        } catch (IOException e) {

        }
        return cart;
    }


    public static void saveCart(String userEmail, List<CartItem> items) {
        List<String> allLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CART_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(userEmail + ",")) {
                    allLines.add(line);
                }
            }
        } catch (IOException e) {

        }


        for (CartItem item : items) {
            allLines.add(item.toFileString(userEmail));
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CART_FILE, false))) { 
            for (String line : allLines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author oombo
 */
public class ProductDataBase {
    private static final List<ProductData> allProducts = new ArrayList<>();

    static {
        allProducts.add(new ProductData("tshirt001", "Pink T-Shirt", 125.0, "T-shirt", "/Images/Tshirt/Tshirt1.jpg"));
        allProducts.add(new ProductData("tshirt002", "Black Cherry T-Shirt", 125.0, "T-shirt", "/Images/Tshirt/Tshirt2.jpg"));
        allProducts.add(new ProductData("tshirt003", "Kitty T-Shirt", 125.0, "T-shirt", "/Images/Tshirt/Tshirt3.jpg"));
        allProducts.add(new ProductData("tshirt004", "Bright Pink T-Shirt", 175.0, "T-shirt", "/Images/Tshirt/Tshirt4.jpg"));
        allProducts.add(new ProductData("tshirt005", "Dusty Blue T-Shirt", 175.0, "T-shirt", "/Images/Tshirt/Tshirt5.jpg"));
        allProducts.add(new ProductData("tshirt006", "Black T-Shirt", 175.0, "T-shirt", "/Images/Tshirt/Tshirt6.jpg"));
        allProducts.add(new ProductData("tshirt007", "Blue T-Shirt", 200.0, "T-shirt", "/Images/Tshirt/Tshirt7.jpg"));
        allProducts.add(new ProductData("tshirt008", "White T-Shirt", 200.0, "T-shirt", "/Images/Tshirt/Tshirt8.jpg"));
        allProducts.add(new ProductData("jeans001", "Black Jean", 200.0, "Jean", "/Images/Jean/Jean1.jpg"));
        allProducts.add(new ProductData("jeans002", "Blue Jean", 200.0, "Jean", "/Images/Jean/Jean2.jpg"));
        allProducts.add(new ProductData("jeans003", "Gray Jean", 200.0, "Jean", "/Images/Jean/Jean3.jpg"));
        allProducts.add(new ProductData("jeans004", "Faded Black Jean", 250.0, "Jean", "/Images/Jean/Jean4.jpg"));
        allProducts.add(new ProductData("jeans005", "Sky Jean", 250.0, "Jean", "/Images/Jean/Jean5.jpg"));
        allProducts.add(new ProductData("jeans006", "Baggy Jean", 250.0, "Jean", "/Images/Jean/Jeans6.jpg"));
        allProducts.add(new ProductData("jeans007", "Wide Leg Jean", 300.0, "Jean", "/Images/Jean/Jeans7.jpg"));
        allProducts.add(new ProductData("necktie001", "Black Neck Tie", 120.0, "Neck Tie", "/Images/NeckTie/Neck1.jpg"));
        allProducts.add(new ProductData("necktie002", "Marine Neck Tie", 120.0, "Neck Tie", "/Images/NeckTie/Neck2.jpg"));
        allProducts.add(new ProductData("necktie003", "Navy Neck Tie", 120.0, "Neck Tie", "/Images/NeckTie/Neck3.jpg"));
        allProducts.add(new ProductData("necktie004", "Red Neck Tie", 150.0, "Neck Tie", "/Images/NeckTie/Neck4.jpg"));
        allProducts.add(new ProductData("necktie005", "Punk Neck Tie", 150.0, "Neck Tie", "/Images/NeckTie/Neck5.jpg"));
        allProducts.add(new ProductData("necktie006", "Blue Neck Tie", 150.0, "Neck Tie", "/Images/NeckTie/Neck6.jpg"));
        allProducts.add(new ProductData("shirt001", "Black Short Shirt", 180.0, "Shirt", "/Images/Shirt/Shirt1.jpg"));
        allProducts.add(new ProductData("shirt002", "White Long Shirt", 180.0, "Shirt", "/Images/Shirt/Shirt2.jpg"));
        allProducts.add(new ProductData("shirt003", "Gray Short Shirt", 180.0, "Shirt", "/Images/Shirt/Shirt3.jpg"));
        allProducts.add(new ProductData("shirt004", "Navy Long Shirt", 175.0, "Shirt", "/Images/Shirt/Shirt4.jpg"));
        allProducts.add(new ProductData("shirt005", "Yellow Long Shirt", 165.0, "Shirt", "/Images/Shirt/Shirt5.jpg"));
        allProducts.add(new ProductData("shirt006", "Bright Yellow Shirt", 175.0, "Shirt", "/Images/Shirt/Shirt6.jpg"));
        allProducts.add(new ProductData("shirt007", "Cream Shirt", 160.0, "Shirt", "/Images/Shirt/Shirt7.jpg"));
        allProducts.add(new ProductData("shirt008", "Grid Check Shirt", 170.0, "Shirt", "/Images/Shirt/Shirt8.jpg"));
        allProducts.add(new ProductData("skirt001", "Black Long Skirt", 180.0, "Skirt", "/Images/skirt/Skirt1.jpg"));
        allProducts.add(new ProductData("skirt002", "Navy Short Skirt", 180.0, "Skirt", "/Images/skirt/Skirt2.jpg"));
        allProducts.add(new ProductData("skirt003", "Black Short Skirt", 180.0, "Skirt", "/Images/skirt/Skirt3.jpg"));
        allProducts.add(new ProductData("skirt004", "Tennis Skirt", 175.0, "Skirt", "/Images/skirt/Skirt4.jpg"));
        allProducts.add(new ProductData("skirt005", "Red Skirt", 165.0, "Skirt", "/Images/skirt/Skirt5.jpg"));
        allProducts.add(new ProductData("skirt006", "Pastel Blue Skirt", 175.0, "Skirt", "/Images/skirt/Skirt6.jpg"));
        allProducts.add(new ProductData("skirt007", "Tartan Skirt", 200.0, "Skirt", "/Images/skirt/Skirt7.jpg"));
        allProducts.add(new ProductData("sock001", "Black Socks", 55.0, "Sock", "/Images/sock/Sock1.jpg"));
        allProducts.add(new ProductData("sock002", "Blue Socks", 65.0, "Sock", "/Images/sock/Sock2.jpg"));
        allProducts.add(new ProductData("sock003", "Purple Socks", 65.0, "Sock", "/Images/sock/Sock3.jpg"));
        allProducts.add(new ProductData("sock004", "Cherry Socks", 65.0, "Sock", "/Images/sock/Sock4.jpg"));
        allProducts.add(new ProductData("sock005", "White Socks", 65.0, "Sock", "/Images/sock/Sock5.jpg"));
        allProducts.add(new ProductData("sock006", "Kuromi Socks", 75.0, "Sock", "/Images/sock/Sock6.jpg"));
        allProducts.add(new ProductData("sock007", "White Socks", 60.0, "Sock", "/Images/sock/Sock7.jpg"));
        allProducts.add(new ProductData("sock008", "Red Socks", 60.0, "Sock", "/Images/sock/Sock8.jpg"));
    }

    public static ProductData getProductById(String id) {
        for (ProductData product : allProducts) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null; 
    }


    public static List<ProductData> getProductsByCategory(String category, String excludeId) {
        return allProducts.stream()
                .filter(p -> p.getCategory().equals(category) && !p.getId().equals(excludeId))
                .collect(Collectors.toList());
    }
    
    public static ProductData getProductByName(String name) {
            for (ProductData product : allProducts) { 
                if (product.getName().equalsIgnoreCase(name)) {
                    return product;
                }
            }
            return null; 
        }
    
}


package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDataBase {
private static final String ORDERS_FILE = "orders.txt";
    private static final String ORDER_ITEMS_FILE = "order_items.txt";

public static int getNextOrderId(String userEmail) {
    int lastOrderId = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(ORDERS_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";"); 
            
            if (parts.length > 1 && parts[1].equals(userEmail)) {
                try {
                    int orderId = Integer.parseInt(parts[0]);
                    if (orderId > lastOrderId) {
                        lastOrderId = orderId; 
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
    } catch (IOException e) { 
    }
    return lastOrderId + 1;
}

    public static void saveOrder(int orderId, String userEmail, List<CartItem> items, String shippingInfo, double total, String paymentInfo, String promotionUsed) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String now = dtf.format(LocalDateTime.now());
        String orderLine = String.join(";", 
        String.valueOf(orderId), 
        userEmail, 
        now, 
        shippingInfo, 
        String.format("%.2f", total), 
        paymentInfo, 
        promotionUsed
    );

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDERS_FILE, true))) {
            bw.write(orderLine);
            bw.newLine();
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDER_ITEMS_FILE, true))) {
            for (CartItem item : items) {
                String itemLine = String.join(";",
                    String.valueOf(orderId),
                    userEmail,
                    item.getName(),
                    item.getSize(),
                    String.valueOf(item.getPrice()),
                    String.valueOf(item.getQuantity()),
                    item.getImagePath()
                );
                bw.write(itemLine);
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }


public static List<OrderData> loadOrdersForUser(String userEmail) {
    List<OrderData> userOrders = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(ORDERS_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 7 && parts[1].equals(userEmail)) {
                userOrders.add(new OrderData(
                    Integer.parseInt(parts[0]), parts[1], parts[2], "",
                    parts[3], Double.parseDouble(parts[4]), parts[5], parts[6]
                ));
            }
        }
    } catch (IOException e) { /* ... */ }

    Collections.reverse(userOrders);
    return userOrders;
}


// In your OrderDataBase.java file

public static List<CartItem> loadOrderItems(int orderId) {
    List<CartItem> orderItems = new ArrayList<>();
    // Assumes the file is named "order_items.txt"
    try (BufferedReader br = new BufferedReader(new FileReader("order_items.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            
            // THIS IS THE FUCKING PROBLEM. IT MUST BE A SEMICOLON.
            String[] parts = line.split(";"); 
            
            // This check was failing because the line wasn't splitting correctly
            if (parts.length == 7 && Integer.parseInt(parts[0]) == orderId) {
                orderItems.add(new CartItem(
                    parts[2],                         // Name
                    parts[3],                         // Size
                    Double.parseDouble(parts[4]),     // Price
                    Integer.parseInt(parts[5]),       // Quantity
                    parts[6]                          // Image Path
                ));
            }
        }
    } catch (IOException | NumberFormatException e) {
        // This will help find errors in the future
        System.err.println("CRITICAL ERROR loading order items: " + e.getMessage());
        e.printStackTrace();
    }
    return orderItems;
}
}
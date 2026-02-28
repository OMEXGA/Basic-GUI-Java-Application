/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

public class OrderData {
    private final int orderId;
    private final String userEmail;
    private final String date;
    private final String items; 
    private final String shippingInfo;
    private final double total;
    private final String paymentInfo; 
    private final String promotionUsed;

    public OrderData(int orderId, String userEmail, String date, String items, String shippingInfo, double total, String paymentInfo, String promotionUsed) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.date = date;
        this.items = items;
        this.shippingInfo = shippingInfo;
        this.total = total;
        this.paymentInfo = paymentInfo;
        this.promotionUsed = promotionUsed;
    }
    

    public int getOrderId() { return orderId; }
    public String getUserEmail() { return userEmail; }
    public String getDate() { return date; }
    public String getItems() { return items; }
    public String getShippingInfo() { return shippingInfo; }
    public double getTotal() { return total; }
    public String getPaymentInfo() { return paymentInfo; }
    public String getPromotionUsed() { return promotionUsed; }
}

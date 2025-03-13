package com.example;

// These would be separate classes in separate files in a real application
class Customer {
    private String name;
    private String email;
    
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Product {
    private double price;
    private int stockQuantity;
    
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
}

class ShippingProvider {
    private double baseCost;
    private int estimatedDays;
    
    public double getBaseCost() { return baseCost; }
    public int getEstimatedDays() { return estimatedDays; }
}

class PaymentGateway {
    public boolean processPayment(double amount) {
        // Payment processing logic
        return true;
    }
}

class ShippingDetails {
    private ShippingProvider provider;
    
    public ShippingProvider getProvider() { return provider; }
}

class Payment {
    private PaymentGateway gateway;
    
    public PaymentGateway getGateway() { return gateway; }
}

class Order {
    private Customer customer;
    private Product product;
    private ShippingDetails shippingDetails;
    private Payment payment;
    
    public Customer getCustomer() { return customer; }
    public Product getProduct() { return product; }
    public ShippingDetails getShippingDetails() { return shippingDetails; }
    public Payment getPayment() { return payment; }
}

class Logger {
    public void log(String message) {
        // Logging logic
        System.out.println(message);
    }
}

// The class that exceeds the ATFD threshold
public class OrderProcessor {
    private Logger logger = new Logger();
    
    public void processOrder(Order order) {
        // Access to Customer class data (1st unrelated class)
        String customerName = order.getCustomer().getName();
        String customerEmail = order.getCustomer().getEmail();
        
        // Access to Product class data (2nd unrelated class)
        double productPrice = order.getProduct().getPrice();
        int productStock = order.getProduct().getStockQuantity();
        
        // Access to ShippingProvider class data (3rd unrelated class)
        double shippingCost = order.getShippingDetails().getProvider().getBaseCost();
        int deliveryDays = order.getShippingDetails().getProvider().getEstimatedDays();
        
        // Process order logic
        double totalCost = productPrice + shippingCost;
        
        logger.log("Processing order for " + customerName + " with total cost: " + totalCost);
        logger.log("Product will be delivered in " + deliveryDays + " days");
        
        // Access to PaymentGateway class data (4th unrelated class)
        boolean paymentSuccess = order.getPayment().getGateway().processPayment(totalCost);
        
        if (paymentSuccess) {
            logger.log("Payment successful for order from " + customerEmail);
        }
    }
}
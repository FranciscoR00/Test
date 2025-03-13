package com.example;

// Required imports
import java.util.Date;

public class ReportGenerator {
    // Local attributes
    private String reportTitle;
    private Date generationDate;
    private String reportFormat;
    
    // This method has low LAA (poor locality)
    public String generateFinancialReport(Customer customer, Account account, Transaction transaction) {
        StringBuilder report = new StringBuilder();
        
        // Access to LOCAL attributes - count: 3
        report.append(this.reportTitle).append("\n");
        report.append("Generated on: ").append(this.generationDate).append("\n");
        report.append("Format: ").append(this.reportFormat).append("\n\n");
        
        // Access to FOREIGN attributes - count: 10
        
        // Customer attributes - 3
        report.append("Customer: ").append(customer.getName()).append("\n");
        report.append("ID: ").append(customer.getId()).append("\n");
        report.append("Since: ").append(customer.getRegistrationDate()).append("\n\n");
        
        // Account attributes - 4
        report.append("Account Number: ").append(account.getNumber()).append("\n");
        report.append("Type: ").append(account.getType()).append("\n");
        report.append("Balance: $").append(account.getBalance()).append("\n");
        report.append("Status: ").append(account.getStatus()).append("\n\n");
        
        // Transaction attributes - 3
        report.append("Last Transaction: #").append(transaction.getId()).append("\n");
        report.append("Amount: $").append(transaction.getAmount()).append("\n");
        report.append("Date: ").append(transaction.getDate()).append("\n");
        
        return report.toString();
    }
}

// Foreign classes
class Customer {
    private String name;
    private String id;
    private Date registrationDate;
    
    public String getName() { return name; }
    public String getId() { return id; }
    public Date getRegistrationDate() { return registrationDate; }
}

class Account {
    private String number;
    private String type;
    private double balance;
    private String status;
    
    public String getNumber() { return number; }
    public String getType() { return type; }
    public double getBalance() { return balance; }
    public String getStatus() { return status; }
}

class Transaction {
    private String id;
    private double amount;
    private Date date;
    
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public Date getDate() { return date; }
}
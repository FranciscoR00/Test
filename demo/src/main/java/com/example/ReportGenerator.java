package com.example;

// Required imports
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// The target class that will have high ATFD
public class ReportGenerator {
    // This class will access attributes from multiple unrelated classes
    
    public void generateMonthlyReport(Department department) {
        // Accessing Employee class attributes (1st unrelated class)
        List<Employee> employees = department.getEmployees();
        for (Employee employee : employees) {
            // Direct access to attributes from Employee class
            String name = employee.name;  // Direct field access
            double salary = employee.getSalary();  // Accessor method
            
            // Accessing Project class attributes (2nd unrelated class)
            for (Project project : employee.getProjects()) {
                // Direct access to attributes from Project class
                String projectName = project.name;  // Direct field access
                Date deadline = project.getDeadline();  // Accessor method
                
                // Accessing Client class attributes (3rd unrelated class)
                Client client = project.getClient();
                String clientName = client.companyName;  // Direct field access
                String contactPerson = client.getContactPerson();  // Accessor method
                
                // Accessing Budget class attributes (4th unrelated class)
                Budget budget = project.getBudget();
                double allocatedAmount = budget.amount;  // Direct field access
                double expenses = budget.getCurrentExpenses();  // Accessor method
                
                // Using all these foreign attributes
                System.out.println("Employee: " + name + " is working on project: " + projectName);
                System.out.println("Client: " + clientName + " (Contact: " + contactPerson + ")");
                System.out.println("Budget: " + allocatedAmount + " (Spent: " + expenses + ")");
                System.out.println("Deadline: " + deadline);
            }
        }
    }
}

// Supporting classes
class Department {
    private List<Employee> employees = new ArrayList<>();
    
    public List<Employee> getEmployees() {
        return employees;
    }
}

class Employee {
    public String name;  // Public field for direct access
    private double salary;
    private List<Project> projects = new ArrayList<>();
    
    public double getSalary() {
        return salary;
    }
    
    public List<Project> getProjects() {
        return projects;
    }
}

class Project {
    public String name;  // Public field for direct access
    private Date deadline;
    private Client client;
    private Budget budget;
    
    public Date getDeadline() {
        return deadline;
    }
    
    public Client getClient() {
        return client;
    }
    
    public Budget getBudget() {
        return budget;
    }
}

class Client {
    public String companyName;  // Public field for direct access
    private String contactPerson;
    
    public String getContactPerson() {
        return contactPerson;
    }
}

class Budget {
    public double amount;  // Public field for direct access
    private double currentExpenses;
    
    public double getCurrentExpenses() {
        return currentExpenses;
    }
}
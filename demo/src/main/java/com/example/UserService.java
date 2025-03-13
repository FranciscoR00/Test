package com.example;

import java.sql.Date;

public class UserService {
    // Local attributes of this class
    private String serviceName;
    private int maxUsers;
    
    // Method with low LAA (poor locality of attribute access)
    public void generateUserReport(User user, Department department) {
        // Access to local attributes (from UserService class) - count: 2
        System.out.println("Report generated by: " + this.serviceName);
        int remainingCapacity = this.maxUsers - getCurrentUserCount();
        
        // Access to User attributes (foreign class) - count: 3
        String userName = user.getName();
        String userEmail = user.getEmail();
        Date userJoinDate = user.getJoinDate();
        
        // Access to Department attributes (foreign class) - count: 3
        String deptName = department.getName();
        String deptCode = department.getCode();
        Employee deptManager = department.getManager();
        
        // Access to Employee attributes (another foreign class) - count: 2
        String managerName = deptManager.getName();
        String managerTitle = deptManager.getTitle();
        
        // Report generation logic using all these attributes
        System.out.println("User Report for: " + userName + " (" + userEmail + ")");
        System.out.println("Joined on: " + userJoinDate);
        System.out.println("Department: " + deptName + " (" + deptCode + ")");
        System.out.println("Manager: " + managerName + ", " + managerTitle);
        System.out.println("Service capacity remaining: " + remainingCapacity);
    }
    
    private int getCurrentUserCount() {
        // Implementation details omitted
        return 42;
    }
}

// Supporting classes
class User {
    private String name;
    private String email;
    private Date joinDate;
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Date getJoinDate() { return joinDate; }
}

class Department {
    private String name;
    private String code;
    private Employee manager;
    
    public String getName() { return name; }
    public String getCode() { return code; }
    public Employee getManager() { return manager; }
}

class Employee {
    private String name;
    private String title;
    
    public String getName() { return name; }
    public String getTitle() { return title; }
}
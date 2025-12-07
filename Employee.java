/**
 * This defines my Employee object with characteristics.
 * Source: https://www.w3resource.com/java-exercises/encapsulation/java-encapsulation-exercise-4.php
 * 
 */

public class Employee implements Comparable<Employee> {
	// These are my attributes to help verify each employee.

	private String employeeID;
    private String firstName;
    private String lastName;
    private double salary;

    // Constructor that will initialize Employee object with given ID, name, and salary.
     
    public Employee(String employeeID, String firstName, String lastName, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // This is my comparable, which compares Employee objects to each other, which helps sorting.
     
    @Override
    public int compareTo(Employee other) {
        return this.employeeID.compareTo(other.employeeID);
    }

    
    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", employeeID, firstName, lastName, salary);
    }


    // Getter, allows you to access employeeID outside the class
     
    public String getEmployeeID() {
        return employeeID;
    }
}

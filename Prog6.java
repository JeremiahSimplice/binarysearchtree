import java.io.*;
import java.util.*;

public class Prog6 {
	// This throws an IOException since it can read from a file
    public static void main(String[] args) throws IOException {
    	// This is my BST to store the Employee objects.
        BST<Employee> tree = new BST<>();
        // This will open my employe6.txt and read each line.
        // Splits the line by commas, parts[0] employeeID, parts[1] firstName, parts[2] lastName, parts[3] salary (this gets converted to double)
        // creates an Employee object and then add it to BST.
        try (BufferedReader br = new BufferedReader(new FileReader("employee6.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Employee emp = new Employee(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                
                // if tree.add(emp) is false, it means the ID is duplicated, which prints out this message
                if (!tree.add(emp)) {
                    System.out.println("Duplicate ID not added: " + emp.getEmployeeID());
                }
            }
        }
        // This will print out the BST with its toString()
        System.out.println("Binary Search Tree:");
        System.out.println(tree);
        
        
        // This creates a prompt that the user can input numbers in, and 000 ends the loop. 
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Employee ID (000 to quit): ");
            String id = sc.nextLine();
            if (id.equals("000")) break;
            Employee temp = new Employee(id, "", "", 0);
            Employee found = tree.find(temp);
            if (found != null) {
                System.out.println("Found: " + found);
            } else {
                System.out.println("Employee ID " + id + " not found.");
            }
        }
    }
}

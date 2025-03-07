import java.util.ArrayList;
import java.util.Scanner;

public class ListAndExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>(); // Create a list to store numbers

        // Ask user to enter numbers
        System.out.println("Enter numbers (type 'done' to stop):");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break; // Stop input if user types 'done'
            }
            try {
                numbers.add(Integer.parseInt(input)); // Convert input to integer and add to list
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Your list: " + numbers); // Print the list

        // Ask user for an index to retrieve a number
        System.out.println("Enter an index to get a number:");
        try {
            int index = scanner.nextInt(); // Get index input
            System.out.println("Number at index " + index + ": " + numbers.get(index));
        } catch (Exception e) { // Catch any exception (index out of bounds or invalid input)
            System.out.println("Invalid index. Please try again.");
        }

        scanner.close(); // Close the scanner
    }
}
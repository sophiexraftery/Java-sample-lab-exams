/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;

public class SophieRafterySample10Question2LibraryManagementSystem
{
    public static void main(String[] args)
    {
        Scanner Keyboard = new Scanner(System.in);

        System.out.println("===========================================================");
        System.out.println("\tLIBRARY ITEM MANAGEMENT SYSTEM");
        System.out.println("===========================================================");

        // Initial total
        System.out.println("Initial total library items: " + LibraryItem.getTotalItems());

        System.out.println("\n--- Adding Items ---");

        System.out.println("Creating Book...");
        Book book1 = new Book("Java Programming", "B001", "John Smith", 450);

        System.out.println("Creating Magazine...");
        Magazine mag1 = new Magazine("Tech Today", "M001", 42);

        System.out.println("\n--- Items Details ---");

        book1.displayItemDetails();
        mag1.displayItemDetails();

        // Final total
        System.out.println("\nFinal total library items: " + LibraryItem.getTotalItems());

        Keyboard.close();
    }
}
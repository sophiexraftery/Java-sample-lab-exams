/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;

public class SophieRafterySample9Question1CoffeeOrdering
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("COFFEE SHOP ORDER");
        System.out.println("=======================");

        // Step 1: Ask how many items (1-5)
        int numItems;
        do
        {
            System.out.print("How many items would you like to order (1-5): ");
            numItems = keyboard.nextInt();
        } while (numItems < 1 || numItems > 5);

        // Array to store the chosen item numbers
        int[] orderItems = new int[numItems];

        // Step 2: Take the order
        for (int i = 0; i < numItems; i++)
        {
            System.out.printf("\n--- Item %d of %d ---\n\n", i + 1, numItems);
            displayMenu();
            orderItems[i] = readValidItemChoice(keyboard);
        }

        // Step 3: Print the receipt
        System.out.println("\n------------------------------");
        System.out.println("RECEIPT");
        System.out.println("-------------------------------");

        double total = 0;
        for (int i = 0; i < numItems; i++)
        {
            String itemName = getItemName(orderItems[i]);
            double price = getPrice(orderItems[i]);
            System.out.printf("%-12s %.2f%n", itemName, price);
            total += price;
        }

        System.out.println("------------------------------");
        System.out.printf("Items ordered: %d%n", numItems);
        System.out.printf("TOTAL: %.2f%n", total);
        System.out.println("============================");

        // Close the scanner after main is done
        keyboard.close();
    }

    // ================= METHOD: GET PRICE =================
    static double getPrice(int itemNumber)
    {
        switch (itemNumber)
        {
            case 1: return 3.50; // Americano
            case 2: return 4.25; // Latte
            case 3: return 4.25; // Cappuccino
            case 4: return 3.75; // Hot Chocolate
            case 5: return 2.80; // Tea
            default: return 0;    // Should not happen
        }
    }

    // ================= METHOD: GET ITEM NAME =================
    static String getItemName(int itemNumber)
    {
        switch (itemNumber)
        {
            case 1: return "Americano";
            case 2: return "Latte";
            case 3: return "Cappuccino";
            case 4: return "Hot Chocolate";
            case 5: return "Tea";
            default: return "Unknown";
        }
    }

    // ================= METHOD: DISPLAY MENU =================
    static void displayMenu()
    {
        System.out.println("1. Americano - 3.50");
        System.out.println("2. Latte - 4.25");
        System.out.println("3. Cappuccino - 4.25");
        System.out.println("4. Hot Chocolate - 3.75");
        System.out.println("5. Tea - 2.80\n");
    }

    // ================= METHOD: READ VALID ITEM CHOICE =================
    static int readValidItemChoice(Scanner keyboard)
    {
        int choice;
        do
        {
            System.out.print("Choose an item (1-5): ");
            choice = keyboard.nextInt();
            if (choice < 1 || choice > 5)
            {
                System.out.println("\nInvalid choice. Please enter 1-5.\n");
            }
        } while (choice < 1 || choice > 5);
        return choice;
    }
}
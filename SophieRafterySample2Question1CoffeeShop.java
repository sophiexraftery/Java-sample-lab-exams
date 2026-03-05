/*
Name: Sophie Raftery
Student ID: g00477839
Date: 12/11/2025
*/

import java.util.Scanner;
public class SophieRafterySample2Question1CoffeeShop
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        char anotherOrder;

        // Prices for items
        double espresso = 3.50;
        double cappuccino = 4.75;
        double latte = 5.25;
        double croissant = 3.25;
        double muffin = 4.00;
        double cookie = 2.75;

        do
        {
            System.out.println("========================================");
            System.out.println("           BREW HAVEN COFFEE SHOP");
            System.out.println();
            System.out.println("MENU:");
            System.out.println("1. Espresso              3.50");
            System.out.println("2. Cappuccino            4.75");
            System.out.println("3. Latte                 5.25");
            System.out.println("4. Croissant             3.25");
            System.out.println("5. Blueberry Muffin      4.00");
            System.out.println("6. Chocolate Chip Cookie 2.75");
            System.out.println();

            // Ask how many items
            System.out.print("How many different items would you like to order (1-6)? ");
            int numItems = keyboard.nextInt();

            // Validate number of items
            while (numItems < 1 || numItems > 6)
            {
                System.out.print("Invalid! Please enter a number between 1 and 6: ");
                numItems = keyboard.nextInt();
            }

            double subtotal = 0;

            for (int i = 1; i <= numItems; i++)
            {
                System.out.print("\nSelect item #" + i + " (1-6): ");
                int itemChoice = keyboard.nextInt();

                while (itemChoice < 1 || itemChoice > 6)
                {
                    System.out.print("Invalid choice! Enter a number between 1 and 6: ");
                    itemChoice = keyboard.nextInt();
                }

                // Ask for quantity
                System.out.print("Quantity (1-5): ");
                int quantity = keyboard.nextInt();

                while (quantity < 1 || quantity > 5)
                {
                    System.out.print("Invalid quantity! Enter between 1 and 5: ");
                    quantity = keyboard.nextInt();
                }

                String itemName = "";
                double itemPrice = 0;
                double itemTotal = 0;

                // Select item based on menu choice
                switch (itemChoice)
                {
                    case 1:
                        itemName = "Espresso";
                        itemPrice = espresso;
                        break;
                    case 2:
                        itemName = "Cappuccino";
                        itemPrice = cappuccino;
                        break;
                    case 3:
                        itemName = "Latte";
                        itemPrice = latte;
                        break;
                    case 4:
                        itemName = "Croissant";
                        itemPrice = croissant;
                        break;
                    case 5:
                        itemName = "Blueberry Muffin";
                        itemPrice = muffin;
                        break;
                    case 6:
                        itemName = "Chocolate Chip Cookie";
                        itemPrice = cookie;
                        break;
                }

                // Calculate subtotal for this item
                itemTotal = itemPrice * quantity;
                subtotal += itemTotal;

                System.out.printf("Added: %d x %s = %.2f%n", quantity, itemName, itemTotal);
            }

            // Calculate tax and discount
            double tax = subtotal * 0.08;
            double discount = 0;

            if (subtotal > 25)
            {
                discount = subtotal * 0.05;
            }

            double finalTotal = subtotal + tax - discount;

            // Display order summary
            System.out.println("\n========================================");
            System.out.println("             ORDER SUMMARY");
            System.out.println("========================================");
            System.out.printf("Subtotal:         %.2f%n", subtotal);
            System.out.printf("Tax (8%%):          %.2f%n", tax);
            System.out.printf("Loyalty Discount: %.2f%n", discount);
            System.out.printf("Final Total:      %.2f%n", finalTotal);
            System.out.println("========================================");

            // Ask user if they want to order again
            System.out.print("\nWould you like to place another order? (Y/N): ");
            anotherOrder = keyboard.next().charAt(0);

        }
        while (Character.toUpperCase(anotherOrder) == 'Y');

        System.out.println("\nThank you for visiting our coffee shop!");
        keyboard.close();
    }
}

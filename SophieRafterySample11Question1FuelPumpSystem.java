/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class SophieRafterySample11Question1FuelPumpSystem
{
    public static void main(String[] args)
    {
        Scanner Keyboard = new Scanner(System.in);
        boolean validInput = false;
        final double PRICE_PER_LITRE = 1.85;

        System.out.println("=========================================");
        System.out.println("\tFUEL PUMP SYSTEM");
        System.out.println("=========================================");

        // Loop until valid input
        while (!validInput)
        {
            try
            {
                System.out.print("Enter litres to purchase: ");

                double litres = Keyboard.nextDouble();

                // Validate range
                if (litres < 1 || litres > 100)
                {
                    throw new InvalidFuelAmountException(
                        "Invalid amount! You must purchase between 1 and 100 litres."
                    );
                }

                // Calculate cost
                double totalCost = litres * PRICE_PER_LITRE;

                // Display results (formatted)
                System.out.printf("Fuel dispensed: %.2f litres\n", litres);
                System.out.printf("Total cost: EUR %.2f\n", totalCost);
                System.out.println("Thank you for your purchase!");

                validInput = true;
            }
            catch (InvalidFuelAmountException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Please enter a valid number.");
                Keyboard.next(); // clear invalid input
            }
        }

        System.out.println("=========================================");
        Keyboard.close();
    }
}
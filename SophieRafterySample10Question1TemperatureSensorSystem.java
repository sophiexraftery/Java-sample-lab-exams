/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class SophieRafterySample10Question1TemperatureSensorSystem
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("=======================================");
        System.out.println("\tTEMPERATURE SENSOR SYSTEM");
        System.out.println("=======================================");

        // Loop until valid input is entered
        while (!validInput)
        {
            try
            {
                System.out.print("Enter a temperature reading (Celcius): ");

                double temperature = keyboard.nextDouble();

                // Check if temperature is within valid range
                if (temperature < -50 || temperature > 50)
                {
                    throw new InvalidTemperatureException(
                        "Warning: Extreme temperature detected! Valid range is -50 to +50."
                    );
                }

                // Valid temperature entered
                System.out.println("Temperature " + temperature + " recorded successfully. System shutting down.");
                validInput = true;
            }
            catch (InvalidTemperatureException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Please enter a valid number.");
                keyboard.next(); // Clear invalid input
            }
        }

        System.out.println("=======================================");
        keyboard.close();
    }
}
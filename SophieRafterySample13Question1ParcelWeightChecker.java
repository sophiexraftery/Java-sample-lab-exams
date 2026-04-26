/*
Name: Sophie Raftery
Student ID: g00477839
Date: 26/5/2026
27 minutes
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class SophieRafterySample13Question1ParcelWeightChecker
{
      public static void main(String[] args)
	   {
	        Scanner keyboard = new Scanner(System.in);
	        double weight = 0.0;
	        boolean validInput = false;

	        System.out.println("====================================================");
	        System.out.println("\tPARCEL DELIVERY WEIGHT CHECKER");
	        System.out.println("====================================================");

	        // Loop until valid input is entered
	        while(!validInput)
	        {
	            try
	            {
	                System.out.print("Enter parcel weight (kg): ");
	                weight = keyboard.nextDouble();

	                // Validate weight
	                validateWeight(weight);

	                // If no exception → valid input
	                double cost = weight * 1.50;

	                System.out.printf("Parcel weight: %.2f kg\n", weight);
	                System.out.printf("Shipping cost: EUR %.2f\n", cost);
	                System.out.println("Parcel accepted for delivery!");
	                System.out.println("=====================================================");

	                validInput = true; // exit loop
	            }
	            catch(InvalidWeightException e)
	            {
	                // Custom exception
	                System.out.println(e.getMessage());
	                System.out.println();
	            }
	            catch(InputMismatchException e)
	            {
	                // Handles letters like "abc"
	                System.out.println("Error: Please enter a valid number.");
	                keyboard.nextLine(); // CLEAR BUFFER
	                System.out.println();
	            }
	        }

	        keyboard.close();
	    }

	public static void validateWeight(double weight) throws InvalidWeightException
	{
		if(weight < 0.1 || weight > 30.0)
		{
			throw new InvalidWeightException("Error: Parcel weight must be between 0.1kg and 30.0kg");
		}
	}
}
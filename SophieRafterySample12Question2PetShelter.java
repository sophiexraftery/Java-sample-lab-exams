/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;

public class SophieRafterySample12Question2PetShelter
{
    public static void main(String[] args)
    {
        Scanner Keyboard = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println("\tPET SHELTER REGISTRATION SYSTEM");
        System.out.println("=====================================================");

        // Display initial total pets
        System.out.println("Initial total pets registered: " + Pet.getTotalPets());

        System.out.println("\n--- Registering Pets ---");

        // Create Dog object
        System.out.println("Registering Dog...");
        Dog dog1 = new Dog("Buddy", "D001", "Labrador", true);

        // Create Cat object
        System.out.println("Registering Cat...");
        Cat cat1 = new Cat("Whiskers", "C001", true);

        System.out.println("\n--- Pet Details ---");

        // Display details
        dog1.displayPetDetails();
        cat1.displayPetDetails();

        // Display final total pets
        System.out.println("\nFinal total pets registered: " + Pet.getTotalPets());

        System.out.println("=====================================================");

        Keyboard.close();
    }
}
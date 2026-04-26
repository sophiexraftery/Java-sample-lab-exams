/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;

public class SophieRafterySample11Question2VehicleFleetSystem
{
    public static void main(String[] args)
    {
        Scanner Keyboard = new Scanner(System.in);

        System.out.println("=======================================================");
        System.out.println("\tVEHICLE FLEET MANAGEMENT SYSTEM");
        System.out.println("=======================================================");

        // Initial total
        System.out.println("Initial total vehicles registered: " + Vehicle.getTotalVehicles());

        System.out.println("\n--- Registering Vehicles ---");

        System.out.println("Registering Car...");
        Car car1 = new Car("Toyota", "191-G-1234", 4, "Petrol");

        System.out.println("Registering Motorcycle...");
        Motorcycle bike1 = new Motorcycle("Yamaha", "221-D-5678", 600);

        System.out.println("\n--- Vehicle Details ---");

        car1.displayVehicleDetails();
        bike1.displayVehicleDetails();

        // Final total
        System.out.println("\nFinal total vehicles registered: " + Vehicle.getTotalVehicles());

        System.out.println("========================================");

        Keyboard.close();
    }
}
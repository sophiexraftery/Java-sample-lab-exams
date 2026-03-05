/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
public class SophieRafterySample7Question2CarRental
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

		System.out.println("==========================================================");
        System.out.println("\t\tCAR RENTAL SYSTEM");
        System.out.println("==========================================================");

        // ================= 1. INITIALISE SAMPLE RENTAL =================
        System.out.println("Creating sample rental (Rental1)...");
        Rental rental1 = new Rental("R201", "Liam",
                "SUV", 3, 65.00);
        System.out.println("Done.");

        // ================= 2. CREATE USER RENTAL =================
        System.out.println("\n--- ADD USER RENTAL (Rental 2) ---");

        System.out.print("Enter Rental ID: ");
        String id = keyboard.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter Car Type: ");
        String type = keyboard.nextLine();

        int days;
        do
        {
            System.out.print("Enter Days: ");
            days = keyboard.nextInt();
        }
        while(days <= 0);

        double rate;
        do
        {
            System.out.print("Enter Daily Rate: ");
            rate = keyboard.nextDouble();
        }
        while(rate <= 0);

        Rental rental2 = new Rental(id, name, type, days, rate);

        // ================= 3. DISPLAY AND COMPARE =================
        System.out.println("\n--- DISPLAYING ALL RENTALS ---");
        rental1.displayRental();
        rental2.displayRental();

        System.out.println("\n--- COMPARISON ---");

        double total1 = rental1.calculateTotalCost();
        double total2 = rental2.calculateTotalCost();

        if(total1 > total2)
        {
            System.out.printf("The most expensive rental is for %s (%.2f)%n",
                    rental1.getCustomerName(), total1);
        }
        else
        {
            System.out.printf("The most expensive rental is for %s (%.2f)%n",
                    rental2.getCustomerName(), total2);
        }

        // ================= 4. SUMMARY =================
        System.out.println("\n--- SUMMARY ---");

        double totalRevenue = total1 + total2;
        System.out.printf("Total Revenue for all rentals: %.2f%n",
                totalRevenue);

        String searchName = "Liam";
        System.out.print("Search for 'Liam': ");

        if(rental1.matchesCustomerName(searchName))
        {
            System.out.println("Found in Rental 1.");
        }
        else if(rental2.matchesCustomerName(searchName))
        {
            System.out.println("Found in Rental 2.");
        }
        else
        {
            System.out.println("Not found.");
        }

        System.out.println("\nGoodbye!");
        System.out.println("=====================================================");

        keyboard.close();
    }
}
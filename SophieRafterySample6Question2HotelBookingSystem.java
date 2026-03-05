/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
public class SophieRafterySample6Question2HotelBookingSystem
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

		System.out.println("========================================================");
        System.out.println("\tHOTEL BOOKING SYSTEM");
        System.out.println("========================================================");

        // ================== 1. CREATE SAMPLE BOOKING ==================
        System.out.println("Creating sample booking (Booking1)...");
        Booking booking1 = new Booking("B101", "Alice",
                "Double", 3, 120.00);
        System.out.println("Done.");

        // ================== 2. USER BOOKING ==================
        System.out.println("\n--- ADD USER BOOKING (Booking 2) ---");

        System.out.print("Enter Booking ID: ");
        String id = keyboard.nextLine();

        System.out.print("Enter Guest Name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter Room Type: ");
        String type = keyboard.nextLine();

        int nights;
        do
        {
            System.out.print("Enter Nights: ");
            nights = keyboard.nextInt();
        }
        while(nights <= 0);

        double rate;
        do
        {
            System.out.print("Enter Nightly Rate: ");
            rate = keyboard.nextDouble();
        }
        while(rate <= 0);

        Booking booking2 = new Booking(id, name, type, nights, rate);

        // ================== 3. DISPLAY BOOKINGS ==================
        System.out.println("\n--- DISPLAYING ALL BOOKINGS ---");
        booking1.displayBooking();
        booking2.displayBooking();

        // ================== COMPARISON ==================
        System.out.println("\n--- COMPARISON ---");

        double total1 = booking1.calculateTotalCost();
        double total2 = booking2.calculateTotalCost();

        if(total1 > total2)
        {
            System.out.printf("The most expensive booking is for %s (%.2f)%n",
                    booking1.getGuestName(), total1);
        }
        else
        {
            System.out.printf("The most expensive booking is for %s (%.2f)%n",
                    booking2.getGuestName(), total2);
        }

        // ================== 4. SUMMARY ==================
        System.out.println("\n--- SUMMARY ---");

        double totalRevenue = total1 + total2;
        System.out.printf("Total Revenue for all bookings: %.2f%n",
                totalRevenue);

        String searchName = "Alice";
        System.out.println("Search for: " + searchName);

        if(booking1.matchesGuestName(searchName))
        {
            System.out.println("Alice found in Booking 1.");
        }
        else if(booking2.matchesGuestName(searchName))
        {
            System.out.println("Alice found in Booking 2.");
        }
        else
        {
            System.out.println("Guest not found.");
        }

        System.out.println("\nGoodbye!");
        System.out.println("========================================================");

    }
}
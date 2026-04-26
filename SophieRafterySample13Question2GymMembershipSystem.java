/*
Name: Sophie Raftery
Student ID: g00477839
Date: 26/5/2026
68 minutes
*/
import java.util.Scanner;

public class SophieRafterySample13Question2GymMembershipSystem
{
    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("=============================================================");
        System.out.println("\tGYM MEMBERSHIP SYSTEM");
        System.out.println("=============================================================");

        // Initial totals
        System.out.println("Initial total members: " + GymMember.getTotalMembers());
        System.out.printf("Initial monthly income: EUR %.2f\n\n", GymMember.getTotalIncome());

        System.out.println("--- Registering Members ---");
        System.out.println("Registering Premium Member...");
        PremiumMember pm = new PremiumMember("Sarah Connor", "PM001", 59.99, "Mike Ross");

        System.out.println("Registering Standard Member...");
        StandardMember sm1 = new StandardMember("John Reese", "SM001", 29.99, false);

        System.out.println("Registering Standard Member...");
        StandardMember sm2 = new StandardMember("Jane Shaw", "SM002", 39.99, true);

        System.out.println("\n--- Member Details ---");

        pm.displayMemberDetails();
        System.out.println("------------------------------------");

        sm1.displayMemberDetails();
        System.out.println("------------------------------------");

        sm2.displayMemberDetails();
        System.out.println("------------------------------------");

        // Final totals
        System.out.println("\nFinal total members: " + GymMember.getTotalMembers());
        System.out.printf("Final monthly income: EUR %.2f\n", GymMember.getTotalIncome());

        System.out.println("=========================================================");

        keyboard.close();
    }
}

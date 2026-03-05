/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
public class SophieRafterySample8Question2EventTicket
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

		System.out.println("=================================");
        System.out.println("\tEVENT TICKET ORDER SYSTEM");
        System.out.println("=================================");

        // ================= 1. INITIALISE SAMPLE ORDER =================
        System.out.println("Creating sample order (Order 1)...");
        TicketOrder order1 = new TicketOrder("0501", "Noah", "Jazz Night", 2, 35.00);
        System.out.println("Done.");

        // ================= 2. USER ORDER =================
        System.out.println("\n--- ADD USER ORDER (Order 2) ---");

        System.out.print("Enter Order ID: ");
        String orderId = keyboard.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = keyboard.nextLine();

        System.out.print("Enter Event Name: ");
        String eventName = keyboard.nextLine();

        int tickets;
        do
        {
            System.out.print("Enter Number of Tickets: ");
            tickets = keyboard.nextInt();
        } while (tickets <= 0);

        double price;
        do
        {
            System.out.print("Enter Price Per Ticket: ");
            price = keyboard.nextDouble();
        } while (price <= 0);

        TicketOrder order2 = new TicketOrder(orderId, customerName, eventName, tickets, price);

        // ================= 3. DISPLAY AND COMPARE =================
        System.out.println("\n--- DISPLAYING ALL ORDERS ---");
        order1.displayOrder();
        order2.displayOrder();

        System.out.println("\n--- COMPARISON ---");
        double total1 = order1.calculateTotalCost();
        double total2 = order2.calculateTotalCost();

        if (total1 > total2)
        {
            System.out.printf("The largest order is for %s (%.2f)%n",
                    order1.getCustomerName(), total1);
        }
        else
        {
            System.out.printf("The largest order is for %s (%.2f)%n",
                    order2.getCustomerName(), total2);
        }

        // ================= 4. SUMMARY =================
        double totalRevenue = total1 + total2;
        System.out.printf("\n--- SUMMARY ---\n");
        System.out.printf("Total Revenue for all orders: %.2f%n", totalRevenue);

        String searchEvent = "Jazz Night";
        System.out.print("Search for '" + searchEvent + "': ");
        if (order1.matchesEventName(searchEvent))
        {
            System.out.println("Found in order 1.");
        }
        else if (order2.matchesEventName(searchEvent))
        {
            System.out.println("Found in order 2.");
        }
        else
        {
            System.out.println("Not found.");
        }

        System.out.println("\nGoodbye!");
        System.out.println("====================================");

        keyboard.close();
    }
}
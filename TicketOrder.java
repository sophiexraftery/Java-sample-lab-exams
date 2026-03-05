class TicketOrder
{
    // ========== PRIVATE FIELDS ==========
    private String orderId;
    private String customerName;
    private String eventName;
    private int tickets;
    private double pricePerTicket;

    // ========== DEFAULT CONSTRUCTOR ==========
    public TicketOrder()
    {
        orderId = "0000";
        customerName = "Unknown";
        eventName = "Unknown Event";
        tickets = 1;
        pricePerTicket = 10.00;
    }

    // ========== PARAMETERISED CONSTRUCTOR ==========
    public TicketOrder(String orderId, String customerName,
                       String eventName, int tickets, double pricePerTicket)
    {
        this.orderId = orderId;
        this.customerName = customerName;
        this.eventName = eventName;
        this.tickets = tickets;
        this.pricePerTicket = pricePerTicket;
    }

    // ========== INSTANCE METHODS ==========

    // Calculate total cost
    public double calculateTotalCost()
    {
        return tickets * pricePerTicket;
    }

    // Case-insensitive match of event name
    public boolean matchesEventName(String search)
    {
        return eventName.equalsIgnoreCase(search);
    }

    // Display formatted order details
    public void displayOrder()
    {
        System.out.printf("ID: %s | Customer: %s | Event: %s | Tickets: %d | Price: %.2f | Total: %.2f%n",
                orderId, customerName, eventName, tickets, pricePerTicket, calculateTotalCost());
    }

    // Getter for customer name (used in comparison)
    public String getCustomerName()
    {
        return customerName;
    }
}
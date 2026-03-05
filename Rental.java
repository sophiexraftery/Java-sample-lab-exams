class Rental
{
    // ================= PRIVATE FIELDS =================
    private String rentalId;
    private String customerName;
    private String carType;
    private int days;
    private double dailyRate;

    // ================= DEFAULT CONSTRUCTOR =================
    public Rental()
    {
        rentalId = "R000";
        customerName = "Unknown";
        carType = "Standard";
        days = 1;
        dailyRate = 50.00;
    }

    // ================= PARAMETERISED CONSTRUCTOR =================
    public Rental(String rentalId, String customerName,
                  String carType, int days, double dailyRate)
    {
        this.rentalId = rentalId;
        this.customerName = customerName;
        this.carType = carType;
        this.days = days;
        this.dailyRate = dailyRate;
    }

    // ================= INSTANCE METHODS =================

    // Calculate total rental cost
    public double calculateTotalCost()
    {
        return days * dailyRate;
    }

    // Case-insensitive name match
    public boolean matchesCustomerName(String search)
    {
        return customerName.equalsIgnoreCase(search);
    }

    // Display formatted rental details
    public void displayRental()
    {
        System.out.printf(
            "ID: %s | Customer: %s | Type: %s | Days: %d | Rate: %.2f | Total: %.2f%n",
            rentalId, customerName, carType, days, dailyRate, calculateTotalCost());
    }

    // Getter for comparison section
    public String getCustomerName()
    {
        return customerName;
    }
}
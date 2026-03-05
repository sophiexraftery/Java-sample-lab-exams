class Booking
{
    // ================== PRIVATE FIELDS ==================
    private String bookingId;
    private String guestName;
    private String roomType;
    private int nights;
    private double nightlyRate;

    // ================== DEFAULT CONSTRUCTOR ==================
    public Booking()
    {
        bookingId = "B000";
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
        nightlyRate = 100.00;
    }

    // ================== PARAMETERISED CONSTRUCTOR ==================
    public Booking(String bookingId, String guestName, String roomType,
                   int nights, double nightlyRate)
    {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
        this.nightlyRate = nightlyRate;
    }

    // ================== INSTANCE METHODS ==================

    // Calculate total booking cost
    public double calculateTotalCost()
    {
        return nights * nightlyRate;
    }

    // Case-insensitive name match
    public boolean matchesGuestName(String search)
    {
        return guestName.equalsIgnoreCase(search);
    }

    // Display formatted booking details
    public void displayBooking()
    {
        System.out.printf("ID: %s | Guest: %s | Type: %s | Nights: %d | Rate: %.2f | Total: %.2f%n",
                bookingId, guestName, roomType, nights, nightlyRate, calculateTotalCost());
    }

    // Getter for guest name (used in comparison section)
    public String getGuestName()
    {
        return guestName;
    }
}
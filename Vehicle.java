public class Vehicle
{
    private String make;
    private String registrationNumber;

    private static int totalVehiclesRegistered = 0;

    // Constructor
    public Vehicle(String make, String registrationNumber)
    {
        this.make = make;
        this.registrationNumber = registrationNumber;
        totalVehiclesRegistered++;
    }

    // Getters
    public String getMake()
    {
        return make;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    // Display method
    public void displayVehicleDetails()
    {
        System.out.println("Make: " + make + " | Reg: " + registrationNumber);
    }

    // Static method
    public static int getTotalVehicles()
    {
        return totalVehiclesRegistered;
    }
}
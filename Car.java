public class Car extends Vehicle
{
    private int numDoors;
    private String fuelType;

    public Car(String make, String registrationNumber, int numDoors, String fuelType)
    {
        super(make, registrationNumber);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    @Override
    public void displayVehicleDetails()
    {
        super.displayVehicleDetails();
        System.out.println("Doors: " + numDoors + " | Fuel Type: " + fuelType);
        System.out.println("-----------------------------");
    }
}
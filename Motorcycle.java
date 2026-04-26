public class Motorcycle extends Vehicle
{
    private int engineSize;

    public Motorcycle(String make, String registrationNumber, int engineSize)
    {
        super(make, registrationNumber);
        this.engineSize = engineSize;
    }

    @Override
    public void displayVehicleDetails()
    {
        super.displayVehicleDetails();
        System.out.println("Engine Size: " + engineSize + "cc");
        System.out.println("------------------------------");
    }
}
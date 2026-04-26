// Base class representing a generic Pet
public class Pet
{
    // Protected fields accessible to subclasses
    protected String name;
    protected String petId;

    // Static variable to track total pets registered
    private static int totalPetsRegistered = 0;

    // Parameterised constructor
    public Pet(String name, String petId)
    {
        this.name = name;
        this.petId = petId;

        // Increment total pets whenever a new object is created
        totalPetsRegistered++;
    }

    // Method to display basic pet details
    public void displayPetDetails()
    {
        System.out.println("Pet ID: " + petId + " | Name: " + name);
    }

    // Static method to return total pets registered
    public static int getTotalPets()
    {
        return totalPetsRegistered;
    }
}
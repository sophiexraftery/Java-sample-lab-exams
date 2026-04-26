// Cat class inherits from Pet
public class Cat extends Pet
{
    // Cat-specific field
    private boolean isIndoor;

    // Constructor
    public Cat(String name, String petId, boolean isIndoor)
    {
        super(name, petId);
        this.isIndoor = isIndoor;
    }

    // Override method to include cat-specific details
    @Override
    public void displayPetDetails()
    {
        super.displayPetDetails();

        System.out.println("Indoor Pet: " + (isIndoor ? "Yes" : "No"));

        System.out.println("----------------------------------------");
    }
}
// Dog class inherits from Pet
public class Dog extends Pet
{
    // Dog-specific fields
    private String breed;
    private boolean isVaccinated;

    // Constructor
    public Dog(String name, String petId, String breed, boolean isVaccinated)
    {
        super(name, petId);
        this.breed = breed;
        this.isVaccinated = isVaccinated;
    }

    // Override method to include dog-specific details
    @Override
    public void displayPetDetails()
    {
        super.displayPetDetails();

        System.out.println("Breed: " + breed +
                           " | Vaccinated: " + (isVaccinated ? "Yes" : "No"));

        System.out.println("-------------------------------------");
    }
}
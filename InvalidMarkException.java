// Custom exception class for invalid exam marks
public class InvalidMarkException extends Exception
{
    // Constructor that accepts a custom error message
    public InvalidMarkException(String message)
    {
        super(message);
    }
}
public class BankAccount
{
    private String accountHolder;
    private double balance;
    private String lastMessage;

    // Default constructor
    public BankAccount()
    {
        accountHolder = "Unknown";
        balance = 0;
        lastMessage = "Account created.";
    }

    // Parameterized constructor (double)
    public BankAccount(String accountHolder, double startBalance)
    {
        this.accountHolder = accountHolder;
        this.balance = startBalance;
        this.lastMessage = "Account created with balance " + startBalance;
    }

    // Overloaded constructor (int)
    public BankAccount(String accountHolder, int startBalance)
    {
        this.accountHolder = accountHolder;
        this.balance = startBalance;
        this.lastMessage = "Account created with balance " + startBalance;
    }

    // Get balance
    public double getBalance()
    {
        return balance;
    }

    // Deposit (double)
    public boolean deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            lastMessage = "Deposit successful.";
            return true;
        }
        else
        {
            lastMessage = "Deposit failed: amount must be > 0.";
            return false;
        }
    }

    // Deposit (int)
    public boolean deposit(int amount)
    {
        return deposit((double) amount);
    }

    // Withdraw (double)
    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            lastMessage = "Withdrawal successful.";
            return true;
        }
        else
        {
            lastMessage = "Withdrawal failed: insufficient funds.";
            return false;
        }
    }

    // Withdraw (int)
    public boolean withdraw(int amount)
    {
        return withdraw((double) amount);
    }

    // Get last transaction message
    public String getLastMessage()
    {
        return lastMessage;
    }
}
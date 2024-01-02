public class BankAccount {

    private double balance;
    private String name;

    BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void deposit(double amount) throws IllegalArgumentException{
        if(amount < 0 || amount == 0){
            throw new IllegalArgumentException("amount is less than or equal to zero");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) throws IllegalArgumentException, InsufficientBalanceException{
        if(amount < 0 || amount == 0){
            throw new IllegalArgumentException("amount is less than or equal to zero");
        } else if (balance < amount) {
            throw new InsufficientBalanceException("amount is more than the balance");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

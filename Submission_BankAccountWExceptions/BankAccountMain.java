import java.util.Scanner;

public class BankAccountMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean action = true;
        System.out.println("What is your name? ");
        BankAccount bankAcc = new BankAccount(0, input.nextLine());
        do {
            System.out.println("Action(withdraw/deposit/getBalance/exit)? ");
            switch (input.nextLine()) {
                case "withdraw":
                    System.out.println("Amount? ");
                    try {
                        bankAcc.withdraw(Double.parseDouble(input.nextLine()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("amount is less than or equal to 0. Try again.");
                    } catch (InsufficientBalanceException e) {
                        System.out.println("amount is more than the balance. Try again.");
                    }
                    break;

                case "deposit":
                    System.out.println("Amount? ");
                    try {
                        bankAcc.deposit(Double.parseDouble(input.nextLine()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("amount is less than or equal to 0. Try again.");
                    }
                    break;

                case "getBalance":
                    System.out.println(bankAcc.getBalance());
                    break;

                case "exit":
                    action = false;
                    break;

                default:
                    System.out.println("Invalid action. Try again.");
                    break;

            }
        } while (action);
        System.out.println("Thank you for choosing Bank of Subhash");
        input.close();
    }
}

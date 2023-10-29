/*
 * @author Subhash Muthu
 * test for the BankAccount class.
 */

package Submission_SimpleBankAccount;

public class BankAccountTest {
    
    public static void main(String[] args){
    

        //Account declaration and initializations

        BankAccount pManningsAcc = new BankAccount("Peyton Mannings", 10);
        BankAccount jCansecoAcc = new BankAccount("Jose Canseco", 21, 300.0);


        //Getters tests.

        //pManningsAcc Getters test
        
        System.out.println("pManningsAcc' Account Number: " + pManningsAcc.getAccountNum());
        System.out.println("pManningsAcc' Balance: " + pManningsAcc.getBalance());
        System.out.println("pManningsAcc' Name: " + pManningsAcc.getName());
        
        //jCansecoAcc Getters test
        
        System.out.println("jCansecoAcc' Account Number: " + jCansecoAcc.getAccountNum());
        System.out.println("jCansecoAcc' Balance: " + jCansecoAcc.getBalance());
        System.out.println("jCansecoAcc' Name: " + jCansecoAcc.getName());
    

        //Withdraws and deposits 1 dollar from each account thrice.
        
        multiWithdraw(pManningsAcc,3,1);
        multiWithdraw(jCansecoAcc, 3, 1);
        
        multiDeposit(pManningsAcc, 3, 1);
        multiDeposit(jCansecoAcc, 3, 1);


        //toString test.

        System.out.println(pManningsAcc);
        System.out.println(jCansecoAcc);


    }

    public static void multiWithdraw(BankAccount placeholderAcc, int numWithdraws, double withdrawMoney){
        
        for (int i = 0; i < numWithdraws; i++) {
            placeholderAcc.withdraw(withdrawMoney);
        }

        System.out.println(placeholderAcc.getBalance());

    }

    public static void multiDeposit(BankAccount placeholderAcc, int numDeposits, double depositMoney){
        
        for (int i = 0; i < numDeposits; i++) {
            placeholderAcc.deposit(depositMoney);
        }

    }

}

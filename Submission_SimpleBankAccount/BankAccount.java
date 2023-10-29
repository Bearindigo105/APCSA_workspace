/*
 * @author Subhash Muthu
 */

package Submission_SimpleBankAccount;

 public class BankAccount {

    private String _name;
    private double _balance;
    private int _accountNumber;
  
    public BankAccount(String name, int accountNumber) {
      this._name = name;
      this._accountNumber = accountNumber;
    }
  
    public BankAccount(String name, int accountNumber, double balance) {
      this._name = name;
      this._accountNumber = accountNumber;
      this._balance = balance;
    }
  
    public void deposit(double depositMoney) {
      this._balance += depositMoney;
    }
  
    public void withdraw(double withdrawMoney) {
      this._balance -= withdrawMoney;
    }
  
    public double getBalance() {
      return _balance;
    }
  
    public int getAccountNum() {
      return _accountNumber;
    }
  
    public String getName() {
      return _name;
    }
  
    @Override
    public String toString() {
      return "name: " + _name + "\naccountNumber: " + _accountNumber + "\nbalance: " + _balance;
    }
  
  }
  
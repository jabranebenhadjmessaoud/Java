public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    public BankAccount (Double checkingBalance,Double savingsBalance) {
        this.checkingBalance=checkingBalance ;
        this.savingsBalance=savingsBalance ;
        this.totalMoney=this.savingsBalance+this.checkingBalance ;
        accounts++ ;
    } ;
    // Be sure to increment the number of accounts

    // GETTERS

    public Double getcheckingBalance(){
        return this.checkingBalance;
     }
    public void setcheckingBalance(Double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }


    public Double getsavingsBalance(){
        return this.savingsBalance;
     }
    public void setsavingsBalance(Double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // for checking, savings, accounts, and totalMoney


    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void deposit(Double amount ){
        this.totalMoney+=amount ;
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    public void withdraw (Double amount){
        if (this.totalMoney>=amount) {
            this.totalMoney-=amount;
            System.out.println("Operation Done");
        }
        else {
            System.out.println("insufficient funds ");
        }
    }
    // - all deposits and withdrawals should affect totalMoney
    // getBalance
    public Double getBalance(){
        return this.totalMoney ;
    }
    // - display total balance for checking and savings of a particular bank account
}

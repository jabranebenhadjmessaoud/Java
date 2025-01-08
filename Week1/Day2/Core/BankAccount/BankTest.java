public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount b1= new BankAccount(522.00, 900.0) ;
        BankAccount b2= new BankAccount(75.00, 2000.0) ;
        BankAccount b3= new BankAccount(100.00, 1000.0) ;
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println(b1.getBalance());
        b1.deposit(100.0);
        System.out.println(b1.getBalance());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance

        // - each withdrawal should decrease the amount of totalMoney
        b1.withdraw(500.0);
        System.out.println(b1.getBalance());
        // Static Test (print the number of bank accounts and the totalMoney)

    }
}

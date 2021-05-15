import java.util.Random;

public class BankAccount{
    private String accountNumber;
    private double checkingAccount;
    private double savingsAccount;
    public static int numberOfAccounts = 0;
    public static double totalAmount = 0;
    
    private static String ReturnsRandomNumbers(){
        String num = "";
        Random r = new Random();
        for(int i=0; i<=10;i++);{
            num += r.nextInt(10);
        }
        return num;
    }
    public BankAccount(){
        this.accountNumber = BankAccount.ReturnsRandomNumbers();
        this.checkingAccount = 0;
        this.savingsAccount = 0;
        BankAccount.numberOfAccounts++;
        System.out.println("Checking account is:"+ this.checkingAccount);
        System.out.println("Savings account is:" + this.savingsAccount);
    }
    public double getUserCheckingAccountBal(){
        System.out.printf("Checking Account balance is:$%.2f\n",this.checkingAccount);
        return this.checkingAccount;
    }
    public double getUserSavingAccountBal(){
        System.out.printf("Saving Account balance is:$%.2f\n",this.savingsAccount);
        return this.savingsAccount;
    }
    public void deposit(String account,double amount ){
        if(account.equals("checking")){
            this.checkingAccount += amount;
            System.out.printf("Deposit to checking: $%.2f \n", amount);
        }else if(account.equals("saving")){
            this.savingsAccount += amount;
            System.out.printf("Desposit to savings:$%.2f \n", amount);
            BankAccount.totalAmount += amount;
        }
    }
    public void withdraw(String account,double amount){
        boolean sufficientFunds = false;
        if(account.equals("saving")){
            if(this.savingsAccount>= 0){
                sufficientFunds = true;
                this.savingsAccount -= amount;
                System.out.printf("Savings account now is: $%.2f \n",savingsAccount);
            }
        }
        else if(account.equals("checking")){
            if(this.savingsAccount >= 0){
                sufficientFunds = true;
                this.checkingAccount -= amount;
                System.out.printf("Checking account now is: $%.2f \n",checkingAccount);
            }
        }
        if(sufficientFunds){
            BankAccount.totalAmount -= amount;
        }
    }
    public void displayAccountBalance(){
        System.out.printf("Checking: $%.2f, Saving:$%.2f \n", this.checkingAccount,this.savingsAccount);
    }
    public static int numberOfAccounts(){
        System.out.printf("Total accounts at the moment is: %d", BankAccount.numberOfAccounts);
        return BankAccount.numberOfAccounts;
    }
}
import java.util.Random;
public class BankAccountTest{
    public static void main(String[] args){
        BankAccount person1 = new BankAccount();
        person1.deposit("checking",500);
        person1.deposit("saving",1000);
        person1.displayAccountBalance();
        System.out.println(BankAccount.totalAmount);
        person1.withdraw("saving",300);
        person1.withdraw("checking",200);
        person1.displayAccountBalance();
        System.out.println(BankAccount.totalAmount);
        BankAccount.numberOfAccounts();
    }
}
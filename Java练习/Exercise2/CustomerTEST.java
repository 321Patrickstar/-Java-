package Exercise2;
import Exercise2.Account23;


public class CustomerTEST {
    public static void main(String[] args) {
        Customer cust = new Customer("jane","smith");
        Account23 acct = new Account23(1000,2000,0.0123);
        cust.setAccount(acct);
        cust.getAccount().deposit(100);
        cust.getAccount().withdraw(960);
        cust.getAccount().withdraw(200);
        System.out.println("customer"+cust.getFirstname()+cust.getLastname()+"has a account"+cust.getAccount().getId()+
                cust.getAccount().getBalance()+cust.getAccount().getAnnual());

    }
}

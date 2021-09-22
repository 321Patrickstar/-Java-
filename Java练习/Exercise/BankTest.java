package Exercise;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("jirm","smith");
        //连续操作如果出现空指针的话难识别；
        bank.getCustomer(0).setAccount(new Account(2000));
        bank.getCustomer(0).getAccount().withdraw(500);
        double balance=bank.getCustomer(0).getAccount().getBalance();
        System.out.println(balance);
    }
}

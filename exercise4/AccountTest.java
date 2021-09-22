package exercise4;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122,20000,0.045);
        account.wihdraw(30000);
        System.out.println("您的账户余额为"+account.getBalance());
        account.wihdraw(2500);
        System.out.println("您的账户余额为"+account.getBalance());
        account.deposit(3000);
        System.out.println("您的账户余额为"+account.getBalance());
        System.out.println("您的账户月利率为"+account.getMonthlyBalance());
    }
}

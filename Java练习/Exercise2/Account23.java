package Exercise2;
public class Account23 {
    private int id;
    private double balance;
    private double annual;
    public Account23(int id, double balance, double annual){
        this.annual = annual;
        this.balance = balance;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnual() {
        return annual;
    }

    public void setAnnual(double annual) {
        this.annual = annual;
    }
    public void withdraw(double amount){
        if(balance<amount){
            System.out.println("余额不足");
        }
        balance -= amount;
        System.out.println("成功取出"+amount);
    }
    public void deposit(double amount){
        if (amount>0){
            balance+=amount;
            System.out.println("成功存入"+amount);
        }
    }
}
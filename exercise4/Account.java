package exercise4;

public class Account {
    private int id;
    private double balance;
    private double annualBalance;

    public Account(int id, double balance, double annualBalance) {
        this.id = id;
        this.balance = balance;
        this.annualBalance = annualBalance;
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

    public double getAnnualBalance() {
        return annualBalance;
    }

    public void setAnnualBalance(double annualBalance) {
        this.annualBalance = annualBalance;
    }
    public double getMonthlyBalance(){
        return annualBalance/12;
    }
    //取钱
    public void wihdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            return;
        }
        System.out.println("余额不足");

    }

    public void deposit(double amount){
        if(amount>=0){
            balance+=amount;
        }
    }
}

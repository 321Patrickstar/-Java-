package exercise4;

public class CheckAccount extends Account{
    private double overdraft;

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualBalance, double overdraft) {
        super(id, balance, annualBalance);
        this.overdraft = overdraft;
    }
    public void wihdraw(double amount){
        if(getBalance()>=amount){//这里面可不能用getbalance来进行调用
         //getBalance-=amount
         //这其实应该是一个赋值语句，
            // setBalance(getBalance()-amount);这个可以
            //还可以直接去调用父类的withdraw;
            super.wihdraw(amount);//余额1500，但是实际要2000，超额的要从行用卡扣
            //我们要判断超额的部分信用卡能不能支付
        }else if(overdraft>=amount-getBalance()){
            overdraft-=(amount-getBalance());//我们得先减再把它设置成零
            //也可以调用父类的withdraw来归零
            super.wihdraw(getBalance());
            //setBalance(0);
        }else{
            System.out.println("超过信用卡金额");
        }


    }
}

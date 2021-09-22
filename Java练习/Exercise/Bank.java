package Exercise;

public class Bank {
    private Customer[] customers;//这里默认的值是0，可以在这赋值
    private int numberofcustomers;
    public Bank(){
        customers = new Customer[10];//也可以再构造器中赋值
    }
    public void addCustomer(String f,String l){
        Customer cust = new Customer(f,l);
        customers[numberofcustomers] = cust;
        numberofcustomers++;
        //合成一句customers[numberofcustomers++] = cust;
    }
    public  int getNumberofcustomers(){
        return numberofcustomers;
    }
    public  Customer getCustomer(int indes){
        if(indes>=0&&indes<numberofcustomers){
            return customers[indes];
        }
        return null;
    }

}

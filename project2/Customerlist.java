package project2;

public class Customerlist {
    private Customer[] customers;
    private int total =0;
    //初始化数组
    public Customerlist(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    public boolean addCustomer(Customer customer){
        if(total>=customers.length){
            return  false;
        }
        customers[total] = customer;
        total++;
        return  true;
    }
    public boolean replaceCustomer(int index,Customer cust){
        if(index<0||index>=total){
            return false;
        }
        customers[index]= cust;
        return true;
    }
    public boolean deleteCustomer(int index){
        if(index<0||index>=total){
            return false;
        }
        for(int i =index;i<total-1;++i){
            customers[i] = customers[i+1];
        }
        //可以简写customer[--total]=null
        customers[total-1] = null;
        total--;
        return true;
    }
    public Customer[] getALLCustomers(){
        Customer[] custs = new Customer[total];
        for(int i=0;i<total;++i){
            custs[i] = customers[i];//只是两个数组的地址都指向了同一个对象
        }
        return custs;
    }
    public Customer getCustomer(int index){
        if(index<0||index>=total){
            return null;
        }
        return customers[index];
    }
    public  int getTotal(){
        return total;
    }
}

package javastudylast;
/*
* 单例式的懒汉式实现
* 要用的时候才造好
* */
public class SingletonTEXT2 {
    public static void main(String[] args) {
        Order order = Order.getInstance();
        Order order2= Order.getInstance();
        System.out.println(order==order2);
    }
}
class Order{
    private Order(){

    }//此对象也是static
    private static Order instance = null;
    public static Order getInstance(){
        if(instance==null){
            instance = new Order();
        }
        return instance;
    }
}

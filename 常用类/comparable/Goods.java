package comparable;
/**
        * 4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
        *   在compareTo(obj)方法中指明如何排序
 *   自然排序
        */
public class Goods implements Comparable {

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price + '}';

    }

    @Override
    public int compareTo(Object o) {
       // instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方式一
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {//出现同名的情况
                //return 0;
                return this.name.compareTo(goods.name);
                //return -this.name.compareTo(goods.name);从高到底
            }
              //方式二
           // return Double.compare(this.price, goods.price);
        }
        //如果不是商品抛个异常
        throw new RuntimeException("传入的数据不一致");
    }
}

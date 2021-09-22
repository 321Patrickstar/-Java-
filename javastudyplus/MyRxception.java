package javastudyplus;
/*
* 如果自定义异常类？
* 1.继承于现有的异常结构，RuntimeException,Exception
* 2.提供全局常量：serialVersionUID相当于对类的标识
* 3.提供重载的构造器
*
*
* */
public class MyRxception extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;
    public MyRxception(){

    }
    public MyRxception(String name){
        super(name);
    }
}

package javastudyplus;
/*
* 我们在无论是自定义的异常类，还是抛出系统的异常类后面（都有可以string文字描述）
* 我们抛出来的文字描述，可以在调用此方法的处理异常处使用get message获得
*
* */
public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.register(-1001);
            System.out.println(s);
        } catch (Exception e) {//在这里就是处理了
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
class Student {
    private int id;
    public  void register(int id) throws Exception {
        if(id>0){
            this.id = id;
        }else{
            //System.out.println("输入类型数据非法");
            //手动抛出异常对象(运行时异常）
            //throw new RuntimeException("输入类型数据非法");
            //生成异常对象
            //new Exception("输入类型数据非法");
            throw new MyRxception("不能输入负数");
            //只有一场体系的才能throw继承于异常类的对象
        }
    }
}

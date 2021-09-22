package javastudylast3;
/*
* 接口的使用
* 多态性
* 声明接口是
* 实际上
* 是实现类
* 接口实际上就是规范
* 面向接口编程（项目的需求是多变的，要以不变应对万变）
* 开发中体会面向接口编程
* */
public class UsbTest {
    public static void main(String[] args) {
        //这个接口不能造对象，体现了多态性
        Computer computer = new Computer();
        //创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transferdata(flash);
        //2.创建接口的非匿名实现类的匿名对象
        computer.transferdata(new println());
        //3.创建接口的匿名实现类的非匿名对象
        Usb phone = new Usb(){

            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {

            }
        };
        computer.transferdata(phone);
        //4.创建；额接口的匿名实现类的匿名对象
        computer.transferdata(new Usb() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {

            }
        });

    }

}
class Computer {
    public void transferdata(Usb usb){
        usb.start();
        System.out.println("具体的传输数据的细节");
        usb.stop();
    }
}
interface Usb{
    //定义长，宽，尺寸，最大最小从传输速度等
    void start();
    void stop();
}
class Flash implements Usb{

    @Override
    public void start() {
        System.out.println("u盘开启工作");
    }

    @Override
    public void stop() {
        System.out.println("u盘结束工作");
    }
}
class println implements Usb{

    @Override
    public void start() {
        System.out.println("打印机结束工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}


package javastudylast3;
/*
* 接口的应用
* 代理模式
* 通过被代理类实现对代理类的代理
* 代理类的方法对接口的覆盖，不调用代理类，选择调用被代理类来调用方法
* 如何被代理人来调用代理人重写的方法呢被代理人的成员是接口，由接口的有参构造器
* 被代理人对象调用构造器，实参时代理人对象（体现多态）
* 代理人对象就能调用代理人重写的方法了，通过接口来实现代理
* 接口的引用工厂模式（工厂是来造对象的）创建者和调用者分离
* 当父类和接口类得变量是一样的时候如何区分
* 父类可以子类super.而接口变量都是全局常量接口类.就行了
*
*
*
* */
public class NetworkTest {
    public static void main(String[] args) {
        Server server=new Server();
        //被代理的构造器是接口
        ProxyServer proxyServer=new ProxyServer(server);//多态
        proxyServer.browse();
    }
}
interface Network{
    void browse();
}
//被代理类
class  Server implements Network{

    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}
//代理类
class ProxyServer implements Network{
    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public  void check(){
        System.out.println("联网之前的检查操作");
    }
    @Override
    public void browse() {
        check();
        network.browse();


    }
}
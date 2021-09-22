package IOStream;

import org.junit.Test;

import java.io.*;
/*
方法重命名文件、方法、属性等（rename）：SHIFT+F6
        提取当前选择为变量（extract variable）：CTRL+ALT+V
        提取当前选择为属性（extract field）：CTRL+ALT+F
        提取当前选择为常量（extract constant）：CTRL+ALT+C
        提取当前选择为方法（extract method）：CTRL+ALT+M
        提取当前选择为方法参数（extract parameter）：CTRL+ALT+P
        重构类、方法（change signarture）：CTRL+F6
        提取代码块至if、try等结构中（surround with）：CTRL+ALT+T
        创建模块文件等（new）：CTRL+ALT+N
        创建测试用例（test）：CTRL+SHIFT+T
        重构菜单（refactor for this）：CTRL+T

*/

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("Hellow.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("D:\\untitled1\\JavaSuper\\Hellow.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 将day09下的hello.txt文件内容读入程序中，并输出到控制台
     * <p>
     * 说明点：
     * 1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
     * 2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
     * 3. 读入的文件一定要存在，否则就会报FileNotFoundException。
     */

    @Test
    public void test() {
        FileReader fr = null;
        try {
            //实例化File对象，指明要操作的文件
            File file = new File("Hellow.txt");//相较于当前的Module
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入过程
            //read():返回读入的一个字符。如果达到文件末尾，返回-1.
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char) data);
//            data = fr.read();//相当于n++，挨个去读指向下一个
//        }
            //这里有俩个read 看起来有点重复，知识语法上的修改并没有改变效率

            //方式二：语法上针对于方式一的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //如果使用throw来进行操作，后面的程序就不再执行了，为了保证一i的那个执行关闭需要这个来处理
        } finally {
            //4.流的关闭操作
//            try {
//                if(fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //或//这里如果是在创造流对象的时候出现异常的时候，对象没有找到成功
            //这个时候fr。close就出现问题，空指针空对象
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];//这个数组的空间是不变的，每次给值都是赋值赋给新的值
            int len;
            fr.read(cbuf);
            while ((len = fr.read(cbuf)) != -1) {
                //方式一：
                //错误的写法
//                for(int i = 0;i < cbuf.length;i++){
//                    System.out.print(cbuf[i]);
//                }
                //正确的写法
//                for(int i = 0;i < len;i++){
//                    System.out.print(cbuf[i]);
//                }

                //方式二：对应的也是（123ld）
                //错误的写法,对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);
                //正确的写法
                //只取
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 从内存中写出数据到硬盘的文件里。
     * <p>
     * 说明：
     * 1.输出操作，对应的File可以不存在的。并不会报异常
     * 2.
     * File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     * File对应的硬盘中的文件如果存在：
     * 如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
     * 如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("Hellow2.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, false);
            //false不在原有文件添加
            //true 可以在原有文件添加

            //3.写出的操作
            fw.write("I have a dream apple!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test4() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello1.txt");
            File srcFile2 = new File("hello2..txt");

            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("爱情与友情.jpg");
//            File srcFile2 = new File("爱情与友情1.jpg");

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(srcFile2);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //方式一：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二：//这里的异常已经被处理掉了，后面的结构可以接着执行
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 测试FileInputStream和FileOutputStream的使用
     *
     * 结论：
     *    1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理,如果只是复制不读字节流也可以的
     *    2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
     */
        //使用字节流FileInputStream处理文本文件，可能出现乱码。
        @Test
        public void testFileInputStream(){
            FileInputStream fis = null;
            try {
                //1.造文件
                File file = new File("hello.txt");

                //2.造流
                fis = new FileInputStream(file);

                //3.读数据
                byte[] buffer = new byte[5];
                int len;//记录每次读取的字节的个数
                while((len = fis.read(buffer)) != -1){
                    String str = new String(buffer,0,len);
                    System.out.print(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(fis != null) {
                    //4.关闭资源
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    /**
     * 实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情2.jpg");

            //2.造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.复制的过程
            byte[] buffer = new byte[5];
            int len;
            //4.读数据
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //5.关闭资源
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

//        String srcPath = "C:\\Users\\29433\\Desktop\\164.jpg";
//        String destPath = "C:\\Users\\29433\\Desktop\\164.jpg";

        String srcPath = "D:\\1112\\12345.jpg";
        String destPath = "hello3.jpg";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//1
    }

}


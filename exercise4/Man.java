package exercise4;


interface filialog {
    default void help(){
        System.out.println("老妈我来就你了");
    }
}
interface spoony{
    default void help(){
        System.out.println("媳妇我来就你了");
    }
}
class fathers{
    public void help(){
        System.out.println("就我媳妇");
    }
}
public class Man extends fathers implements spoony,filialog{
//就不会有冲突了
}
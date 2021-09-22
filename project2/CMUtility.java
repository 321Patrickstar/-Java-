package project2;

import java.io.CharArrayWriter;
import java.util.*;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);
    //用于界面菜单的选择，该方法读取键盘
    public static String readKeyboard(int limit,boolean blankreturn){
        String line = "";
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length()==0){
                if(blankreturn)return line;
                else continue;
            }
            if(line.length()<1||line.length()>limit){
                System.out.println(("输入长度（不大于"+limit+")错误请重新输入"));
                continue;
            }
            break;
        }
        return line;
    }
    //用于界面菜单的选择，该方法读取键盘，如果输入1-5任意字符，则方法返回，返回值为字符
    public static char readMenuSelection(){
        char c;
        for(;;){
            String str = readKeyboard(1,false);
            c= str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5'){
                System.out.println("选择错误，请重新输入");
            }else break;
        }
        return c;
    }
    //从键盘读取一个字符，将其作为方法的返回值
    //如果用户不输入字符直接回车，方法将一defaultvalue作为返回值
    public  static char readChar(){
        String str = readKeyboard(1,false);
        return str.charAt(0);
    }
    public static char readChar(char defaultValue) {
        String str = readKeyboard(1, true);
        return (str.length() == 0)?defaultValue:str.charAt(0);
    }
    //从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
    public static int readInt(){
        int n;
        for(;;){
            String str = readKeyboard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }
    //从键盘中读取一个长度不超过两位的整数，并将其作为方法的返回值
    //如果用户不输入字符而直接回车，方法以defaultvalue作为返回值
    public static int readInt(int defaultValue){
        int n;
        for(;;){
            String str = readKeyboard(2,true);
            if(str.equals("")){
                return defaultValue;
            }
            try{
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }
    //从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值
    public static String readString(int limit){
        return readKeyboard(limit,false);
    }
    //从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值
    //如果用户不输入字符串而直接回车，返回defaultvalue作为返回值
    public static String readString(int limit,String defaultValue){
        String str = readKeyboard(limit,true);
        return str.equals("")?defaultValue:str;
    }
    //用于确认选择的输入，该方法从键盘读取‘Y'或’N‘，并将其作为返回值
    public static char readConfirmselection(){
        char c;
        for(;;){
            String str = readKeyboard(1,false).toLowerCase();
            c= str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入");
            }
        }
        return c;
    }

    

}


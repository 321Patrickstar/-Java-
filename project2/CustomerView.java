package project2;

public class CustomerView {
    private Customerlist customerlist = new Customerlist(10);
    public void enterMainMenu() {
        boolean flag = true;
        while(flag){
            System.out.println("\n------------------客户信息管理系统-------------------------");
            System.out.println("                     1.添加客户                            ");
            System.out.println("                     2.修改客户                            ");
            System.out.println("                     3.删除客户                            ");
            System.out.println("                     4.客户列表                            ");
            System.out.println("                     5.退出\n                            ");
            System.out.println("                   请选择（1-5）:                            ");
            char menu = CMUtility.readMenuSelection();
            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出（Y/N),");
                     char EXIT = CMUtility.readConfirmselection();
                     if(EXIT=='Y'){
                         flag = false;
                     }
            }
        }
    }
    public  CustomerView(){
        Customer customer = new Customer("王涛",'男',23,"1233456","wt@gmail.com");
        customerlist.addCustomer(customer);
    }
    private void modifyCustomer(){
        System.out.println("----------------修改客户----------------");
        Customer cust;
        int number;
        for(;;){
            System.out.println("请选择修改客户的编号（-1退出）");
            number  = CMUtility.readInt();
            //int number  = CMUtility.readInt();
            if(number == -1){//后面需要用到这个客户的位置
                return;
            }
            // 把此处的申明移到上面就可以实现对于后面修改操作好修改
            //Customer cust = customerlist.getCustomer(number-1);
            cust = customerlist.getCustomer(number-1);
            //这里的number和数组不一样你得减一才能正确索引
            if(cust==null){
                System.out.println("无法找到指定客户");
            }else{//找到客户了
                break;//再嵌套太臃肿了
            }
        }
        //修改客户
        System.out.println("姓名（"+cust.getName()+"):");
        String name = CMUtility.readString(10,cust.getName());//这里就要用到后面的了
        System.out.println("性别（"+cust.getGender()+"):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.println("年龄（"+cust.getAge()+"):");
        int  age = CMUtility.readInt(cust.getAge());
        System.out.println("电话（"+cust.getPhone()+"):");
        String phone = CMUtility.readString(13,cust.getPhone());
        System.out.println("邮箱（"+cust.getEmail()+"):");
        String email = CMUtility.readString(30,cust.getEmail());
        Customer newcustomer = new Customer(name,gender,age,phone,email);
        boolean isreplace = customerlist.replaceCustomer(number-1,newcustomer);//同样的这里的number需要减一
        if(isreplace){
            System.out.println("--------------------修改成功-----------------");
        }else{
            System.out.println("--------------------修改失败-----------------");
        }

    }
    private void addNewCustomer(){
        System.out.println("------------------------添加客户------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);
        //将上述数据封装到对象当中
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean issuccess = customerlist.addCustomer(customer);
        if(issuccess){
            System.out.println("---------------添加完成------------------");
        }else{
            System.out.println("---------------添加失败------------------");
        }


    }
    private void deleteCustomer(){
        System.out.println("----------删除客户-----------");//带in是换行，不带是直接打
        Customer cust;
        for(;;) {
            System.out.print("请选择待删除的客户编号（-1退出）：");
            int number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            cust=customerlist.getCustomer(number-1);
            if(cust==null){
                System.out.println("无法找到指定客户");
            }else
            {
                break;
            }
            System.out.println("确认删除（Y/N）");
            char isdelete = CMUtility.readConfirmselection();
            if(isdelete =='Y'){
                customerlist.deleteCustomer(number-1);
            }else{
                return;
            }
        }

    }
    private void listAllCustomer() {
        System.out.println("------------客户列表------------------");
        int total = customerlist.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            Customer[] cust = customerlist.getALLCustomers();
            for (int i = 0; i < total; ++i) {
                Customer custs = cust[i];
                System.out.println((i + 1) + "\t" + custs.getName() + "\t" + custs.getGender() + "\t" + custs.getAge() + "\t" + custs.getPhone() + "\t" + custs.getEmail());
            }
            System.out.println("---------客户列表结束----------------");
         }
    }
    private static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

}

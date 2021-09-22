package javaCollection;

public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof User){
            User user = (User) o;
            //return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.name);
            if(compare !=0){
                return this.name.compareTo(user.name);
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            //如果是自定义的异常这里还是有点问题的
            throw new RuntimeException("输入的字符不匹配");
        }
    }
}
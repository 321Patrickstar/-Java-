package Exercise;

public class Customer {
    private String firstname;
    private String lastname;
    private Account account;
    public Customer(String f,String l){
        this.firstname=f;
        this.lastname = l;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Account getAccount() {
        return account;
    }

     public void setAccount(Account account) {
        this.account = account;
    }
}

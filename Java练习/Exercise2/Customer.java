package Exercise2;
import Exercise2.Account23;

public class Customer {
  private String firstname;
  private String lastname;
  private Account23 account;
  public Customer(String firstname,String lastname){
    this.firstname=firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public Account23 getAccount() {
    return account;
  }

  public void setAccount(Account23 account) {
    this.account = account;
  }
}

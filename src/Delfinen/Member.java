package Delfinen;

public abstract class Member {

  protected String name;
  protected Integer memberNumber;
  protected Integer age;
  protected String email;
  protected boolean isMembershipPaid;

  public Member (String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid){
    this.name = name;
    this.memberNumber = memberNumber;
    this.age = age;
    this.email = email;
    this.isMembershipPaid = isMembershipPaid;
  }
}

package Delfinen;

public class Competitor extends Member {

  private String gender; //TODO: Det findes kun 2 konkurrenceklasser: M / F. Fejlmelding

  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender) {
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;

  }
}

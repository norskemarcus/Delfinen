package Delfinen.Member;

public class Competitor extends Member {

  private String gender; //TODO: Det findes kun 2 konkurrenceklasser: M / F. Fejlmelding
  private int recordMin;
  private int recordSec;
  private SwimmingDisciplins swimmingDisciplin;

  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender, SwimmingDisciplins swimmingDisciplin) {
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;
    this.swimmingDisciplin = swimmingDisciplin;

  }


  public SwimmingDisciplins getSwimmingDisciplin() {
    return swimmingDisciplin;
  }

  public void setSwimmingDisciplin(SwimmingDisciplins swimmingDisciplin) {
    this.swimmingDisciplin = swimmingDisciplin;
  }

  public int getRecordMin() {
    return recordMin;
  }

  public void setRecordMin(int recordMin) {
    this.recordMin = recordMin;
  }

  public int getRecordSec() {
    return recordSec;
  }

  public void setRecordSec(int recordSec) {
    this.recordSec = recordSec;
  }

  public String getGender() {
    return gender;
  }
}

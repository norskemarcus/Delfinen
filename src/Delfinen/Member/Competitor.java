package Delfinen.Member;

import Delfinen.Coach.PersonalBestEvent;

public class Competitor extends Member {

  private String gender; //TODO: Det findes kun 2 konkurrenceklasser: M / F. Fejlmelding
  private int recordMin;
  private int recordSec;
  private SwimmingDisciplins swimmingDisciplin;
  private PersonalBestEvent trainingEvent;
  private Integer personalBestTrainingTimeMinutes;
  private Integer personalBestTrainingTimeSeconds;
  private Integer personalBestMonth;
  private Integer personalBestYear;


  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender, SwimmingDisciplins swimmingDisciplin, Integer personalBestTrainingTimeMinutes, Integer personalBestTrainingTimeSeconds, Integer personalBestMonth, Integer personalBestYear) {
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;
    this.swimmingDisciplin = swimmingDisciplin;
    this.trainingEvent = PersonalBestEvent.TRÆNING;
    this.personalBestTrainingTimeMinutes = personalBestTrainingTimeMinutes;
    this.personalBestTrainingTimeSeconds = personalBestTrainingTimeSeconds;
    this.personalBestMonth = personalBestMonth;
    this.personalBestYear = personalBestYear;

  }

  public void setPersonalBestMonth(Integer personalBestMonth) {
    this.personalBestMonth = personalBestMonth;
  }

  public void setPersonalBestYear(Integer personalBestYear) {
    this.personalBestYear = personalBestYear;
  }

  public Integer getPersonalBestMonth() {
    return personalBestMonth;
  }

  public Integer getPersonalBestYear() {
    return personalBestYear;
  }

  public void setPersonalBestTrainingTimeMinutes(Integer personalBestTrainingTimeMinutes) {
    this.personalBestTrainingTimeMinutes = personalBestTrainingTimeMinutes;
  }

  public void setPersonalBestTrainingTimeSeconds(Integer personalBestTrainingTimeSeconds) {
    this.personalBestTrainingTimeSeconds = personalBestTrainingTimeSeconds;
  }

  public Integer getPersonalBestTrainingTimeMinutes() {
    return personalBestTrainingTimeMinutes;
  }

  public Integer getPersonalBestTrainingTimeSeconds() {
    return personalBestTrainingTimeSeconds;
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

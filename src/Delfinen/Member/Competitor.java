package Delfinen.Member;

import Delfinen.Coach.PersonalBestEvent;

public class Competitor extends Member {

  private String gender; //TODO: Det findes kun 2 konkurrenceklasser: M / F. Fejlmelding

  private SwimmingDisciplins swimmingDisciplin;
  private Integer personalBestTrainingTimeMinutes;
  private Integer personalBestTrainingTimeSeconds;
  private Integer personalBestTrainingMonth;
  private Integer personalBestTrainingYear;
  private Integer personalBestCompetitionTimeMinutes;
  private Integer personalBestCompetitionTimeSeconds;
  private Integer personalBestCompetitionMonth;
  private Integer personalBestCompetitionYear;


  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender, SwimmingDisciplins swimmingDisciplin,
                    Integer personalBestTrainingTimeMinutes, Integer personalBestTrainingTimeSeconds, Integer personalBestTrainingMonth, Integer personalBestTrainingYear,
                    Integer personalBestCompetitionTimeMinutes, Integer personalBestCompetitionTimeSeconds, Integer personalBestMonthCompetition, Integer personalBestYearCompetition) {
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;
    this.swimmingDisciplin = swimmingDisciplin;
    this.personalBestTrainingTimeMinutes = personalBestTrainingTimeMinutes;
    this.personalBestTrainingTimeSeconds = personalBestTrainingTimeSeconds;
    this.personalBestTrainingMonth = personalBestTrainingMonth;
    this.personalBestTrainingYear = personalBestTrainingYear;
    this.personalBestCompetitionTimeMinutes = personalBestCompetitionTimeMinutes;
    this.personalBestCompetitionTimeSeconds = personalBestCompetitionTimeSeconds;
    this.personalBestCompetitionMonth = personalBestMonthCompetition;
    this.personalBestCompetitionYear = personalBestYearCompetition;
  }

  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender, SwimmingDisciplins swimmingDisciplin){
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;
    this.swimmingDisciplin = swimmingDisciplin;
    this.personalBestTrainingTimeMinutes = null;
    this.personalBestTrainingTimeSeconds = null;
    this.personalBestTrainingMonth = null;
    this.personalBestTrainingYear = null;
    this.personalBestCompetitionTimeMinutes = null;
    this.personalBestCompetitionTimeSeconds = null;
    this.personalBestCompetitionMonth = null;
    this.personalBestCompetitionYear = null;
  }

  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender, SwimmingDisciplins swimmingDisciplin, BestTrainingResult bestTrainingResult, BestCompetitionResult bestCompetitionResult){
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;
    this.swimmingDisciplin = swimmingDisciplin;
    this.personalBestTrainingTimeMinutes = null;
    this.personalBestTrainingTimeSeconds = null;
    this.personalBestTrainingMonth = null;
    this.personalBestTrainingYear = null;
    this.personalBestCompetitionTimeMinutes = null;
    this.personalBestCompetitionTimeSeconds = null;
    this.personalBestCompetitionMonth = null;
    this.personalBestCompetitionYear = null;
  }



  public Integer getPersonalBestCompetitionTimeMinutes() {
    return personalBestCompetitionTimeMinutes;
  }

  public Integer getPersonalBestCompetitionTimeSeconds() {
    return personalBestCompetitionTimeSeconds;
  }

  public Integer getPersonalBestCompetitionMonth() {
    return personalBestCompetitionMonth;
  }

  public Integer getPersonalBestCompetitionYear() {
    return personalBestCompetitionYear;
  }

  public void setPersonalBestTrainingMonth(Integer personalBestTrainingMonth) {
    this.personalBestTrainingMonth = personalBestTrainingMonth;
  }

  public void setPersonalBestTrainingYear(Integer personalBestTrainingYear) {
    this.personalBestTrainingYear = personalBestTrainingYear;
  }

  public Integer getPersonalBestTrainingMonth() {
    return personalBestTrainingMonth;
  }

  public Integer getPersonalBestTrainingYear() {
    return personalBestTrainingYear;
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


  public String getGender() {
    return gender;
  }
}

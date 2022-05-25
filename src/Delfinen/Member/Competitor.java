package Delfinen.Member;

public class Competitor extends Member {

  private final String gender; //TODO: Det findes kun 2 konkurrenceklasser: M / F. Fejlmelding
  private final SwimmingDisciplin swimmingDisciplin;
  private final BestResultCompetition bestResultCompetition;
  private final BestResultTraining bestResultTraining;

  public Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender, SwimmingDisciplin swimmingDisciplin, BestResultTraining bestResultTraining, BestResultCompetition bestResultCompetition){
    super(name, memberNumber, age, email, isMembershipPaid);
    this.gender = gender;
    this.swimmingDisciplin = swimmingDisciplin;
    this.bestResultCompetition = bestResultCompetition;
    this.bestResultTraining = bestResultTraining;
  }

  public BestResultCompetition getBestResultCompetition() {
    return bestResultCompetition;
  }

  public BestResultTraining getBestResultTraining() {
    return bestResultTraining;
  }

  public SwimmingDisciplin getSwimmingDisciplin() {
    return swimmingDisciplin;
  }

  public String getGender() {
    return gender;
  }
}
package Delfinen.Coach;

import Delfinen.Member.*;
import Delfinen.Persistence.FileHandler;

import java.util.ArrayList;

public class ControllerCoach {

  private final UICoach uiCoach = new UICoach();
  private final MemberList memberList = new MemberList();
  private final FileHandler fileHandler = new FileHandler();
  private boolean running = true;
  boolean runningDisciplines;
  boolean runningAge;

  private void saveAndReturnToMainMenu() {
    fileHandler.saveAllNonCompetitorsToFile(memberList.getAllNonCompetitors());
    fileHandler.saveAllCompetitorsToFile(memberList.getAllCompetitors());
    running = false;
  }

  public void loadAndThenRunMain() {
    memberList.setAllNonCompetitors(fileHandler.loadNonCompetitors());
    memberList.setAllCompetitors(fileHandler.loadCompetitors());
    menuCoach();
  }

  public void menuCoach() {

    running = true;

    while (running) {

      uiCoach.printHeader();
      uiCoach.printMenuOptions();

      final String GENDER_FEMALE = "K";
      final String GENDER_MALE = "M";

      switch (uiCoach.inputNumber()) {
        case 1 -> menuSwimmers(GENDER_FEMALE);
        case 2 -> menuSwimmers(GENDER_MALE);
        case 3 -> createNewCompetition();
        case 4 -> createNewTraining();
        case 5 -> changeMemberToCompetitor();
        case 0 -> saveAndReturnToMainMenu();
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void menuSwimmers(String gender) {
    runningAge = true;
    while (runningAge) {
      uiCoach.printMenuJrSr();

      final int AGE_JUNIOR = 17;
      final int AGE_SENIOR = 18;

      switch (uiCoach.inputNumber()) {
        case 1 -> menuSwimmingDisciplin(gender, AGE_JUNIOR);
        case 2 -> menuSwimmingDisciplin(gender, AGE_SENIOR);
        case 3 -> runningAge = false;
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void menuSwimmingDisciplin(String gender, int age) {

    runningDisciplines = true;

    while (runningDisciplines) {
      uiCoach.printMenuDisciplines();

      switch (uiCoach.inputNumber()) {

        case 1 -> {

          ArrayList<Competitor> top5Competition = memberList.createTop5ListCompetition(gender, SwimmingDisciplin.BRYST, age);
          ArrayList<Competitor> top5Training = memberList.createTop5ListTraining(gender, SwimmingDisciplin.BRYST, age);
          uiCoach.printTop5List(top5Training, top5Competition);
        }
        case 2 -> {
          ArrayList<Competitor> top5Competition = memberList.createTop5ListCompetition(gender, SwimmingDisciplin.CRAWL, age);
          ArrayList<Competitor> top5Training = memberList.createTop5ListTraining(gender, SwimmingDisciplin.CRAWL, age);
          uiCoach.printTop5List(top5Training, top5Competition);
        }
        case 3 -> {
          ArrayList<Competitor> top5Competition = memberList.createTop5ListCompetition(gender, SwimmingDisciplin.RYGCRAWL, age);
          ArrayList<Competitor> top5Training = memberList.createTop5ListTraining(gender, SwimmingDisciplin.RYGCRAWL, age);
          uiCoach.printTop5List(top5Training, top5Competition);
        }
        case 4 -> {
          ArrayList<Competitor> top5Competition = memberList.createTop5ListCompetition(gender, SwimmingDisciplin.BUTTERFLY, age);
          ArrayList<Competitor> top5Training = memberList.createTop5ListTraining(gender, SwimmingDisciplin.BUTTERFLY, age);
          uiCoach.printTop5List(top5Training, top5Competition);
        }
        case 5 -> runningDisciplines = false;

        case 0 -> {
          runningAge = false;
          runningDisciplines = false;
        }
        default -> uiCoach.printErrorMessage();
      }
    }
  }


  public void createNewTraining() {
    int membernumber = uiCoach.inputMembernumber();
    Competitor competitor = (Competitor) memberList.findSpecifikMemberByMemberNumber(membernumber);
    if (competitor != null) {
      uiCoach.createNewTrainingResult(competitor);
    } else {
      uiCoach.memberNotFound();
    }
  }

  public void createNewCompetition() {
    int memberNumber = uiCoach.inputMembernumber();
    Competitor competitor = (Competitor) memberList.findSpecifikMemberByMemberNumber(memberNumber);
    if (competitor != null) {
      uiCoach.createNewCompetitionResult(competitor);
    } else {
      uiCoach.memberNotFound();
    }
  }

  public void changeMemberToCompetitor() {
    int memberNumber = uiCoach.inputMembernumber();
    Member member = memberList.findSpecifikMemberByMemberNumber(memberNumber);
    if (member instanceof NonCompetitor nonCompetitor) {
      uiCoach.printMemberToChange(member);
      if (uiCoach.confirmEditMember(member.getName())) {
        createCompetitorFromNonCompetitor(nonCompetitor);
      }
    } else if (member instanceof Competitor) {
      uiCoach.printNotCorrectMemberType(member.getName());
    } else {
      uiCoach.memberNotFound();
    }
  }


  public void createCompetitorFromNonCompetitor(NonCompetitor nonCompetitor) {

    String name = nonCompetitor.getName();
    Integer memberNumber = nonCompetitor.getMemberNumber();
    Integer age = nonCompetitor.getAge();
    String email = nonCompetitor.getEmail();
    boolean isMembershipPaid = nonCompetitor.isMembershipPaid();
    String gender = uiCoach.addGenderToNewCompetitor();
    SwimmingDisciplin swimmingDisciplin = null;
    uiCoach.showDisciplinesOptions();
    int choice = uiCoach.inputInteger(1, 4);
    switch (choice) {
      case 1 -> swimmingDisciplin = SwimmingDisciplin.BRYST;
      case 2 -> swimmingDisciplin = SwimmingDisciplin.CRAWL;
      case 3 -> swimmingDisciplin = SwimmingDisciplin.RYGCRAWL;
      case 4 -> swimmingDisciplin = SwimmingDisciplin.BUTTERFLY;

    }

    BestResultCompetition bestResultCompetition = new BestResultCompetition(0, 0, 0, 0);
    BestResultTraining bestResultTraining = new BestResultTraining(0, 0, 0, 0);

    Competitor competitor = new Competitor(name, memberNumber, age, email, isMembershipPaid, gender, swimmingDisciplin, bestResultTraining, bestResultCompetition);
    memberList.getAllCompetitors().add(competitor);
    memberList.getAllNonCompetitors().remove(nonCompetitor);
    //TODO: remove nonCompetitor from the other memberlist

  }

}


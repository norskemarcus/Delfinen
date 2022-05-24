package Delfinen.Coach;

import Delfinen.Member.Competitor;
import Delfinen.Member.MemberList;
import Delfinen.Member.SwimmingDisciplin;
import Delfinen.Member.Top5ListTrainingComparator;
import Delfinen.Persistence.FileHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ControllerCoach {

  private UICoach uiCoach = new UICoach();
  private MemberList memberList = new MemberList();
  private FileHandler fileHandler = new FileHandler();
  private boolean running = true;

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
        case 5 -> uiCoach.printAllCompetitors(memberList.getAllCompetitors());
        case 0 -> saveAndReturnToMainMenu();
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void menuSwimmers(String gender) {
    while (running) {
      uiCoach.printMenuJrSr();

      final int AGE_JUNIOR = 17;
      final int AGE_SENIOR = 18;

      switch (uiCoach.inputNumber()) {
        case 1 -> menuSwimmingDisciplin(gender, AGE_JUNIOR);
        case 2 -> menuSwimmingDisciplin(gender, AGE_SENIOR);
        case 0 -> saveAndReturnToMainMenu();
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void menuSwimmingDisciplin(String gender, int age){
    while (running) {
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
        case 4 ->{
          ArrayList<Competitor> top5Competition = memberList.createTop5ListCompetition(gender, SwimmingDisciplin.BUTTERFLY, age);
          ArrayList<Competitor> top5Training = memberList.createTop5ListTraining(gender, SwimmingDisciplin.BUTTERFLY, age);
          uiCoach.printTop5List(top5Training, top5Competition);
        }
        case 0 -> saveAndReturnToMainMenu();
        default -> uiCoach.printErrorMessage();
      }
    }
  }


  public void createNewTraining(){
    int membernumber = uiCoach.inputMembernumber();
    Competitor competitor = (Competitor) memberList.findSpecifikMemberByMemberNumber(membernumber);
    if(competitor != null) {
      uiCoach.createNewTrainingResult(competitor);
    } else {
      uiCoach.memberNotFound();
    }
  }

  public void createNewCompetition(){
    int memberNumber = uiCoach.inputMembernumber();
    Competitor competitor = (Competitor) memberList.findSpecifikMemberByMemberNumber(memberNumber);
    if(competitor != null) {
      uiCoach.createNewCompetitionResult(competitor);
    } else {
      uiCoach.memberNotFound();
    }
  }

}


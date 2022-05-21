package Delfinen.Coach;

import Delfinen.Member.Competitor;
import Delfinen.Member.MemberList;
import Delfinen.Persistence.FileHandler;

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

      switch (uiCoach.inputNumber()) {
        case 1, 2 -> menuSwimmers();
        case 3 -> createNewCompetition();
        case 4 -> createNewTraining();
        case 5 -> uiCoach.printAllCompetitors(memberList.getAllCompetitors());
        case 0 -> saveAndReturnToMainMenu();
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void menuSwimmers() {
    while (running) {
      uiCoach.printMenuJrSr();

      switch (uiCoach.inputNumber()) {
        case 1, 2 -> menuSwimmingDisciplin();
        case 0 -> saveAndReturnToMainMenu();
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void menuSwimmingDisciplin(){
    while (running) {
      uiCoach.printMenuDisciplines();

      switch (uiCoach.inputNumber()) {
        case 1 -> uiCoach.printTop5Chest(memberList.getAllCompetitors());
        case 2 -> uiCoach.printTop5Crawl(memberList.getAllCompetitors());
        case 3 -> uiCoach.printTop5BackCrawl(memberList.getAllCompetitors());
        case 4 -> uiCoach.printTop5Butterfly(memberList.getAllCompetitors());
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
    int membernumber = uiCoach.inputMembernumber();
    Competitor competitor = (Competitor) memberList.findSpecifikMemberByMemberNumber(membernumber);
    if(competitor != null) {
      uiCoach.createNewCompetitionResult(competitor);
    } else {
      uiCoach.memberNotFound();
    }
  }

}


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
        case 1 -> System.out.println("Se bedste resultater for kvinder (Med flere valg)"); //Skal være metoder til UI
        case 2 -> System.out.println("Se bedste resultater for Mænd (vælg senere mellem senior og junior , måske senere konkurrence?)");
        case 3 -> System.out.println("Metode til at oprette en ny Konkurrence - to be implemented");
        case 4 -> createNewTraining();
        case 5 -> uiCoach.printAllCompetitors(memberList.getAllCompetitors());
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

}


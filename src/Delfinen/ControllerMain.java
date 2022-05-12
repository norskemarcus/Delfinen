package Delfinen;

public class ControllerMain {
  private ControllerChairman cChairman = new ControllerChairman();
  private ControllerTreasurer cTreasurer = new ControllerTreasurer();
  private ControllerCoach cCoach = new ControllerCoach();
  private UIMain uiMain = new UIMain();
  private boolean running = true;


  public void run() {
    mainMenu();
  }

  private void mainMenu() {


    while (running) {

      uiMain.mainMenuPrint();
      int userChoice = uiMain.inputNumber();

      switch (userChoice) {
        case 1 -> cChairman.menuChairman();
        case 2 -> cTreasurer.menuKasserer();
        case 3 -> cCoach.menuCoach();
        case 4 -> exit();
        default -> uiMain.errorMessage();
      }

    }
  }

  public void exit(){
    running = false;
  }
}

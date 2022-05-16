package Delfinen;

import Delfinen.Chairman.ControllerChairman;
import Delfinen.Coach.ControllerCoach;
import Delfinen.Treasurer.ControllerTreasurer;

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

      uiMain.printMenuOptions();
      int userChoice = uiMain.inputNumber();

      switch (userChoice) {
        case 1 -> cChairman.menuChairman();
        case 2 -> cTreasurer.menuTreasurer();
        case 3 -> cCoach.menuCoach();
        case 0 -> exit();
        default -> uiMain.printErrorMessage();
      }

    }
  }

  public void exit(){
    running = false;
  }
}

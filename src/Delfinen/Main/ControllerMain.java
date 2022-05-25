package Delfinen.Main;

import Delfinen.Chairman.ControllerChairman;
import Delfinen.Coach.ControllerCoach;
import Delfinen.Treasurer.ControllerTreasurer;

public class ControllerMain {
  private final ControllerChairman cChairman = new ControllerChairman();
  private final ControllerTreasurer cTreasurer = new ControllerTreasurer();
  private final ControllerCoach cCoach = new ControllerCoach();
  private final UIMain uiMain = new UIMain ();
  private boolean running = true;


  public void run() {
    mainMenu();
  }

  private void mainMenu() {


    while (running) {

      uiMain.printMenuOptions();
      int userChoice = uiMain.inputNumber();

      switch (userChoice) {
        case 1 -> cChairman.loadAndThenRunMain();
        case 2 -> cTreasurer.loadAndThenRunMain();
        case 3 -> cCoach.loadAndThenRunMain();
        case 0 -> exit();
        default -> uiMain.printErrorMessage();
      }

    }
  }



  public void exit(){
    running = false;
  }
}

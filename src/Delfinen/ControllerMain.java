package Delfinen;

public class ControllerMain {
  private ControllerChairman cf = new ControllerChairman();
  private ControllerCashier ck = new ControllerCashier();
  private ControllerCoach ct = new ControllerCoach();
  private UI ui = new UI();

  public void run() {
    mainMenu();
  }

  private void mainMenu() {
    ui.mainMenuPrint();
    int test = ui.inputNumber();

    switch (test) {
      case 1 -> cf.menuChairman();
      case 2 -> ck.menuKasserer();
      case 3 -> ct.menuCoach();
      case 4 -> exit();
    }

  }

  public void exit(){ //Anden Klasse?
    System.exit(0);
  }
}

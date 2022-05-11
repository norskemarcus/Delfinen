package Delfinen;

public class ControllerMain {
  private ControllerChairman cf = new ControllerChairman();
  private UI ui = new UI();

  public void run() {
    mainMenu();
  }

  private void mainMenu() {
    ui.mainMenuPrint();
    switch (3) {
      case 1 -> cf.menuChairman();
      case 2 -> cf.menuChairman();
    }
  }
}

package Delfinen;

public class MainController {
  private ControllerChairman cf = new ControllerChairman();

  public void run() {
    mainMenu();
  }

  private void mainMenu() {
    switch (1) {
      case 1 -> cf.menuChairman();
    }
  }
}

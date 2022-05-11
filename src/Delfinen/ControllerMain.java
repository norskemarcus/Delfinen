package Delfinen;

public class ControllerMain {
  private ControllerChairman cf = new ControllerChairman();
  private ControllerCashier ck = new ControllerCashier();
  private ControllerCoach ct = new ControllerCoach();
  private UI ui = new UI();

  public void run() {
    mainMenu();
  }

  private void mainMenu() { //TODO: har lige lavet den public - skal den skiftes tilbage til private?

    boolean running = true;

    while (running) {

      ui.mainMenuPrint();
      int test = ui.inputNumber(); //Er træt - kan dette laves smartere? Nyt navn i stedet for test uanset

      switch (test) {
        case 1 -> cf.menuChairman();
        case 2 -> ck.menuKasserer();
        case 3 -> ct.menuCoach();
        case 4 -> exit();
        default -> ui.errorMessage();
      }

    }
  }

  public void exit(){ //Anden Klasse?
    System.exit(0);
  }
}

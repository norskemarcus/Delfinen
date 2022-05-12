package Delfinen;

public class ControllerCoach {
  private UICoach uiCoach = new UICoach();
  public void menuCoach() {
    boolean running = true;

    while (running) {

      uiCoach.printHeader();
      uiCoach.printMenuOptions();


      switch (uiCoach.inputNumber()) {
        case 1 -> System.out.println("Metode til top 5 junior"); //Skal være metoder til UI
        case 2 -> System.out.println("Metod til top 5 senior");
        case 3 -> running = false;
        default -> uiCoach.printErrorMessage();
      }
    }
  }
  }


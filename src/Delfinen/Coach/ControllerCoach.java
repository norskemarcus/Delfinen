package Delfinen.Coach;

public class ControllerCoach {
  private UICoach uiCoach = new UICoach();
  public void menuCoach() {
    boolean running = true;

    while (running) {

      uiCoach.printHeader();
      uiCoach.printMenuOptions();


      switch (uiCoach.inputNumber()) {
        case 1 -> System.out.println("Metode til top 5 junior - to be implemented"); //Skal være metoder til UI
        case 2 -> System.out.println("Metod til top 5 senior - to be implemented");
        case 3 -> System.out.println("Opret nyt stævne - to be implemented");
        case 4 -> running = false;
        default -> uiCoach.printErrorMessage();
      }
    }
  }
  }


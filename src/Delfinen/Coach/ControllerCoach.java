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
        case 2 -> System.out.println("Metode til top 5 senior - to be implemented");
        case 3 -> System.out.println("Metode til at oprette et nyt stævne - to be implemented");
        case 4 -> running = false;
        case 0 -> running = false; //TODO: skal noget gemmes i liste?
        default -> uiCoach.printErrorMessage();
      }
    }
  }
  }


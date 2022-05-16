package Delfinen.Coach;

public class ControllerCoach {

  private UICoach uiCoach = new UICoach();
  private boolean running = true;

  public void menuCoach() {

    while (running) {

      uiCoach.printHeader();
      uiCoach.printMenuOptions();

      switch (uiCoach.inputNumber()) {
        case 1 -> System.out.println("Metode til top 5 junior - to be implemented"); //Skal være metoder til UI
        case 2 -> System.out.println("Metode til top 5 senior - to be implemented");
        case 3 -> System.out.println("Metode til at oprette et nyt stævne - to be implemented");
        case 4 -> System.out.println("Metode til at oprette en ny træning - to be implemented");
        case 5 -> running = false;
        case 0 -> exit(); //TODO: skal noget gemmes i liste?
        default -> uiCoach.printErrorMessage();
      }
    }
  }

  public void exit(){
    running = false;
  }
}


package Delfinen.Chairman;

import Delfinen.Member.*;
import Delfinen.Persistence.FileHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerChairman {
  private final UIChairman uiChairman = new UIChairman();
  private final MemberList memberLists = new MemberList();
  private final FileHandler fileHandler = new FileHandler();
  private boolean running = true;
  private Integer memberNumber;

  public void loadAndThenRunMain() {
    memberNumber = fileHandler.loadMemberNumber();
    memberLists.setAllNonCompetitors(fileHandler.loadNonCompetitors());
    memberLists.setAllCompetitors(fileHandler.loadCompetitors());
    menuChairman();
  }

  private void menuChairman() {

    running = true;

    while (running) {

      uiChairman.printHeader();
      uiChairman.printMenuOptions();

      switch (uiChairman.inputNumber()) {
        case 1 -> addMemberMenu();
        case 2 -> searchForMember();
        case 3 -> showMembers();
        case 4 -> editMembers();
        case 5 -> deleteMember();
        case 0 -> saveAndReturnToMainMenu();
        default -> errorMessage();
      }
    }
  }


  private void addMemberMenu() {

    boolean runningAddMember = true;

    while (runningAddMember) {
      System.out.println(""); //TODO: Test om det virker - marcus
      uiChairman.printMemberMenu();

      switch (uiChairman.inputNumber()) {
        case 1 -> addNonCompetitorMember();
        case 2 -> addCompetitorMember();
        case 0 -> runningAddMember = false;
        default -> errorMessage();
      }
    }
  }


  private void errorMessage() {
    uiChairman.printErrorMessage();
  }

  //Kald metode fra member/memberlist-klasse via nedenstående metoder:

  private void saveAndReturnToMainMenu() {
    FileHandler fileHandler = new FileHandler();
    fileHandler.saveAllNonCompetitorsToFile(memberLists.getAllNonCompetitors());
    fileHandler.saveAllCompetitorsToFile(memberLists.getAllCompetitors());
    fileHandler.saveMemberNumberToFile(memberNumber);
    running = false;
  }

  private void editMembers() {
    editEmail();
  }

  public void editEmail() {
    boolean editEmailIsRunning = true;
    int answer = -1;
    while (editEmailIsRunning && answer != 0) {
      answer = uiChairman.inputMembernumber();
      Member member = memberLists.findSpecifikMemberByMemberNumber(answer);
      if (member != null) {
        String areYouSure = "";
        while (!areYouSure.equals("j") && !areYouSure.equals("n")) {
          areYouSure = uiChairman.confirmEditEmail(member.getName());

          if (areYouSure.equals("j")) {
            if (member instanceof Competitor) {
              member.setEmail(uiChairman.newMail()); //TODO: ekstra feauture at tjekke om en mail allerede findes?
            } else {
              member.setEmail(uiChairman.newMail());
            }
            uiChairman.printInfoOfEditMail(member.getName(), member.getEmail());
            editEmailIsRunning = false;
          } else if (areYouSure.equals("n")) {
            uiChairman.noEmailHasBeenChanged();
            editEmailIsRunning = false;
          }
        }
      }
    }
  }


  private void showMembers() {
    uiChairman.printAllMembers(memberLists.getAllNonCompetitors(), memberLists.getAllCompetitors());
  }

  private void searchForMember() {
    boolean running = true;

    while (running) {
      uiChairman.searchMemberOptions();
      int number = uiChairman.inputNumber();
      switch (number) {
        case 1 -> searchMembersByString("e-mail");
        case 2 -> searchMembersByString("navn");
        case 3 -> searchMembersByMemberNumber();
        case 4 -> running = false;
      }
    }
  }


  private void searchMembersByString(String descriptionWord) {
    ArrayList<Member> foundMembers;
    String memberDescription = uiChairman.inputStringOfSearchCriteria(descriptionWord);

    if (descriptionWord.equals("e-mail")) {
      foundMembers = memberLists.findSpecifikMembersByEmail(memberDescription.toLowerCase());
    } else {
      foundMembers = memberLists.findSpecifikMembersByName(memberDescription.toLowerCase());
    }
    uiChairman.printFoundMembersBySearch(foundMembers);
  }

  private void searchMembersByMemberNumber() {

    int memberNumber = uiChairman.inputMembernumber();
    Member foundMember = memberLists.findSpecifikMemberByMemberNumber(memberNumber);
    uiChairman.printMemberFoundByMembernumber(foundMember);
  }

  public void deleteMember() {

    boolean runningDeleteMember = true;
    int answer = -1;

    while (runningDeleteMember && answer != 0) {
      System.out.println("0 for at gå tilbage til menuen..."); // TODO: Skal slettes, når gruppen har set det
      answer = uiChairman.inputMembernumber();
      Member member = memberLists.findSpecifikMemberByMemberNumber(answer);

      if (member != null) {
        String areYouSure = "";
        while (!areYouSure.equals("j") && !areYouSure.equals("n")) {
          areYouSure = uiChairman.confirmMemberDeletion(member.getName());

          if (areYouSure.equals("j")) {
            if (member instanceof Competitor) {
              memberLists.getAllCompetitors().remove(member);
            } else {
              memberLists.getAllNonCompetitors().remove(member);
            }
            uiChairman.printInfoOfDeletedMember(member.getName(), member.getMemberNumber());
            runningDeleteMember = false;
          } else if (areYouSure.equals("n")) {
            uiChairman.noMemberHasBeenDeleted();
            runningDeleteMember = false;
          }
        }
      }
    }
  }


  // motionssvømmer
  public void addNonCompetitorMember() {
    NonCompetitor newNonCompetitorMember = uiChairman.addNonCompetitorMember(memberNumber);
    memberLists.getAllNonCompetitors().add(newNonCompetitorMember);
    membershipCounter();
  }

  private void membershipCounter() {
    memberNumber++;
  }

  //konkurrencesvømmer
  public void addCompetitorMember() {
    Competitor newCompetitorMember = uiChairman.addCompetitorMember(memberNumber);
    memberLists.getAllCompetitors().add(newCompetitorMember);
    membershipCounter();
  }

  public void changeMemberToCompetitor(NonCompetitor nonCompetitor) {
    //Competitor(String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender)
    // Finde objektet ved at søge på medlemsnummer?
    String name = nonCompetitor.getName();
    Integer memberNumber = nonCompetitor.getMemberNumber();
    Integer age = nonCompetitor.getAge();
    String email = nonCompetitor.getEmail();
    boolean isMembershipPaid = nonCompetitor.isMembershipPaid();
    String gender = uiChairman.addGenderToNewCompetitor();
    SwimmingDisciplins swimmingDisciplin = null; //TODO coach skal gøre dette?

    Competitor competitor = new Competitor(name, memberNumber, age, email, isMembershipPaid, gender, swimmingDisciplin);
    memberLists.getAllCompetitors().add(competitor);
    //TODO: remove nonCompetitor from the other memberlist

  }

  public MemberList getMemberLists() {
    return memberLists;
  }
}

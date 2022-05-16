package Delfinen.Chairman;

import Delfinen.Member.Competitor;
import Delfinen.Member.Member;
import Delfinen.Member.MemberList;
import Delfinen.Member.NonCompetitor;
import Delfinen.Persistence.FileHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerChairman {
  private final UIChairman uiChairman = new UIChairman();
  private final MemberList memberLists = new MemberList();
  private final FileHandler fileHandler = new FileHandler();
  private boolean running = true;
  private Integer memberNumber;

  public void menuChairman() {

    memberNumber = fileHandler.loadMemberNumber();

    running = true;

    while (running) {

      uiChairman.printHeader();
      uiChairman.printMenuOptions();

      switch (uiChairman.inputNumber()) {
        case 1 -> addNonCompetitorMember(); //TODO: Dele op
        case 2 -> addCompetitorMember();
        case 3 -> searchForMember();
        case 4 -> showMembers();
        case 5 -> editMembers(); //TODO: Er det formanden som skal ændre en motionssvømmer til konkurrencesvømmer eller træneren? Ind i egen menu ind under editMembers()
        case 6 -> deleteMember();
        case 0 -> saveAndReturnToMainMenu();
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

  public void editEmail(){

    System.out.println("Indtast mail der skal ændres");
    Scanner input = new Scanner(System.in);
    String answer = input.nextLine();
    System.out.println("Indtast den nye mail"); //TODO: Skal der checkes om det er en @ i Stringen?
    String newMail = input.nextLine();


    for(Member customer : getMemberLists().getAllCompetitors()) {
      if(customer!=null && answer.equals(customer.getEmail())) {
        customer.setEmail(newMail);
        System.out.println("Mail er blevet ændret for " + customer.getName() + " til " + customer.getEmail());
        break;
      }
    }

    for(Member customer : getMemberLists().getAllNonCompetitors()) {
      if(customer!=null && answer.equals(customer.getEmail())) {
        customer.setEmail(newMail);
        System.out.println("Mail er blevet ændret for " + customer.getName() + " til " + customer.getEmail());
        break;
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

      System.out.println("Indtast medlemsnummer på det medlem, der ønskes slettet");
      Scanner input = new Scanner(System.in);
      int answer = input.nextInt();

      for(Member customer : getMemberLists().getAllCompetitors()) {
        if(customer!=null && answer == customer.getMemberNumber()) {
          memberLists.getAllCompetitors().remove(customer);
          System.out.println("Medlem " + customer.getName() + " : " + customer.getMemberNumber() + " er blevet slettet fra systemet");
          break;
        }
      }

      for(Member customer : getMemberLists().getAllNonCompetitors()) {
        if(customer!=null && answer == customer.getMemberNumber()) {
          memberLists.getAllNonCompetitors().remove(customer);
          System.out.println("Medlem " + customer.getName() + " : " + customer.getMemberNumber() + " er blevet slettet fra systemet");
          break;
        }
      }

    }

  

  // motionssvømmer
  public void addNonCompetitorMember() {
    NonCompetitor newNonCompetitorMember = uiChairman.addNonCompetitorMember(memberNumber);
    memberLists.getAllNonCompetitors().add(newNonCompetitorMember);
    membershipCounter();
  }

  private void membershipCounter(){
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

    Competitor competitor = new Competitor(name, memberNumber, age, email, isMembershipPaid, gender);
    memberLists.getAllCompetitors().add(competitor);
    //TODO: remove nonCompetitor from the other memberlist

  }

  public MemberList getMemberLists() {
    return memberLists;
  }
}

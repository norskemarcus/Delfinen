package Delfinen.Persistence;

import Delfinen.Member.Competitor; //TODO: Peter?
import Delfinen.Member.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileHandler {

  public void saveAllNonCompetitorsToFile(ArrayList<Member> listOfNonCompetitors)  {

    try{
      PrintStream out = new PrintStream(new File("medlemsliste_motionist.csv"));

      for (Member member: listOfNonCompetitors) {
        out.print(member.getName());
        out.print(";");
        out.print(member.getMemberNumber());
        out.print(";");
        out.print(member.getAge());
        out.print(";");
        out.print(member.getEmail());
        out.print(";");
        out.print(member.isMembershipPaid());
        out.print("\n");
      }

    } catch (FileNotFoundException fnfe){
      System.err.println("Fil ikke fundet");
    }
  }


  public void saveAllCompetitorsToFile(ArrayList<Competitor> listOfCompetitors)  {

    try{
      PrintStream out = new PrintStream(new File("medlemsliste_konkurrencesvømmer.csv"));

      for (Competitor competitor: listOfCompetitors) {
        out.print(competitor.getName());
        out.print(";");
        out.print(competitor.getMemberNumber());
        out.print(";");
        out.print(competitor.getGender());
        out.print(";");
        out.print(competitor.getAge());
        out.print(";");
        out.print(competitor.getEmail());
        out.print(";");
        out.print(competitor.isMembershipPaid());
        out.print("\n");
      }

    } catch (FileNotFoundException fnfe){
      System.err.println("Fil ikke fundet");
    }



  }


}

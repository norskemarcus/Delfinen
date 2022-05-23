package Delfinen.Member;

import java.util.ArrayList;

public class MemberList {

  private ArrayList<NonCompetitor> allNonCompetitors;
  private ArrayList<Competitor> allCompetitors;

  public MemberList() {
    allNonCompetitors = new ArrayList<>();
    allCompetitors = new ArrayList<>();
  }

  public ArrayList<Member> findSpecifikMembersByEmail(String memberEmail) {

    ArrayList<Member> foundMembers = new ArrayList<>();

    for (Member member : allNonCompetitors) {
      if (member.getEmail().toLowerCase().contains(memberEmail)) {
        foundMembers.add(member);
      }
    }
    for (Member member : allCompetitors) {
      if (member.getEmail().toLowerCase().contains(memberEmail)) {
        foundMembers.add(member);
      }
    }
    return foundMembers;
  }

  public ArrayList<Member> findSpecifikMembersByName(String memberName) {
    ArrayList<Member> foundMembers = new ArrayList<>();

    for (Member member : allNonCompetitors) {
      if (member.getName().toLowerCase().contains(memberName)) {
        foundMembers.add(member);
      }
    }
    for (Member member : allCompetitors) {
      if (member.getName().toLowerCase().contains(memberName)) {
        foundMembers.add(member);
      }
    }
    return foundMembers;
  }

  public Member findSpecifikMemberByMemberNumber(int memberNumber) {

    for (Delfinen.Member.Member member : allNonCompetitors) {
      if (member.getMemberNumber() == memberNumber) {
        return member;
      }
    }
    for (Delfinen.Member.Member member : allCompetitors) {
      if (member.getMemberNumber() == memberNumber) {
        return member;
      }
    }
    return null;
  }

  public Competitor findSpecifikCompetitorByMemberNumber(int memberNumber) {

    for (Competitor competitor : allCompetitors) {
      if (competitor.getMemberNumber() == memberNumber) {
        return competitor;
      }
    }
    return null;
  }

  public ArrayList<NonCompetitor> getAllNonCompetitors() {
    return allNonCompetitors;
  }

  public ArrayList<Competitor> getAllCompetitors() {
    return allCompetitors;
  }

  public void setAllNonCompetitors (ArrayList<NonCompetitor> theNewListOfNonCompetitors) {
    this.allNonCompetitors = theNewListOfNonCompetitors;
  }

  public void setAllCompetitors (ArrayList<Competitor> theNewListOfCompetitors) {
    this.allCompetitors = theNewListOfCompetitors;
  }

  public ArrayList<Competitor> createTop5ListTraining(String gender, SwimmingDisciplin swimmingDisciplin, Integer age){
    ArrayList<Competitor> top5Training = new ArrayList<>();

    for (int i = 0; i < allCompetitors.size();i++) {
      Competitor temp = allCompetitors.get(i);
      boolean isCorrectAge = temp.getAge() >= 18;

      if (age < 18){
        isCorrectAge = temp.getAge() < 18;
      }

      SwimmingDisciplin disciplin = temp.getSwimmingDisciplin();

      if(temp.getGender().equals(gender) && disciplin.equals(swimmingDisciplin) && isCorrectAge){
        top5Training.add(temp);
      }
      if(top5Training.size() == 5){
        i = allCompetitors.size();

      }
    }
    return top5Training;
  }

}

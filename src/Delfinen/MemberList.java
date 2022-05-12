package Delfinen;

import java.util.ArrayList;

public class MemberList {

  private ArrayList<Member> allNonCompetitors;
  private ArrayList<Competitor> allCompetitors;

  public MemberList(){
    allNonCompetitors = new ArrayList<>();
    allCompetitors = new ArrayList<>();
  }

  public Member findSpecifikMember(String memberEmail) {

    for (Member member: allNonCompetitors) {
      if(member.getEmail().equals(memberEmail)){
        return member;
      }
    }
    return null;
  }

  public ArrayList<Member> getAllNonCompetitors() {
    return allNonCompetitors;
  }

  public ArrayList<Competitor> getAllCompetitors() {
    return allCompetitors;
  }
}

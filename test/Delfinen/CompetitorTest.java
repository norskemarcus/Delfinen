package Delfinen;

//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CompetitorTest {

  @Test
  void createNewMember(){
    //arrange
    Competitor sebastian = new Competitor("Sebastian", 20220001, 19, "seb@gmail.com", true, "M");
    MemberList memberList = new MemberList();
    //act
    memberList.getAllMembers().add(sebastian);
    memberList.getAllCompetitors().add(sebastian);
    //assert
    assertTrue(memberList.getAllMembers().size() == 1);
    assertTrue(memberList.getAllCompetitors().size() == 1);

  }

}
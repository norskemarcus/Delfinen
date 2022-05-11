package Delfinen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerChairmanTest {

  @Test
  void testSearchMemberIsNull(){
    //arrange
    Competitor sebastian = new Competitor("Sebastian", 20220001, 19, "seb@gmail.com", true, "M");
    MemberList memberList = new MemberList();
    //act
    memberList.getAllMembers().add(sebastian);
    memberList.getAllCompetitors().add(sebastian);
    //assert
    Member testMember = memberList.findSpecifikMember("test");
    assertNull(testMember);
  }

  @Test
  void testSearchMemberIsFound(){
    //arrange
    Competitor sebastian = new Competitor("Sebastian", 20220001, 19, "seb@gmail.com", true, "M");
    MemberList memberList = new MemberList();
    //act
    memberList.getAllMembers().add(sebastian);
    memberList.getAllCompetitors().add(sebastian);
    //assert
    Member testMember = memberList.findSpecifikMember("seb@gmail.com");
    assertSame(sebastian,testMember);
  }
}
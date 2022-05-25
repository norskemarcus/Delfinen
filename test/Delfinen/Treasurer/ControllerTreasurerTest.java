package Delfinen.Treasurer;

import Delfinen.Member.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTreasurerTest {

  @Test
  void testUnder18() {
    // Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Daniel", 1009, -1, "dan@iel.dk", true, true);

    // Act
    double expected = 1000;
    double actual = controllerTreasurer.calculateMembershipCost(nonCompetitor);

    // Assert
    assertEquals(expected,actual);
  }

  @Test
  void testAdult() {
    // Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Daniel", 1009, 20, "dan@iel.dk", true, true);

    // Act
    double expected = 1600;
    double actual = controllerTreasurer.calculateMembershipCost(nonCompetitor);

    // Assert
    assertEquals(expected,actual);
  }

  @Test
  void testInactive() {
    // Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Daniel", 1009, 20, "dan@iel.dk", true, false);

    // Act
    double expected = 500;
    double actual = controllerTreasurer.calculateMembershipCost(nonCompetitor);

    // Assert
    assertEquals(expected,actual);
  }

  @Test
  void testCompetitor() {
    // Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    Competitor competitor = new Competitor("Daniel", 1009, 20, "dan@iel.dk", true, "M", SwimmingDisciplin.CRAWL, new BestResultTraining(0,0,0,0), new BestResultCompetition(0,0,0,0));

    // Act
    double expected = 1600;
    double actual = controllerTreasurer.calculateMembershipCost(competitor);

    // Assert
    assertEquals(expected,actual);
  }

  @Test
  void testSenior() {
    // Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Daniel", 1009, 65, "dan@iel.dk", true, true);

    // Act
    double expected = 1200;
    double actual = controllerTreasurer.calculateMembershipCost(nonCompetitor);

    // Assert
    assertEquals(expected,actual,01);
  }

  @Test
  void testAgeNegative() {
    //Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Marcus", 1100, -1,"marcus@norge.dk",true, true);


    //Act/assert
    assertThrows(IllegalArgumentException.class,()->controllerTreasurer.calculateMembershipCost(nonCompetitor));

  }

  @Test
  void testAgeTooHigh() {
    //Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Marcus", 1100, 114,"marcus@norge.dk",true, true);


    //Act/assert
    assertThrows(IllegalArgumentException.class,()->controllerTreasurer.calculateMembershipCost(nonCompetitor));

  }

}
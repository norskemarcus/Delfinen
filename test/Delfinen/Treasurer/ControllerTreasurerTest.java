package Delfinen.Treasurer;

import Delfinen.Member.Competitor;
import Delfinen.Member.NonCompetitor;
import Delfinen.Member.SwimmingDisciplins;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTreasurerTest {

  @Test
  void testUnder18() {
    // Arrange
    ControllerTreasurer controllerTreasurer = new ControllerTreasurer();
    NonCompetitor nonCompetitor = new NonCompetitor("Daniel", 1009, 17, "dan@iel.dk", true, true);

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
    Competitor competitor = new Competitor("Daniel", 1009, 20, "dan@iel.dk", true, "M", SwimmingDisciplins.CRAWL,null,null,null,null);

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

}
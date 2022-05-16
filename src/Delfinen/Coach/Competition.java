package Delfinen.Coach;

public class Competition extends Activity {
  private int place;
  private String nameTournament;

  public Competition(int resultMin, int resultSec, String disciplin, int place, String nameTournament) {
    super(resultMin, resultSec, disciplin);
    this.place = place;
    this.nameTournament = nameTournament;
  }
}

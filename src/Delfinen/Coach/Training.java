package Delfinen.Coach;

import java.sql.Time;

public class Training extends Activity{

  private Time date;

  public Training(int resultMin, int resultSec, String disciplin, Time date) {
    super(resultMin, resultSec, disciplin);
    this.date = date;
  }
}

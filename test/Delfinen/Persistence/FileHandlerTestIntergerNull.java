package Delfinen.Persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTestIntergerNull {
  @Test
  public void testNullInteger(){
    Integer testInt = null;
    Integer testInt2 = Integer.parseInt("1");

    assertNull(testInt2);
  }



}
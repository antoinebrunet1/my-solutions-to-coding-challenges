package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZigzagConversionTest {
  @Test
  public void example1() {
    String s = "PAYPALISHIRING";
    int numRows = 3;
    String expectedResult = "PAHNAPLSIIGYIR";
    String actualResult = ZigzagConversion.zigzagConversion(s, numRows);

    Assertions.assertEquals(expectedResult, actualResult);
  }
}

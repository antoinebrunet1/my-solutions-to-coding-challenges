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

  @Test
  public void example2() {
    String s = "PAYPALISHIRING";
    int numRows = 4;
    String expectedResult = "PINALSIGYAHRPI";
    String actualResult = ZigzagConversion.zigzagConversion(s, numRows);

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void example3() {
    String s = "A";
    int numRows = 1;
    String expectedResult = "A";
    String actualResult = ZigzagConversion.zigzagConversion(s, numRows);

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void numRowsEquals2() {
    String s = "ABCD";
    int numRows = 2;
    String expectedResult = "ACBD";
    String actualResult = ZigzagConversion.zigzagConversion(s, numRows);

    Assertions.assertEquals(expectedResult, actualResult);
  }
}

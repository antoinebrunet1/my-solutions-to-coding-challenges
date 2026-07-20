package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
  @Test
  public void example1() {
    int[] nums = {2,7,11,15};
    int target = 9;
    int[] expectedResult = {0, 1};
    int[] actualResult = TwoSum.twoSum(nums, target);

    assertArrayEquals(expectedResult, actualResult);
  }
}

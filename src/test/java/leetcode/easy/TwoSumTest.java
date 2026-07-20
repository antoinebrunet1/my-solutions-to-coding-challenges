package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
  @Test
  public void example1() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] expectedResult = {0, 1};
    int[] actualResult = TwoSum.twoSum(nums, target);

    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void example2() {
    int[] nums = {3, 2, 4};
    int target = 6;
    int[] expectedResult = {1, 2};
    int[] actualResult = TwoSum.twoSum(nums, target);

    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void example3() {
    int[] nums = {3, 3};
    int target = 6;
    int[] expectedResult = {0, 1};
    int[] actualResult = TwoSum.twoSum(nums, target);

    assertArrayEquals(expectedResult, actualResult);
  }
}

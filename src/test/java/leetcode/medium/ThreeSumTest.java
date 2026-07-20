package leetcode.medium;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {
  private void test(int[] nums, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = ThreeSum.threeSum(nums);

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void example1() {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> expectedResult = List.of(
        List.of(-1, -1, 2),
        List.of(-1, 0, 1)
    );

    test(nums, expectedResult);
  }

  @Test
  public void example2() {
    int[] nums = {0, 0, 1};
    List<List<Integer>> expectedResult = List.of();

    test(nums, expectedResult);
  }
}

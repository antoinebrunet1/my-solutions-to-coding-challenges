package leetcode.medium;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapNodesInPairsTest {
  private void test(int[] input, int[] expectedResultArray) {
    ListNode expectedResult = ListNode.getHead(expectedResultArray);
    ListNode actualResult = SwapNodesInPairs.swapPairs(ListNode.getHead(input));

    Assertions.assertTrue(ListNode.listsAreEqual(expectedResult, actualResult));
  }

  @Test
  public void example1() {
    int[] input = new int[] {1, 2, 3, 4};
    int[] expectedResultArray = new int[] {2, 1, 4, 3};

    test(input, expectedResultArray);
  }
}

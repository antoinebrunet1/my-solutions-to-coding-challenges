package leetcode.medium;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveNthFromEndTest {
  private void test(int[] input, int n, int[] expectedResultArray) {
    ListNode expectedResult = ListNode.getHead(expectedResultArray);
    ListNode actualResult = new RemoveNthFromEnd().removeNthFromEnd(ListNode.getHead(input), n);

    Assertions.assertTrue(ListNode.listsAreEqual(expectedResult, actualResult));
  }

  @Test
  public void example1() {
    int[] input = new int[] {1, 2, 3, 4, 5};
    int n = 2;
    int[] expectedResultArray = new int[] {1, 2, 3, 5};

    test(input, n, expectedResultArray);
  }

  @Test
  public void example2() {
    int[] input = new int[] {1};
    int n = 1;
    int[] expectedResultArray = new int[] {};

    test(input, n, expectedResultArray);
  }

  @Test
  public void example3() {
    int[] input = new int[] {1, 2};
    int n = 1;
    int[] expectedResultArray = new int[] {1};

    test(input, n, expectedResultArray);
  }
}

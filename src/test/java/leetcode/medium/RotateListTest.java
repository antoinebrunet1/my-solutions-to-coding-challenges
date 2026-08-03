package leetcode.medium;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateListTest {
  private void test(int[] head, int k, int[] expected) {
    ListNode actual = RotateList.rotateRight(ListNode.getHead(head), k);

    Assertions.assertTrue(ListNode.listsAreEqual(ListNode.getHead(expected), actual));
  }

  @Test
  public void example1() {
    int[] head = {1, 2, 3, 4, 5};
    int k = 2;
    int[] expected = {4, 5, 1, 2, 3};
  }

  @Test
  public void example2() {
    int[] head = {0, 1, 2};
    int k = 4;
    int[] expected = {2, 0, 1};
  }
}

package leetcode.hard;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseNodesInKGroupTest {
  private void test(int[] head, int k, int[] expected) {
    ListNode actual = ReverseNodesInKGroup.reverseKGroup(ListNode.getHead(head), k);

    Assertions.assertTrue(ListNode.listsAreEqual(ListNode.getHead(expected), actual));
  }

  @Test
  public void example1() {
    int[] head = new int[] {1, 2, 3, 4, 5};
    int k = 2;
    int[] expected = new int[] {2, 1, 4, 3, 5};

    test(head, k, expected);
  }

  @Test
  public void example2() {
    int[] head = new int[] {1, 2, 3, 4, 5};
    int k = 3;
    int[] expected = new int[] {3, 2, 1, 4, 5};

    test(head, k, expected);
  }
}

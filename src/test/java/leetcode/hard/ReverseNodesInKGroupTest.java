package leetcode.hard;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseNodesInKGroupTest {
  @Test
  public void example1() {
    ListNode head = ListNode.getHead(new int[] {1, 2, 3, 4, 5});
    int k = 2;
    ListNode expected = ListNode.getHead(new int[] {2, 1, 4, 3, 5});
    ListNode actual = ReverseNodesInKGroup.reverseKGroup(head, k);

    Assertions.assertTrue(ListNode.listsAreEqual(expected, actual));
  }
}

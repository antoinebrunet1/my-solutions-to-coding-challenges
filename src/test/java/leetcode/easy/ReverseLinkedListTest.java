package leetcode.easy;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {
  private void test(int[] head, int[] expected) {
    ListNode actual = ReverseLinkedList.reverseListIteratively(ListNode.getHead(head));

    Assertions.assertTrue(ListNode.listsAreEqual(ListNode.getHead(expected), actual));
  }

  @Test
  public void example1Iteratively() {
    int[] head = {1, 2, 3, 4, 5};
    int[] expected = {5, 4, 3, 2, 1};

    test(head, expected);
  }
}

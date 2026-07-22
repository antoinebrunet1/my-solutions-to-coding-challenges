package leetcode.medium;

import org.junit.jupiter.api.Test;

public class RemoveNthFromEndTest {
  private RemoveNthFromEnd.ListNode getHead(int[] list) {
    RemoveNthFromEnd.ListNode head = new RemoveNthFromEnd.ListNode(list[0]);
    RemoveNthFromEnd.ListNode previousNode = head;

    for (int i = 1; i < list.length; i++) {
      previousNode.next = new RemoveNthFromEnd.ListNode(list[i]);
      previousNode = previousNode.next;
    }

    return head;
  }

  private void test(int list[], int n) {
    new RemoveNthFromEnd().removeNthFromEnd(getHead(list), n);
  }

  @Test
  public void example1() {
    int[] list = new int[] {1, 2, 3, 4, 5};
    int n = 2;

    test(list, n);
  }
}

package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveNthFromEndTest {
  private RemoveNthFromEnd.ListNode getHead(int[] list) {
    if (list.length == 0) {
      return null;
    }

    RemoveNthFromEnd.ListNode head = new RemoveNthFromEnd.ListNode(list[0]);
    RemoveNthFromEnd.ListNode previousNode = head;

    for (int i = 1; i < list.length; i++) {
      previousNode.next = new RemoveNthFromEnd.ListNode(list[i]);
      previousNode = previousNode.next;
    }

    return head;
  }

  private boolean listsAreEqual(RemoveNthFromEnd.ListNode head1, RemoveNthFromEnd.ListNode head2) {
    if (head1 == null && head2 == null) {
      return true;
    }

    if (head1 == null || head2 == null) {
      return false;
    }

    RemoveNthFromEnd.ListNode currentNodeOfList1 = head1;
    RemoveNthFromEnd.ListNode currentNodeOfList2 = head2;

    while (!(currentNodeOfList1 == null && currentNodeOfList2 == null)) {
      if (currentNodeOfList1 == null || currentNodeOfList2 == null) {
        return false;
      }

      if (currentNodeOfList1.val != currentNodeOfList2.val) {
        return false;
      }

      currentNodeOfList1 = currentNodeOfList1.next;
      currentNodeOfList2 = currentNodeOfList2.next;
    }

    return true;
  }

  private void test(int[] input, int n, int[] expectedResultArray) {
    RemoveNthFromEnd.ListNode expectedResult = getHead(expectedResultArray);
    RemoveNthFromEnd.ListNode actualResult = new RemoveNthFromEnd().removeNthFromEnd(getHead(input), n);

    Assertions.assertTrue(listsAreEqual(expectedResult, actualResult));
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

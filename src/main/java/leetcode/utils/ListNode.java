package leetcode.utils;

// Definition for singly-linked list.
public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode getHead(int[] list) {
    if (list.length == 0) {
      return null;
    }

    ListNode head = new ListNode(list[0]);
    ListNode previousNode = head;

    for (int i = 1; i < list.length; i++) {
      previousNode.next = new ListNode(list[i]);
      previousNode = previousNode.next;
    }

    return head;
  }

  public static boolean listsAreEqual(ListNode head1, ListNode head2) {
    if (head1 == null && head2 == null) {
      return true;
    }

    if (head1 == null || head2 == null) {
      return false;
    }

    ListNode currentNodeOfList1 = head1;
    ListNode currentNodeOfList2 = head2;

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
}

package leetcode.easy;

import leetcode.utils.ListNode;

public class ReverseLinkedList {
  // Source: https://leetcode.com/problems/reverse-linked-list/description/?envType=problem-list-v2&envId=linked-list
  // Time complexity: O(n)
  // Space complexity: O(1)
  public static ListNode reverseListIteratively(ListNode head) {
    // If the list is empty or has only one element
    if (head == null || head.next == null) {
      return head;
    }

    ListNode node1InCurrentPair = head;
    ListNode node2InCurrentPair = head.next;

    do {
      ListNode futureNode2InCurrentPair = node2InCurrentPair.next;
      node2InCurrentPair.next = node1InCurrentPair; // A <- B

      if (node1InCurrentPair.equals(head)) {
        node1InCurrentPair.next = null;
      }

      node1InCurrentPair = node2InCurrentPair;
      node2InCurrentPair = futureNode2InCurrentPair;
    } while (node2InCurrentPair != null);

    return node1InCurrentPair;
  }
}

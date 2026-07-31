package leetcode.medium;

import leetcode.utils.ListNode;

public class SwapNodesInPairs {
  public static ListNode swapPairs(ListNode head) {
    // If head = []
    if (head == null) {
      return null;
    }

    // If head has only one element
    if (head.next == null) {
      return head;
    }

    ListNode node1InPair = head;
    ListNode node2InPair = head.next;
    ListNode result = node2InPair;

    while (true) {
      swapPair(node1InPair, node2InPair);

      ListNode oldNode1InPair = node1InPair;
      node1InPair = node1InPair.next;

      if (node1InPair == null) {
        break;
      }

      node2InPair = node1InPair.next;

      if (node2InPair == null) {
        break;
      }

      oldNode1InPair.next = node2InPair;
    }

    return result;
  }

  private static void swapPair(ListNode node1InPair,
                               ListNode node2InPair) {
    node1InPair.next = node2InPair.next;
    node2InPair.next = node1InPair;
  }
}

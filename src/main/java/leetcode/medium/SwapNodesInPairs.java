package leetcode.medium;

public class SwapNodesInPairs {
  public static RemoveNthFromEnd.ListNode swapPairs(RemoveNthFromEnd.ListNode head) {
    // If head = []
    if (head == null) {
      return null;
    }

    // If head has only one element
    if (head.next == null) {
      return head;
    }

    RemoveNthFromEnd.ListNode node1InPair = head;
    RemoveNthFromEnd.ListNode node2InPair = head.next;
    RemoveNthFromEnd.ListNode result = node2InPair;

    while (true) {
      swapPair(node1InPair, node2InPair);

      node1InPair = node1InPair.next;

      if (node1InPair == null) {
        break;
      }

      node2InPair = node1InPair.next;

      if (node2InPair == null) {
        break;
      }
    }

    return result;
  }

  private static void swapPair(RemoveNthFromEnd.ListNode node1InPair,
                               RemoveNthFromEnd.ListNode node2InPair) {
    node1InPair.next = node2InPair.next;
    node2InPair.next = node1InPair;
  }
}

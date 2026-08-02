package leetcode.hard;

import leetcode.utils.ListNode;

public class ReverseNodesInKGroup {
  public static ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) {
      return head;
    }

    ListNode currentNode = head;
    boolean inGroupOfSizeLessThanK = false;
    ListNode firstNodeInGroup1 = head;
    int groupIndex = 0;
    ListNode result = head;

    do {
      // Reverses a group of size k
      for (int i = 0; i < k - 1; i++) {
        ListNode oldNext = currentNode.next; // In A -> B, oldNext = B

        if (i == 0) {
          firstNodeInGroup1 = currentNode;
        }

        if (oldNext == null) {
          inGroupOfSizeLessThanK = true;

          break;
        }

        currentNode.next.next = currentNode; // A -> B becomes A <- B
        currentNode = oldNext; // In A <- B, currentNode = B
      }

      if (groupIndex == 0) {
        result = currentNode;
      }

      firstNodeInGroup1.next = currentNode.next;

      groupIndex++;
    } while (!inGroupOfSizeLessThanK);

    return result;
  }
}

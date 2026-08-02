package leetcode.hard;

import leetcode.utils.ListNode;

public class ReverseNodesInKGroup {
  public static ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) {
      return head;
    }

    ListNode currentNode = head;
    boolean inGroupOfSizeLessThanK = false;
    ListNode firstNodeInOldGroup = head;
    ListNode firstNodeInGroup1 = head;
    int groupIndex = 0;
    ListNode result = head;

    do {
      // Reverses a group of size k
      for (int i = 0; i < k - 1; i++) {
        ListNode oldNext = currentNode.next; // In A -> B, oldNext = B

        if (i == 0) {
          if (groupIndex > 0) {
            firstNodeInOldGroup = firstNodeInGroup1;
          }

          firstNodeInGroup1 = currentNode;
        }

        if (oldNext == null) {
          inGroupOfSizeLessThanK = true;
          firstNodeInOldGroup.next = reverseKGroup(currentNode, i + 1);

          break;
        }

        ListNode firstNodeOfGroup2 = currentNode.next.next;

        currentNode.next.next = currentNode; // A -> B becomes A <- B

        if (groupIndex == 0 && i == k - 2) {
          result = oldNext;
        }

        if (i < k - 2) {
          currentNode = oldNext.next; // In A <- B, currentNode = B
        } else {
          currentNode = firstNodeOfGroup2;
        }
      }

      firstNodeInGroup1.next = currentNode.next;

      groupIndex++;
    } while (!inGroupOfSizeLessThanK);

    return result;
  }
}

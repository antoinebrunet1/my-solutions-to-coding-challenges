package leetcode.medium;

import leetcode.utils.ListNode;

public class RotateList {
  // Source: https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=linked-list
  public static ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null) {
      return head;
    }

    int n = getListLength(head);
    int rightShift = getRightShift(k, n);
    ListNode newLastNode = getNewLastNode(n, rightShift, head);
    ListNode newHead = newLastNode.next;
    newLastNode.next = null;
    ListNode lastNode = getNewLastNode(rightShift, 0, newHead);
    lastNode.next = head;

    return newHead;
  }

  private static int getListLength(ListNode head) {
    int listLength = 0;
    ListNode currentNode = head;

    do {
      listLength++;
      currentNode = currentNode.next;
    } while (currentNode != null);

    return listLength;
  }

  private static int getRightShift(int k, int n) {
    if (k <= n) {
      return n % k;
    }

    return k % n;
  }

  private static ListNode getNewLastNode(int n, int rightShift, ListNode head) {
    ListNode newLastNode = head;

    for (int i = 0; i < n - rightShift; i++) {
      newLastNode = newLastNode.next;
    }

    return newLastNode;
  }
}

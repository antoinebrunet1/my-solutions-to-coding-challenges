package leetcode.medium;

import leetcode.utils.ListNode;

public class RemoveNthFromEnd {
  // Source: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int sz = getNumberOfNodes(head);

    if (sz == 1) {
      return null;
    }

    int indexOfNodeToRemove = sz - n;
    ListNode nodeBeforeTheOneToRemove = getNodeBeforeTheOneToRemove(head, indexOfNodeToRemove);
    nodeBeforeTheOneToRemove.next = nodeBeforeTheOneToRemove.next.next;

    return head;
  }

  private int getNumberOfNodes(ListNode head) {
    int numberOfNodes = 1;
    ListNode currentNode = head;

    while (currentNode.next != null) {
      numberOfNodes++;
      currentNode = currentNode.next;
    }

    return numberOfNodes;
  }

  private ListNode getNodeBeforeTheOneToRemove(ListNode head, int indexOfNodeToRemove) {
    ListNode nodeBeforeTheOneToRemove = head;

    for (int i = 1; i < indexOfNodeToRemove; i++) {
      nodeBeforeTheOneToRemove = nodeBeforeTheOneToRemove.next;
    }

    return nodeBeforeTheOneToRemove;
  }
}

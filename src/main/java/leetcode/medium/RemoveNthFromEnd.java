package leetcode.medium;

public class RemoveNthFromEnd {
  // Definition for singly-linked list.
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int sz = getNumberOfNodes(head);

    if (sz == 1) {
      return null;
    }

    int indexOfNodeToRemove = sz - n - 1;
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

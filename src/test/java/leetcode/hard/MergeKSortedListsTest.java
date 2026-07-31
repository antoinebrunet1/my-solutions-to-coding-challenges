package leetcode.hard;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeKSortedListsTest {
  @Test
  public void example1() {
    ListNode list1 = ListNode.getHead(new int[] {1, 4, 5});
    ListNode list2 = ListNode.getHead(new int[] {1, 3, 4});
    ListNode list3 = ListNode.getHead(new int[] {2, 6});
    ListNode[] inputList = new ListNode[] {list1, list2, list3};
    ListNode expectedResult = ListNode.getHead(new int[] {1, 1, 2, 3, 4, 4, 5, 6});
    ListNode actualResult = MergeKSortedLists.mergeKLists(inputList);

    Assertions.assertTrue(ListNode.listsAreEqual(expectedResult, actualResult));
  }

  @Test
  public void example2() {
    ListNode[] inputList = new ListNode[] {};
    ListNode result = MergeKSortedLists.mergeKLists(inputList);

    Assertions.assertNull(result);
  }

  @Test
  public void example3() {
    ListNode[] inputList = new ListNode[] {null};
    ListNode result = MergeKSortedLists.mergeKLists(inputList);

    Assertions.assertNull(result);
  }
}

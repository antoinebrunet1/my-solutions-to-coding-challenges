package leetcode.hard;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import leetcode.utils.ListNode;

public class MergeKSortedLists {
  // Source: https://leetcode.com/problems/merge-k-sorted-lists/?envType=problem-list-v2&envId=linked-list
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    // Is sorted by keys
    Map<Integer, Integer> valueToNumberOfOccurrences = getValueToNumberOfOccurrences(lists);

    // If all lists are empty
    if (valueToNumberOfOccurrences.isEmpty()) {
      return null;
    }

    int firstValue = valueToNumberOfOccurrences.keySet().iterator().next();
    ListNode result = new ListNode(firstValue);
    ListNode currentNode = result;

    for (int value : valueToNumberOfOccurrences.keySet()) {
      for (int i = 0; i < valueToNumberOfOccurrences.get(value); i++) {
        if (value == firstValue && i == 0) {
          continue;
        }

        currentNode.next = new ListNode(value);
        currentNode = currentNode.next;
      }
    }

    return result;
  }

  private static Map<Integer, Integer> getValueToNumberOfOccurrences(ListNode[] lists) {
    Map<Integer, Integer> valueToNumberOfOccurrences = new LinkedHashMap<>();

    for (ListNode list : lists) {
      addListToValueToNumberOfOccurrences(valueToNumberOfOccurrences, list);
    }

    valueToNumberOfOccurrences = new TreeMap<>(valueToNumberOfOccurrences);

    return valueToNumberOfOccurrences;
  }

  private static void addListToValueToNumberOfOccurrences(
      Map<Integer, Integer> valueToNumberOfOccurrences, ListNode list) {
    ListNode currentNode = list;

    while (currentNode != null) {
      valueToNumberOfOccurrences.put(currentNode.val,
          valueToNumberOfOccurrences.getOrDefault(currentNode.val, 0) + 1
      );

      currentNode = currentNode.next;
    }
  }
}

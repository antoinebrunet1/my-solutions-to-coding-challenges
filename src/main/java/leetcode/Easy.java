package leetcode;

import java.util.LinkedHashMap;

public class Easy {
  // Complexity: O(n)
  public static int[] twoSum(int[] nums, int target) {
    LinkedHashMap<Integer, Integer> targetMinusElementToElement = new LinkedHashMap<>();

    for (int element : nums) {
      targetMinusElementToElement.put(target - element, element);
    }

    for (int element : nums) {
      if (targetMinusElementToElement.containsKey(element)) {
        return new int[] {element, targetMinusElementToElement.get(element)};
      }
    }

    return null;
  }
}

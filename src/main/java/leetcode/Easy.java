package leetcode;

import java.util.LinkedHashMap;

public class Easy {
  // Complexity: O(n)
  // https://leetcode.com/problems/two-sum/description/
  public static int[] twoSum(int[] nums, int target) {
    LinkedHashMap<Integer, Integer> targetMinusElementToElement = new LinkedHashMap<>();
    int index = 0;

    for (int element : nums) {
      targetMinusElementToElement.put(target - element, index);

      index++;
    }

    index = 0;

    for (int element : nums) {
      if (targetMinusElementToElement.containsKey(element)) {
        return new int[] {index, targetMinusElementToElement.get(element)};
      }

      index++;
    }

    return null;
  }
}

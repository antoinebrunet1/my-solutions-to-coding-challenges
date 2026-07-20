package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
  // Complexity: O(n^2)
  // Source: https://leetcode.com/problems/3sum/
  public static List<List<Integer>> threeSum(int[] nums) {
    nums = getNumsWithUniqueValues(nums);
    Map<Integer, List<List<Integer>>> allSumsOfTwoToListOfTuplesForThatSum =
        getAllSumsOfTwoToListOfTuplesForThatSum(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int num : nums) {
      addListOfTuples(allSumsOfTwoToListOfTuplesForThatSum, num, result);
    }

    return result;
  }

  private static int[] getNumsWithUniqueValues(int[] nums) {
    Set<Integer> numsSet = new LinkedHashSet<>();

    for (int k : nums) {
      numsSet.add(k);
    }

    nums = new int[numsSet.size()];
    int index = 0;

    for (int num : numsSet) {
      nums[index] = num;
      index++;
    }

    return nums;
  }

  private static Map<Integer, List<List<Integer>>> getAllSumsOfTwoToListOfTuplesForThatSum(int[] nums) {
    Map<Integer, List<List<Integer>>> allSumsOfTwoToListOfTuplesForThatSum = new LinkedHashMap<>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        List<Integer> tupleForThatSum = List.of(nums[i], nums[j]);

        if (allSumsOfTwoToListOfTuplesForThatSum.containsKey(sum)) {
          allSumsOfTwoToListOfTuplesForThatSum.get(sum).add(tupleForThatSum);
        } else {
          List<List<Integer>> listOfTuplesForThatSum = new ArrayList<>();

          listOfTuplesForThatSum.add(tupleForThatSum);
          allSumsOfTwoToListOfTuplesForThatSum.put(sum, listOfTuplesForThatSum);
        }
      }
    }

    return allSumsOfTwoToListOfTuplesForThatSum;
  }

  private static void addListOfTuples(
      Map<Integer, List<List<Integer>>> allSumsOfTwoToListOfTuplesForThatSum, int num,
      List<List<Integer>> result) {
    if (allSumsOfTwoToListOfTuplesForThatSum.containsKey(-num)) {
      List<List<Integer>> listOfTuples = allSumsOfTwoToListOfTuplesForThatSum.get(-num);

      result.addAll(listOfTuples);
    }
  }
}

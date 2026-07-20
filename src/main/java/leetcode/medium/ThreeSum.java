package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
  // Complexity: O(n^2)
  // Source: https://leetcode.com/problems/3sum/
  public static List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, List<List<Integer>>> allSumsOfTwoToListOfTuplesForThatSum =
        getAllSumsOfTwoToListOfTuplesForThatSum(nums);
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> numsAlreadyDone = new LinkedHashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (numsAlreadyDone.contains(nums[i])) {
        continue;
      }

      addListOf3Tuples(allSumsOfTwoToListOfTuplesForThatSum, i, result, nums);
      numsAlreadyDone.add(nums[i]);
    }

    result = result.stream().map(list -> list.stream().sorted().toList()).toList();
    result = new ArrayList<>(new HashSet<>(result));

    return result;
  }

  private static Map<Integer, List<List<Integer>>> getAllSumsOfTwoToListOfTuplesForThatSum(int[] nums) {
    Map<Integer, List<List<Integer>>> allSumsOfTwoToListOfTuplesForThatSum = new LinkedHashMap<>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        List<Integer> tupleForThatSum = new ArrayList<>();

        tupleForThatSum.add(i);
        tupleForThatSum.add(j);

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

  private static void addListOf3Tuples(
      Map<Integer, List<List<Integer>>> allSumsOfTwoToListOfTuplesForThatSum, int i,
      List<List<Integer>> result, int[] nums) {
    if (allSumsOfTwoToListOfTuplesForThatSum.containsKey(-nums[i])) {
      List<List<Integer>> listOfTuples = allSumsOfTwoToListOfTuplesForThatSum.get(-nums[i]);
      listOfTuples = listOfTuples.stream().filter(list -> !list.contains(i)).toList();
      listOfTuples.forEach(list -> list.addFirst(nums[i]));
      listOfTuples = listOfTuples.stream().map(list -> List.of(
          list.getFirst(),
          nums[list.get(1)],
          nums[list.getLast()])).toList();

      result.addAll(listOfTuples);
    }
  }
}

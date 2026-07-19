package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
  // https://leetcode.com/problems/zigzag-conversion/description/
  public static String zigzagConversion(String s, int numRows) {
    StringBuilder stringBuilderResult = new StringBuilder();

    for (List<Character> column : get2dList(s, numRows)) {
      for (char c : column) {
        if (c != ' ') {
          stringBuilderResult.append(c);
        }
      }
    }

    return stringBuilderResult.toString();
  }

  private static List<List<Character>> get2dList(String s, int numRows) {
    List<List<Character>> twoDList = new ArrayList<>();

    for (int i = 0; i < s.length(); i += numRows) {
      if (isGoingDown(i, numRows)) {
        addColumnGoingDown(twoDList, i, s, numRows);
      } else {
        addColumnGoingUp(twoDList, i, s, numRows);
      }
    }

    return twoDList;
  }

  private static boolean isGoingDown(int i, int numRows) {
    return (i / numRows) % (numRows - 1) == 0;
  }

  private static void addColumnGoingDown(List<List<Character>> twoDList, int i, String s, int numRows) {
    List<Character> column = new ArrayList<>();

    for (int j = i; j <= getMaxIndexForColumn(i, numRows, s); j++) {
      column.add(s.charAt(j));
    }

    twoDList.add(column);
  }

  private static int getMaxIndexForColumn(int i, int numRows, String s) {
    return Math.min(i + (numRows - 1), s.length() - 1);
  }

  private static void addColumnGoingUp(List<List<Character>> twoDList, int i, String s, int numRows) {
    List<Character> column = new ArrayList<>();
    List<Character> previousColumn = twoDList.getLast();
    int indexOfLastCharInPreviousColumn = getIndexOfLastCharInPreviousColumn(previousColumn);

    for (int j = 0; j <= getMaxIndexForColumn(i, numRows, s); j++) {
      if (j == indexOfLastCharInPreviousColumn + 1) {
        column.add(s.charAt(i));
      } else {
        column.add(' ');
      }
    }

    twoDList.add(column);
  }

  private static int getIndexOfLastCharInPreviousColumn(List<Character> previousColumn) {
    if (previousColumn.getFirst() != ' ') {
      return 3;
    }

    for (int i = 1; i < previousColumn.size() - 1; i++) {
      if (previousColumn.get(1) != ' ') {
        return i;
      }
    }

    return -1;
  }
}

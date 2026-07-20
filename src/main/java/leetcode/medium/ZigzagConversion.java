package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
  // https://leetcode.com/problems/zigzag-conversion/description/
  public static String zigzagConversion(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    if (numRows == 2) {
      return zigzagConversionForNumRowsEqualsToTwo(s);
    }

    StringBuilder stringBuilderResult = new StringBuilder();

    List<List<Character>> columns = get2dList(s, numRows);

    for (int i = 0; i < numRows; i++) {
      for (List<Character> column : columns) {
        if (i > column.size() - 1) {
          break;
        }

        if (column.get(i) != ' ') {
          stringBuilderResult.append(column.get(i));
        }
      }
    }

    return stringBuilderResult.toString();
  }

  private static String zigzagConversionForNumRowsEqualsToTwo(String s) {
    StringBuilder stringBuilderResult = new StringBuilder();

    for (int i = 0; i < s.length() / 2; i++) {
      stringBuilderResult.append(s.charAt(i)).append(s.charAt(i + (s.length() / 2)));
    }

    if (s.length() % 2 != 0) {
      stringBuilderResult.append(s.charAt(s.length() - 1));
    }

    return stringBuilderResult.toString();
  }

  private static List<List<Character>> get2dList(String s, int numRows) {
    List<List<Character>> twoDList = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      if (isGoingDown(i, twoDList)) {
        addColumnGoingDown(twoDList, i, s, numRows);

        i += (numRows - 1);
      } else {
        addColumnGoingUp(twoDList, i, s, numRows);
      }
    }

    return twoDList;
  }

  private static boolean isGoingDown(int i, List<List<Character>> twoDList) {
    if (i == 0) {
      return true;
    }

    List<Character> previousColumn = twoDList.getLast();

    return previousColumn.get(1) != ' ' && previousColumn.getFirst() == ' ';
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
    int indexOfLastCharInPreviousColumn = getIndexOfLastCharInPreviousColumn(previousColumn, numRows);

    for (int j = i; j <= getMaxIndexForColumn(i, numRows, s); j++) {
      if ((j - i) == indexOfLastCharInPreviousColumn - 1) {
        column.add(s.charAt(i));
      } else {
        column.add(' ');
      }
    }

    twoDList.add(column);
  }

  private static int getIndexOfLastCharInPreviousColumn(List<Character> previousColumn, int numRows) {
    if (previousColumn.getFirst() != ' ') {
      return numRows - 1;
    }

    for (int i = 1; i < previousColumn.size() - 1; i++) {
      if (previousColumn.get(i) != ' ') {
        return i;
      }
    }

    return -1;
  }
}

package ApnaCollege;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ls = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                ls.add(matrix[startRow][j]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                ls.add(matrix[i][endCol]);
            }
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                ls.add(matrix[endRow][j]);
            }
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) {
                    break;
                }
                ls.add(matrix[i][startCol]);
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
        return ls;
    }

    private String spaceAndCapitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();
        result.append(text.charAt(0));

        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == ' ') {
                result.append(' ').append(currentChar);
            } else {
                result.append(currentChar);
            }
        }

        return result.toString().trim();
    }


    public static String trim(String input) {
        if (input == null) {
            return null;
        }

        int start = 0;
        int end = input.length() - 1;

        // Find the index of the first non-whitespace character from the beginning
        while (start <= end && Character.isWhitespace(input.charAt(start))) {
            start++;
        }

        // Find the index of the first non-whitespace character from the end
        while (end >= start && Character.isWhitespace(input.charAt(end))) {
            end--;
        }

        // Return the trimmed substring
        return input.substring(start, end + 1);
    }


    private boolean checkUnique(String x) {
        int[] fq = new int[26];

        for (char c : x.toCharArray()) {
            if (++fq[c - 'a'] > 1)
                return false;
        }
        return true;
    }

    public int maxLength(List<String> arr) {
        List<String> list = new ArrayList<>();
        int ans = 0;
        for (String str : arr) {
            List<String> tmp = new ArrayList<>();
            if (!checkUnique(str))
                continue;
            tmp.add(str); // store all combination of strings formed
            ans = Math.max(ans, str.length());
            for (String s : list) {
                String cur = s + str;  // combination
                if (checkUnique(cur)) {
                    tmp.add(cur);
                    ans = Math.max(ans, cur.length());
                }
            }
            list.addAll(tmp);  // Main list
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(matrix);
        System.out.println(list);
        String text = "abc  bncc      Kalka";
        String res = spiralMatrix.spaceAndCapitalizeFirstLetter(text);
        System.out.println(res);

        String input = "   Hello, World!  captain-ATR-600 ";
        String trimmed = trim(input);
        System.out.println("Original: '" + input + "'");
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println(input.trim());

        List<String> li = new ArrayList<>();
        li.add("un");
        li.add("iq");
        li.add("ue");

        int result = spiralMatrix.maxLength(li);
        System.out.println(result);
    }

}


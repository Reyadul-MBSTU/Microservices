package test;

import java.util.HashMap;
import java.util.Map;

public class SubstringMatching {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        char arr1[] = text1.toCharArray(), arr2[] = text2.toCharArray();//converting strings to arrays of char

        int dp[][] = new int[l1 + 1][l2 + 1];//initializing array for DP

        /*
        base cases:
        1.l1==0 then ans will be 0.
        */
        for (int i = 0; i <= l1; i++)
            dp[i][0] = 0;
        /*
        2.l2==0 then ans will be 0.
        */
        for (int j = 0; j <= l2; j++)
            dp[0][j] = 0;

        //if ith char of arr1 and jth char of arr2 is matching then we increment the match in 1 from previous answers
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (arr1[i - 1] == arr2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[l1][l2];
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        //int[][] sum = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //sum[i][j] =sum[i][j-1] + matrix[i][j-1];
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int start = 0; start < col; start++) {
            for (int end = start; end < col; end++) {
                int subMatrixSum = 0;

                Map<Integer, Integer> countElm = new HashMap<Integer, Integer>();
                countElm.put(0, 1);

                for (int k = 0; k < row; k++) {
                    //subMatrixSum += sum[k][end] - sum[k][start];
                    int prefixSum = start == 0 ? 0 : matrix[k][start - 1];
                    subMatrixSum += matrix[k][end] - prefixSum;

                    if (countElm.containsKey(subMatrixSum - target))
                        res += countElm.get(subMatrixSum - target);

                    int r = countElm.getOrDefault(subMatrixSum, 0);
                    countElm.put(subMatrixSum, r + 1);
                }
            }
        }

        return res;
    }

    public String getResult(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)) || text.charAt(i) == ',') {
                continue;
            } else {
                stringBuilder.append(text.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SubstringMatching substringMatching = new SubstringMatching();
        String text1 = "abcde", text2 = "ace";
        int res = substringMatching.longestCommonSubsequence(text1, text2);
        System.out.println(res);
        String result = "Hell1o , World";
        System.out.println(substringMatching.getResult(result));
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
        int sum = substringMatching.numSubmatrixSumTarget(matrix, target);
        System.out.println(sum);
    }
}

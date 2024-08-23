package problemSolving;

import java.util.ArrayList;
import java.util.List;

public class Exponentiation {
    public static int power(int a, int b, int m) {
        int x = a;
        int ans = 1;
       /* while (b != 0) {
            if (b % 2 == 1) {
                ans = (ans * x) % m;
            }
            x = (x * x) % m;
            b /= 2;
        }*/
        for(int i=1; i<b; i++)
        {
            x*=a;
        }
        return x%m;
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            long res = 0;
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int d = variables[i][3];
            res = (long) power(power(a, b, 10), c, d);
            if ((int) res == target)
                list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] variables = {{2,3,3,10},{3,3,3,1},{6,1,1,4}};
        int target = 2;
        Exponentiation exponentiation = new Exponentiation();
        exponentiation.getGoodIndices(variables, target);
        String ans = "ab:bc";
        String[] arr = ans.split(":");
    }
}


package problemSolving;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if(String.valueOf(n).length()==1 && n>1 && n<7) return false;
        List<Integer> list = new ArrayList<>();
        int res = 0, rem=0;
        while (n != 0) {
            rem = n % 10;
            list.add(rem);
            n = n / 10;
        }
        return isHappy(printNum(list));
    }

    private int printNum(List<Integer> list) {
        if (list.size() == 0) return 0;
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num += list.get(i)*list.get(i);
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 19;
        HappyNumber happyNumber = new HappyNumber();
        boolean isResult = happyNumber.isHappy(n);
        System.out.println(isResult);

    }
}

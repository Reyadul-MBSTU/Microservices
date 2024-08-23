package ApnaCollege;

import java.util.HashMap;
import java.util.Map;

public class SubArray {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums, k) - subArray(nums, k - 1);
    }

    private int subArray(int[] nums, int k) {
        int start = 0;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.size() > k) {
                if (map.get(nums[start]) > 1) {
                    map.put(nums[start], map.get(nums[start]) - 1);
                } else {
                    map.remove(nums[start]);
                }
                start++;
            }
            res += (end - start + 1);
        }
        return res;
    }

    static int num = 0;

    private String generateCardNumber() {
        StringBuilder prefix = new StringBuilder("UBBAMJN");
        num++;
        String ans = String.valueOf(num);

        switch (ans.length()) {
            case 1:
                prefix.append("000").append(ans);
                break;
            case 2:
                prefix.append("00").append(ans);
                break;
            case 3:
                prefix.append("0").append(ans);
                break;
            case 4:
                prefix.append(ans);
                break;
            default:
                break;
        }
        return prefix.toString();
    }


    public static void main(String[] args) {
        SubArray subArray = new SubArray();
        for (int i = 0; i < 15; i++) {
            String number = subArray.generateCardNumber();
            System.out.println(number);
        }
    }
}

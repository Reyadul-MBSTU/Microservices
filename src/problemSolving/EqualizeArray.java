package problemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualizeArray {

    public int minimumSeconds(List<Integer> nums) {
        List<Integer> v = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // To remove the circular property, repeat the same vector 2 times
        for (int i : nums) {
            v.add(i);
        }
        for (int i : nums) {
            v.add(i);
        }

        Map<Integer, Integer> um = new HashMap<>();
        for (int i = 0; i < v.size(); i++) {
            if (map.containsKey(v.get(i))) {
                um.put(v.get(i), Math.max(um.getOrDefault(v.get(i), 0), i - map.get(v.get(i)) + 1));
                map.put(v.get(i), i);
            } else {
                map.put(v.get(i), i);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : um.entrySet()) {
            ans = Math.min(ans, entry.getValue());
        }
        ans -= 2;
        return (ans / 2 + ans % 2);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2,1,3,3,2);
        EqualizeArray equalizeArray = new EqualizeArray();
        int ans = equalizeArray.minimumSeconds(list);
    }

}



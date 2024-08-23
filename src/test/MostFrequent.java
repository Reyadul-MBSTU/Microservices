package test;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MostFrequent {
    class pair {
        int val;
        int freq;

        pair(int v, int f) {
            this.val = v;
            this.freq = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> (b.freq - a.freq));
        for (int key : map.keySet()) {
            pq.add(new pair(key, map.get(key)));
        }
        int x = 0;
        int a[] = new int[k];
        while (x != k) {
            assert pq.peek() != null;
            a[x++] = pq.peek().val;
            pq.poll();
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int  k = 2;
        MostFrequent mostFrequent = new MostFrequent();
        int[] ans = mostFrequent.topKFrequent(nums,k);
    }
}


package test;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);

            for (int j = 0; j < row.size(); j++) {
                int idx = i + j;

                if (lists.size() < idx + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(idx).add(row.get(j));

                count++;
            }
        }

        int[] res = new int[count];
        int idx = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res[idx++] = list.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);

        ans.add(list1);
        ans.add(list2);
        ans.add(list3);

        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();

        int[] arr = diagonalTraverse.findDiagonalOrder(ans);

    }
}


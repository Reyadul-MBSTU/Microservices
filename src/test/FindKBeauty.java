package test;

public class FindKBeauty {

    public void findKBeauty(int num, int k) {
        String number = String.valueOf(num);
        int count = 0;
        if(number.length()<k)
        {
            return;
        }
        for (int i = 0; i < num - k + 1; i++) {
            String div = number.substring(i, i + k);
            Integer ans = Integer.parseInt(div);

            if (num % ans == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int num =240, k = 2;

        System.out.println();
    }
}

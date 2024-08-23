package test;

public class MissingPositive {

    int[] arr = {1, 2, 3, 4, 5, 0, 7, 8, 9, 10};
    int index = 0;
    int sum = 0;

    public int missingValue() {
        for (int i = 0; i < 10; i++) {

            if (arr[i] == 0) {
                index = i;
            }
            sum += arr[i];
        }
        int res = (arr.length * (arr.length + 1)) / 2;
        return res - sum;

    }

    public static void main(String[] args) {
        MissingPositive missingPositive = new MissingPositive();
        int result = missingPositive.missingValue();
        System.out.println(result);
    }
}

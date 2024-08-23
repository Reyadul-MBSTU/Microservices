package problemSolving;

public class BeautifulPair {

    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int firstDigit = nums[i];
            while (firstDigit > 9) firstDigit /= 10;
            for (int j = i + 1; j < nums.length; j++) {
                int lastDigit = nums[j] % 10;
                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] arr ={2,5,1,4};
        BeautifulPair beautifulPair = new BeautifulPair();
        int res = beautifulPair.countBeautifulPairs(arr);
    }
}


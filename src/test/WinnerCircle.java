package test;

public class WinnerCircle {

        public int findTheWinner(int n, int k) {
            return result(n, k - 1) + 1; // result here is finding the Winner Helper
        }

        private int result(int n, int k) {
            if (n == 1) {
                return 0;
            }

            return ((k + 1) % n + result(n - 1, k)) % n;
        }

    public static void main(String[] args) {
        WinnerCircle winnerCircle = new WinnerCircle();
        int res = winnerCircle.findTheWinner(5, 2);
        System.out.println(res);
    }

}

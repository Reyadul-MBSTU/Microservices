package test;

public class PrimeDiagonal {
        public static int diagonalPrime(int[][] nums) {
            int max = 0;
            for(int i=0;i<nums.length;i++){
                if(isPrime(nums[i][i]))
                    max = Math.max(max,nums[i][i]);
                if(isPrime(nums[i][nums.length-i-1]))
                    max = Math.max(max,nums[i][nums.length-i-1]);
            }
            return max;
        }

        static boolean isPrime(int v){
            if(v<2) return false;
            for(int i=2;i<=Math.sqrt(v);i++){
                if(v%i==0) return false;
            }
            return true;
        }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{5,6,7},{9,10,11}};
        int result = PrimeDiagonal.diagonalPrime(arr);
        System.out.println(result);
    }
}

package test;
class A {
    int x = 10;
    public int getX()
    {
        return x;
    }
}

class B extends A {
    int x = 20;
    @Override
    public int getX()
    {
        return x;
    }
}
public class MinimumFlips {

    public int minFlips(int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;

            if ((aBit | bBit) != cBit) {
                result += (aBit + bBit + cBit);
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        MinimumFlips minimumFlips = new MinimumFlips();
        int ans = minimumFlips.minFlips(a, b, c);
        //System.out.println(ans);
        int[] A = new int[8];
        int i = 0;
        for (i = -1; i < A.length - 1; ) {
            A[++i] = i;
            System.out.println(A[i]);
        }
        String res = "" + A[2] + (4 % 2) + (5 % 2) + i;
        System.out.println(res);

        A ob = new B();
        System.out.println(ob.x);
        System.out.println(ob.getX());

        int n = 104;
        String str = String.valueOf(n);
        str+=n*2;
        str+=n*3;
        System.out.println(str);
    }
}

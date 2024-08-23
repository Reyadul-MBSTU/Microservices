package test;

public class RecursiveApproach {

    int func(int x, int y)
    {
        if(y==1) return x+1;
        return (x+func(x,y-1));
    }

    public static void main(String[] args) {
        RecursiveApproach recursiveApproach = new RecursiveApproach();
        System.out.println(recursiveApproach.func(2,4));
    }

}

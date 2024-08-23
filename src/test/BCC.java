package test;

public class BCC {

    static int function(int y[], int i)
    {
        int s = y[i];

        if(i>0)
        {
            s+=function(y,i-1);
        }
        System.out.print(s+ "\n");
        return s;
    }

    private void sum()
    {

    }

    @Override
    public String toString() {
        return "BCC{}";
    }

    public void main(String[] args) {
        int y[] = {1,3,2,4,5};
        function(y,4);

    }

    class B extends BCC
    {
        public void main(String[] args) {
            BCC b = new B();
            b.sum();
         //   function(10);
        }

    }

}

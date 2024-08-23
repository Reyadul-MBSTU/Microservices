package ApnaCollege;

public class OOP extends Test{

    public void print()
    {
        System.out.println("Something");
    }
    public static void main(String[] args) {
        A ob = new B();
       // ob.setA(23);
       // System.out.println(ob.getA());
        ob.display();
        Integer a = 10;
        a.floatValue();
        //B b = new B();
        Test test = new Test();
        Test.display();
        OOP oop = null;
        oop.print();
    }
}
class A{
    private int a;

    public int getA()
    {
        return a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public void display()
    {
        System.out.println(a);
        System.out.println("Parent class");
    }
}

class B extends A
{

    public void display()
    {
        System.out.println("Child class");
    }
    
    public static void print()
    {
        System.out.println("Something");
    }
}

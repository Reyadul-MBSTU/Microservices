package ApnaCollege;

public class Test {

    private int a = 10;

    public void dataDisplay()
    {
        System.out.println(a);
    }

    public static void display()
    {
        System.out.println("Static method");
    }
}

class Animal{
    void eat(){System.out.println("eating...");}
}
class Dog extends Animal{
    void bark(){System.out.println("barking...");}
}
class Cat extends Dog{
    void meow(){System.out.println("meowing...");}
}
class TestInheritance3{
    public static void main(String args[]){
        Cat c=new Cat();
        c.meow();
        c.eat();
        c.bark();//C.T.Error
    }}

package problemSolving;

public class Puzzle {
    public static void main(String[] args){
        String a = new String("JavaProgramming");
        String b = "Programming";
        String c = a + b;
        String d = "JavaProgramming";

        System.out.println(a == d);
        System.out.println(c.equals(d));
    }
}


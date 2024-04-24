package basicJava;

public class ClassTwo extends ClassOne {


    public static void main(String[] args) {
        ClassOne c = new ClassOne();
        c.m1();
    }
    public void m1(){

        System.out.println("ClassOne");
    }
}

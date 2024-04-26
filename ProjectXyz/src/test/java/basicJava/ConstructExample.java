package basicJava;

public class ConstructExample {

    static int a ;
    public ConstructExample(){

        a = 1;
    }


    public static void main(String[] args) {

        ConstructExample c = new ConstructExample();

        System.out.println(a);
    }
}

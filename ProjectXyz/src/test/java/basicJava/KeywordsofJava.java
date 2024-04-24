package basicJava;

import org.checkerframework.checker.units.qual.K;

public class KeywordsofJava extends ExceptionHandling {

    int a = 100;
   final double pie = 3.14 ;

    public static void main(String[] args) {

        KeywordsofJava k = new KeywordsofJava();
        k.m1();
    }

    public  void m1(){

        int a = 10 ;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
    }
}

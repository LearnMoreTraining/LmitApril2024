package basicJava;

import java.util.NoSuchElementException;

public class ExceptionHandling {

    int a = 200;

    public static void main(String[] args) {

        int a = 1 ;
        String b = "$12";

        try{
            int c = Integer.parseInt(b);
            System.out.println(a +c );
        }
        catch (NumberFormatException e){

            String h = b.substring(1);
            int z = Integer.parseInt(h);
            System.out.println(z + a);
        }
        catch(NoSuchElementException j){


        }
        finally {

        }


    }
}

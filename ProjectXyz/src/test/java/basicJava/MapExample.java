package basicJava;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer,String> m = new HashMap<Integer,String>();
        m.put(345,"abc");
        m.put(789,"xyz");

        System.out.println(m);

        System.out.println( m.get(345));


        for(Map.Entry h:m.entrySet()){

            System.out.println( h.getKey());
            System.out.println(h.getValue());
            if(h.getKey().equals("345")){

                h.getValue();
            }
        }

    }
}

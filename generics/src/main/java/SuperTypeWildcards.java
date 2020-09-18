// generics/SuperTypeWildcards.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards {
    void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//         apples.add(new Fruit()); // Error
//        apples.set(1, new Fruit()); // Error
        apples.set(2, new Apple());


        List<? super Apple> apples2 = new ArrayList<Apple>();
//        List<? super Apple> apples3 = new ArrayList<Jonathan>(); // Error
        List<? super Apple> apples4 = new ArrayList<Fruit>();
    }

    void writeTo2(List<? extends Apple> apples) {
//        apples.add(new Apple());// Error
//        apples.add(new Jonathan()); // Error
//        apples.add(new Fruit()); // Error
        List<? extends Apple> apples2 = new ArrayList<Apple>();
        List<? extends Apple> apples3 = new ArrayList<Jonathan>();
//        List<? extends Apple> apples4 = new ArrayList<Fruit>(); // Error

    }
}

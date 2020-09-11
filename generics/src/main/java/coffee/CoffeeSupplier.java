// generics/coffee/CoffeeSupplier.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java generics.coffee.CoffeeSupplier}
package coffee;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {
    private Class<?>[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class,};

    private static Random rand = new Random(47);

    public CoffeeSupplier() {
    }

    // For iteration:
    private int size = 0;

    public CoffeeSupplier(int sz) {
        size = sz;
    }

    @Override
    public Coffee get() {
        try {
            int nextInt = rand.nextInt(types.length);
//            System.out.println("types.length = " + types.length + ", nextInt = " + nextInt);
            return (Coffee)
                    types[nextInt].newInstance();
            // Report programmer errors at run time:
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier()).limit(6).forEach(coffee -> {
            System.out.println(coffee);
        });
        System.out.println("============");
        for (Coffee c : new CoffeeSupplier(5))
            System.out.println(c);
    }
}
/* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*/

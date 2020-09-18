// streams/FlatMap.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(
                        i -> Stream.of("Gonzo" + i, "Fozzie" + i, "Beaker" + i))
                .forEach(System.out::println);

        System.out.println("--------------------\n");
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
        System.out.println("----------------------\n");

        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo"+i, "Kermit"+i, "Beaker"+i))
                .forEach(stringStream -> {
                    stringStream.forEach(System.out::println);
                    System.out.println();
                });
        System.out.println("----------------------\n");

        Stream.of(1, 2, 3)
                .map(i -> "Gonzo"+i)
//                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }
}
/* Output:
Gonzo
Fozzie
Beaker
Gonzo
Fozzie
//Beaker
Gonzo
Fozzie
Beaker
*/

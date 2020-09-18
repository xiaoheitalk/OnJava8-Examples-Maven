// streams/SpecialCollector.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SpecialCollector {
    public static void
    main(String[] args) throws Exception {
        String message = "Not much of a cheese shop really, is it?\n" +
                "Finest in the district, sir.\n" +
                "And what leads you to that conclusion?\n" +
                "Well, it's so clean.\n" +
                "It's certainly uncontaminated by cheese.";
        ArrayList<Object> collect = Pattern.compile("\\W+").splitAsStream(message).flatMap(s -> Stream.of(s))
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);

        collect.stream().filter(s -> s.equals("cheese"))
                .forEach(System.out::println);


//        words1.stream()
//                .filter(s -> s.equals("cheese"))
//                .forEach(System.out::println);
        System.out.println();
        ArrayList<String> words =
                FileToWords.stream("E:\\production\\github\\02-tutorial\\OnJava8-Examples-Maven\\streams\\src\\main\\java\\Cheese.dat")
                        .collect(ArrayList::new,
                                ArrayList::add,
                                ArrayList::addAll);
        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}
/* Output:
cheese
cheese
*/

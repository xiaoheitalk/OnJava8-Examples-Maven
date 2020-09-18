// streams/ForEach.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        RandInts.rands().limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        RandInts.rands().limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        RandInts.rands().limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
    }
}
/* Output:
258 555 693 861 961 429 868 200 522 207 288 128 551 589
551 861 429 589 200 522 555 693 258 128 868 288 961 207
258 555 693 861 961 429 868 200 522 207 288 128 551 589
*/

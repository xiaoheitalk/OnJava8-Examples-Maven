// streams/SelectElement.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


public class SelectElement {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().findFirst().getAsInt());
        System.out.println(RandInts.rands().parallel().findFirst().getAsInt());
        System.out.println(RandInts.rands().findAny().getAsInt());
        System.out.println(RandInts.rands().parallel().findAny().getAsInt());
    }
}
/* Output:
258
258
258
242
*/

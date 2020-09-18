// typeinfo/ClassInitialization.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Random;

/**
 * 加载，这是由类加载器执行的。该步骤将查找字节码（通常在 classpath 所指定的路径中查找，但这并非是必须的），并从这些字节码中创建一个 Class 对象。
 *
 * 链接。在链接阶段将验证类中的字节码，为 static 字段分配存储空间，并且如果需要的话，将解析这个类创建的对其他类的所有引用。
 *
 * 初始化。如果该类具有超类，则先初始化超类，执行 static 初始化器和 static 初始化块。
 *  <p>
 * 初始化有效地实现了尽可能的“惰性”，从对 initable 引用的创建中可以看到，仅使用 .class 语法来获得对类对象的引用不会引发初始化。但与此相反，使用 Class.forName() 来产生 Class 引用会立即就进行初始化，
 * 如 initable3。
 * <p>
 * 如果一个 static final 值是“编译期常量”（如 Initable.staticFinal），那么这个值不需要对 Initable 类进行初始化就可以被读取。但是，如果只是将一个字段设置成为 static 和 final，还不足以确保这种行为。
 * 例如，对 Initable.staticFinal2 的访问将强制进行类的初始化，因为它不是一个编译期常量。
 * <p>
 * 如果一个 static 字段不是 final 的，那么在对它访问时，总是要求在它被读取之前，要先进行链接（为这个字段分配存储空间）和初始化（初始化该存储空间），就像在对 Initable2.staticNonFinal 的访问中所看到的那样
 */
class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {

    static int staticNonFinal = 147;

    Initable2() {
        System.out.println("aaa");

    }

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    Initable3() {
        System.out.println("bbb");
    }

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.STATIC_FINAL);
        System.out.println("-------------");

        // Does trigger initialization:
        System.out.println(Initable.STATIC_FINAL2);
        System.out.println("++++++++");

        System.out.println();
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        System.out.println("=====================");

        Class initable3 = Class.forName("Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
/* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*/

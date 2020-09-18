// generics/CheckedList.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using Collection.checkedList()

import pets.Dog;
import pets.Pet;
import pets.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        System.out.println("---------");
        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        System.out.println("---------");
        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
/* Output:
Expected: java.lang.ClassCastException: Attempt to
insert class typeinfo.pets.Cat element into collection
with element type class typeinfo.pets.Dog
*/

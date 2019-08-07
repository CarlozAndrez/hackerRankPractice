package java8features.lambdas;

import java.util.function.Consumer;

/**
 * Consumers represents operations to be performed on a single input argument.
 */
public class Consumers {

    public static void main(String[] args) {
        Person person = new Person("First", "Last");
        Consumer<Person> printFirstName = (p) -> System.out.println(p.firstName);
        printFirstName.accept(person);

        //Optional<Person> optionalPerson = new

        // Chaining consumers
        //Consumer<Person> printName = printFirstName.andThen((p) -> System.out.println(p.lastName));
        //printName.accept(person);
    }
}
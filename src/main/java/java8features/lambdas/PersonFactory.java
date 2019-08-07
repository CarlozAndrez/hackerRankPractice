package java8features.lambdas;

@FunctionalInterface
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastname);
}

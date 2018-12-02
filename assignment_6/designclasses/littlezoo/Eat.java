package assignment_6.designclasses.littlezoo;

public interface Eat {

    void attack();

    default void roaring(String roarPhrase) {
        System.out.println("I am about to bite you and try how tasty you are!");
    }
}

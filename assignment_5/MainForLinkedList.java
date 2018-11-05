package assignment_5;

import java.util.Iterator;

public class MainForLinkedList {

    public static void main(String[] args) {

        Object book1 = new BookObject("The war and peace", "Leo Tolstoy", 589);
        Object book2 = new BookObject("Enchanter", "Mac Quilty", 661);
        Object book3 = new BookObject("Taken by wind", "J-F Rowling", 345);
        Object book4 = new BookObject("Crying in the raw", "Fitz Geraldina", 789);

        LinkedListAdvanced myLinkedListAdvanced = new LinkedListAdvanced();

        myLinkedListAdvanced.pushNode(book1,1);
        myLinkedListAdvanced.pushNode(book2,2);
        myLinkedListAdvanced.pushNode(book3,3);
        myLinkedListAdvanced.pushNode(book4,4);
        myLinkedListAdvanced.pushNode(book2,5);

        myLinkedListAdvanced.printingOut();

        System.out.println(myLinkedListAdvanced.getListSize());

        myLinkedListAdvanced.getNodeByIndex(2);

        System.out.println();

        myLinkedListAdvanced.popNode();

        myLinkedListAdvanced.printingOut();

        myLinkedListAdvanced.removeNodeByIndex(2);

        myLinkedListAdvanced.printingOut();

        LinkedListAdvanced myLinkedListAdvanced1 = new LinkedListAdvanced();

        myLinkedListAdvanced1.pushNode(book1,1);
        myLinkedListAdvanced1.pushNode(book2,2);
        myLinkedListAdvanced1.pushNode(book3,3);
        myLinkedListAdvanced1.pushNode(book4,4);
        myLinkedListAdvanced1.pushNode(book2,5);

        myLinkedListAdvanced1.printingOut();

        myLinkedListAdvanced1.unshift();
        myLinkedListAdvanced1.unshift();
        myLinkedListAdvanced.printingOut();
        myLinkedListAdvanced1.unshift();
        myLinkedListAdvanced1.unshift();
        myLinkedListAdvanced1.unshift();


/*
        Iterator iterator = myLinkedListAdvanced.evenIterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString());
            // Why can't I call methods of the Node right here?

            System.out.println();

        }
**/



    }
}

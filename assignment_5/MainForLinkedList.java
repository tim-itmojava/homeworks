package assignment_5;

import java.util.Iterator;

public class MainForLinkedList {

    public static void main(String[] args) {

        Object book1 = new BookObject("The war and peace", "Leo Tolstoy", 589);
        Object book2 = new BookObject("Enchanter", "Mac Quilty", 661);
        Object book3 = new BookObject("Taken by wind", "J-F Rowling", 345);
        Object book4 = new BookObject("Crying in the raw", "Fitz Geraldina", 789);

        Object book5 = new BookObject("Crime and Punishment", "F Dostoevsy", 655);

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

        myLinkedListAdvanced.addNodeByIndex(book5,3,2);

        myLinkedListAdvanced.printingOut();

        myLinkedListAdvanced.pushNode(book1,11);
        myLinkedListAdvanced.pushNode(book2,12);
        myLinkedListAdvanced.pushNode(book3,13);

        myLinkedListAdvanced.printingOut();

        myLinkedListAdvanced.popNode();

        myLinkedListAdvanced.printingOut();

        myLinkedListAdvanced.removeNodeByIndex(3);

        myLinkedListAdvanced.printingOut();

        myLinkedListAdvanced.addNodeByIndex(new BookObject("Adultery", "Murakami",300),1,3);

        myLinkedListAdvanced.printingOut();

        myLinkedListAdvanced.removeNodeByIndex(2);

        myLinkedListAdvanced.printingOut();

        LinkedListAdvanced myLinkedListAdvanced1 = new LinkedListAdvanced();

        myLinkedListAdvanced1.addNodeByIndex(new BookObject("Adultery", "Murakami",300),1,0);
        myLinkedListAdvanced1.addNodeByIndex(new BookObject("Taken by wind", "J-F Rowling", 345),1,1);
        myLinkedListAdvanced1.addNodeByIndex(new BookObject("Adultery", "Murakami",400),1,2);
        myLinkedListAdvanced1.addNodeByIndex(new BookObject("Crying in the raw", "Fitz Geraldina", 789),1,3);
        myLinkedListAdvanced1.printingOut();

    }
}

package assignment_5.task1;

public class MainForLinkedList {

    public static void main(String[] args) {

        Object book1 = new BookObject("The war and peace", "Leo Tolstoy", 589);
        Object book2 = new BookObject("Enchanter", "Mac Quilty", 661);
        Object book3 = new BookObject("Taken by wind", "J-F Rowling", 345);
        Object book4 = new BookObject("Crying in the raw", "Fitz Geraldina", 789);

        Object book5 = new BookObject("Crime and Punishment", "F Dostoevsy", 655);

        LinkedListAdvanced myLinkedListAdvanced = new LinkedListAdvanced();

        // filling in a List by pushing new Objects in:
        myLinkedListAdvanced.pushNode(book1,1);
        myLinkedListAdvanced.pushNode(book2,2);
        myLinkedListAdvanced.getObjectByIndex(0);
        myLinkedListAdvanced.getObjectByIndex(1);

        // filling in the List by adding a new Object to a specified position (index)
        myLinkedListAdvanced.addNodeByIndex(book3,3,2);     // appending to the end
        myLinkedListAdvanced.printingOut();
        System.out.println("Retrieving the last element --> " + myLinkedListAdvanced.getObjectByIndex(myLinkedListAdvanced.getListSize()-1));
        myLinkedListAdvanced.addNodeByIndex(book4,4,1);     // inserting within the List
        myLinkedListAdvanced.printingOut();
        System.out.println("Retrieving the last element --> " + myLinkedListAdvanced.getObjectByIndex(myLinkedListAdvanced.getListSize()-1));

        // checking the size of the List
        System.out.println("The List is of size --> " + myLinkedListAdvanced.getListSize());

        // popping a Node out
        myLinkedListAdvanced.popNode();
        myLinkedListAdvanced.printingOut();


        // adding a Node to the leading position
        myLinkedListAdvanced.addNodeByIndex(book5,5,0);
        myLinkedListAdvanced.printingOut();

        System.out.println("Retrieving the last element --> " + myLinkedListAdvanced.getObjectByIndex(myLinkedListAdvanced.getListSize()-1));

        // removing a Node at a specified position
        myLinkedListAdvanced.removeNodeByIndex(1);
        myLinkedListAdvanced.printingOut();
        myLinkedListAdvanced.getObjectByIndex(1);

        myLinkedListAdvanced.addNodeByIndex(new BookObject("Adultery", "Murakami",300),1,1);

        myLinkedListAdvanced.printingOut();

        Node temp = myLinkedListAdvanced.getNodeByIndex(1);
        temp.toString();

        System.out.println("************* Checking the link to the Next Node & Object: ");

        System.out.println(temp.getNextNode().getObject());

    }

}

package assignment_5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

public class LinkedListAdvanced implements List, Stack, Queue {

    private Node[] Node = new Node[10];
    private UUID session;
    private int endPointer;

    public LinkedListAdvanced() {
        System.out.println("=========================================================");

        UUID uuid = UUID.randomUUID();
        this.session = uuid;
        this.endPointer = 0;    // endPointer flags the position followed by the last List element
        System.out.println("An instance of List gets initialised...");
    }

    public int getEndPointer() {
        return endPointer;
    }

    public void setEndPointer(int endPointer) {
        this.endPointer = endPointer;
    }

    // adding a new node at the end of the list - interface Stack
    public void pushNode (Object object, int value) {       // "value" is optional instance field of a Node
        System.out.println("=========================================================");

        try {

            if (this.getEndPointer() == 0) {
                this.Node[0] = new Node(object, value);
                this.Node[0].setIndex(0);

                this.setEndPointer(this.getEndPointer() + 1);

            } else {
                this.Node[endPointer] = new Node(object, value);
                this.Node[endPointer].setIndex(endPointer);
                this.Node[endPointer - 1].setNextNode(this.Node[endPointer]);

                this.setEndPointer(this.getEndPointer() + 1);
            }
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void addNodeByIndex(Object object, int value, int index) {
        System.out.println("=========================================================");

        try {

            if (this.getEndPointer() == 0 && index == 0) {

                System.out.println("Adding an object:... " + object.toString() + " at position - index = " + index);
                this.Node[0] = new Node(object, value);
                this.Node[0].setIndex(0);

                this.setEndPointer(this.getEndPointer() + 1);

            }

            else if (index >= this.getEndPointer()) {
                System.out.println("=========================================================");

                System.out.println("Adding trailing Node[" + this.getEndPointer() + "] ....");
                System.out.println("Adding an object:... " + object.toString() + " at position - index = " + index);

                Node[this.getEndPointer()] = new Node(object, value);
                Node[this.getEndPointer()].setNextNode(null);
                Node[this.getEndPointer()-1].setNextNode(Node[index]);
                Node[this.getEndPointer()].setIndex(this.getEndPointer());

                this.setEndPointer(this.getEndPointer() + 1);
            }

            else if (index >= 0 && index < this.getEndPointer()) {
                System.out.println("=========================================================");
                System.out.println("Adding a Node[" + index + "] in between ....");
                System.out.println("Adding an object:... " + object.toString() + " at position - index = " + index);

                this.Node[endPointer] = new Node(this.Node[endPointer-1].getObject(),this.Node[endPointer-1].getValue());
                this.setEndPointer(this.getEndPointer() + 1);

                for (int i = this.getEndPointer() - 1; i > index; i--) {

                    Node[i-1].setNextNode(Node[i]);

                    Node[i].setIndex(Node[i-1].getIndex() + 1);
                    Node[i].setObject(Node[i-1].getObject());
                    Node[i].setValue(Node[i-1].getValue());

                }

                // assigning new instance fields values to the Node being inserted
                this.Node[index].setObject(object);
                this.Node[index].setValue(value);
            }
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // retrieving a node at a specified position - interface List
    public Object getNodeByIndex (int index) {
        System.out.println("=========================================================");
        if (index >=0 && index < this.getEndPointer()) {
            System.out.println("Printing out the list element " + index + " = " +
                    "{ " +
                    " index: " +
                    this.Node[index].getIndex() + " ;" +
                    "object: " +
                    this.Node[index].getObject() + ";" +
                    " value: " +
                    this.Node[index].getValue() + " ;" +
                    " reference to next: " +
                    this.Node[index].getNextNode() +
                    " }");
            return this.Node[index].getObject();
        }
        else {
            System.out.println("The index is out of the list bounds. Please specify a correct value of the index...");
            return null;
        }
    }

    // removing a Node by index - interface List
    public void removeNodeByIndex (int index) {
        System.out.println("=========================================================");

        System.out.println("Entering the removeNode method...");

        if (index >= this.endPointer) {
            System.out.println("The element to be removed is out of the List boundary or" +
                    " the range of inserted elements");
        }

        else if (index == 0) {
            System.out.println("Removing Node[" + index + "]......");
            this.unshift();
        }

        else if (index == this.getEndPointer() - 1) {
            System.out.println("Removing Node[" + index + "]......");
            Node[index-1].setNextNode(null);            // the Node[index] element will be trashed by the GCollector
            this.setEndPointer(this.getEndPointer() - 1);
        }

        else {
            System.out.println("Removing Node[" + index + "]......");
            this.setEndPointer(this.getEndPointer() - 1);   // first changing thr endPointer to loop through valid indices

            Node[index - 1].setNextNode(Node[index].getNextNode());     // setting new NextNode to Node[index-1] to close the gap

            for (int i = index; i <= this.getEndPointer() - 1; i++) {   // rearranging indices and Node instance fields
                                                                        // for all Nodes ahead of the one being removed
                Node[i].setValue(Node[i+1].getValue());
                Node[i].setObject(Node[i+1].getObject());
                Node[i].setIndex(Node[i+1].getIndex() - 1);
                Node[i].setNextNode(Node[i+1].getNextNode());
            }
        }
    }

    public void unshift() {
        System.out.println("=========================================================");
        System.out.println("The very first element needs to be removed safely...");

        System.out.println("Removing the leading Node......");

        if (this.getEndPointer() == 1) {
            System.out.println("You're about to delete the only element in the List. Please confirm the action (Y/N)");

            Scanner scanner = new Scanner(System.in);
            String confirmation = scanner.next();
            if (confirmation.equals("Y")) {
                System.out.println("Deleting the last element...");

                this.setEndPointer(0);
                this.Node[0].setValue(0);
                this.Node[0].setObject(null);
                this.Node[0].setIndex(0);

                System.out.println("The size of the List now: " + (this.getEndPointer()));

            } else {
                System.out.println("It's safer not to delete anything.");
            }
        }

        else if (this.getEndPointer() == 0) System.out.println("There is nothing to delete!");

        else {
            this.setEndPointer(this.getEndPointer() - 1);

            for (int i = 0; i <= this.getEndPointer() - 1; i++) {   // rearranging indices and Node instance fields
                // for all Nodes ahead of the one being removed
                Node[i].setValue(Node[i + 1].getValue());
                Node[i].setObject(Node[i + 1].getObject());
                Node[i].setIndex(Node[i + 1].getIndex() - 1);
                Node[i].setNextNode(Node[i + 1].getNextNode());
            }
        }
    }

    public void popNode() {
        System.out.println("=========================================================");
        System.out.println("Entering the popNode method...");

            System.out.println("Removing Node[" + (this.getEndPointer() - 1) + "]......");

            if (this.getEndPointer() <= 1) this.unshift();
            else {
                Node[this.getEndPointer() - 1 - 1].setNextNode(null);   // the Node[index] element will be trashed by the GCollector
                this.setEndPointer(this.getEndPointer() - 1);
            }
    }

    public int getListSize() {
        System.out.println("=========================================================");
//        System.out.println("The size of the List");
        return this.getEndPointer() - 1 + 1;
    }

    public void printingOut() {
        System.out.println("=========================================================");
        for (int i = 0; i <= this.getEndPointer() - 1 ; i++) {
            System.out.println("Printing out an element of the list (" +
                    "{ " +
                    " index: " +
                    this.Node[i].getIndex() + " ;" +
                    " value: " +
                    this.Node[i].getValue() + " ;" +
                    " object: " +
                    this.Node[i].getObject() +
                    " reference to next: " +
                    this.Node[i].getNextNode() +
                    " endPointer: " + this.getEndPointer() + "}");
        }
    }

    class EvenIterator implements Iterator {        // not in use this far
        private int nextIndex;

        @Override
        public boolean hasNext() {
            // Node - поле основного класса
            return nextIndex < getEndPointer() - 1;
        }

        @Override
        public Object next() {
            // Node - поле основного класса
            Node next = Node[nextIndex];
            nextIndex += 2;
            return next;
        }
    }

    public Iterator evenIterator() {
        return new EvenIterator();
    }   // not in use this far
}
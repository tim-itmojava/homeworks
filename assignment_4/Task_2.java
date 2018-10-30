package assignment_4;

import java.util.Arrays;
import java.util.UUID;

public class Task_2 {

    public static void main(String[] args) {

        // MyLinkedList supports the following methods:
        //  .addNode,
        //  .getNodeByIndex,
        //  .removeNode,
        //  .printingOut

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addNode(10);
        myLinkedList.addNode(100);
        myLinkedList.addNode(354);
        myLinkedList.addNode(567);
        myLinkedList.addNode(678);
        myLinkedList.addNode(925);
        myLinkedList.addNode(251274);

        myLinkedList.printingOut();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

        myLinkedList.removeNode(4);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

        myLinkedList.getNodeByIndex(4);

    }
}

class Node {

    private int value;
    private int index;
    private Node nextNode;

    public Node(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public int getIndex() {
        return index;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class MyLinkedList {

    private Node[] Node = new Node[10];
    private UUID session;
    private int endPointer;

    public MyLinkedList() throws NullPointerException {

        UUID uuid = UUID.randomUUID();
        this.session = uuid;
        this.endPointer = 0;
    }

    public int getEndPointer() {
        return endPointer;
    }

    public void setEndPointer(int endPointer) {
        this.endPointer = endPointer;
    }

    public void addNode (int value) {

        try {
//                System.out.println("The list looks like the following: " + this.Node.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (this.getEndPointer() == 0) {
            this.Node[0] = new Node(value);
            this.Node[0].setIndex(0);
            this.setEndPointer(this.getEndPointer() + 1);
        }
        else {
            this.Node[endPointer] = new Node(value);
            this.Node[endPointer].setIndex(endPointer);
            this.Node[endPointer-1].setNextNode(this.Node[endPointer]);

            this.setEndPointer(this.getEndPointer() + 1);
        }

    }

    public void getNodeByIndex (int index) {
        if (index <= this.getEndPointer()) {
            System.out.println("Printing out the list element " + index + " = " +
                    "{ " +
                    " index: " +
                    this.Node[index].getIndex() + " ;" +
                    " value: " +
                    this.Node[index].getValue() + " ;" +
                    " reference to next: " +
                    this.Node[index].getNextNode() +
                    " }");
        }
    }
    public void removeNode (int index) {

        System.out.println("Entering the removeNode method...");

        if (index > this.endPointer) {
            System.out.println("The element to be removed is out of the List boundary or" +
                    " the range of inserted elements");
        }
        else if (index == this.getEndPointer() - 1) {
            System.out.println("Removing Node[" + index + "]......");
            Node[index-1].setNextNode(null);
            this.setEndPointer(this.getEndPointer() - 1);
        }
        else {
            System.out.println("Removing Node[" + index + "]......");
            this.setEndPointer(this.getEndPointer() - 1);

            Node[index - 1].setNextNode(Node[index].getNextNode());

            for (int i = index; i <= this.getEndPointer() - 1; i++) {
                Node[i].setValue(Node[i+1].getValue());
                Node[i].setIndex(Node[i+1].getIndex() - 1);
                Node[i].setNextNode(Node[i+1].getNextNode());
            }
        }
    }

    public void insertNode(int index) {
    // TODO
    }

    public void printingOut() {
        for (int i = 0; i <= this.getEndPointer() - 1 ; i++) {
            System.out.println("Printing out an element of the list (" + this.session + "): " +
                    "{ " +
                    " index: " +
                    this.Node[i].getIndex() + " ;" +
                    " value: " +
                    this.Node[i].getValue() + " ;" +
                    " reference to next: " +
                    this.Node[i].getNextNode() +
                    " endPointer: " + this.getEndPointer() + "}");
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "Node=" + Arrays.toString(Node) +
                ", session=" + session +
                ", endPointer=" + endPointer +
                '}';
    }
}

// attic - debugging tools

//                System.out.println("=============================================================");
//
//                System.out.println("Checking value of the previous element in the list " +
//                                                                            this.Node[endPointer-1].getValue());
//                System.out.println("Checking index of the previous element in the list " +
//                                                                            this.Node[endPointer-1].getIndex());
//                System.out.println("Checking reference to the next Node the previous element points to " +
//                                                                            this.Node[endPointer-1].getNextNode());
//
//                System.out.println("Checking value of the current element in the list " +
//                                                                            this.Node[endPointer].getValue());
//                System.out.println("Checking index of the current element in the list " +
//                                                                            this.Node[endPointer].getIndex());
//                System.out.println("Checking reference to the next Node the current element points to " +
//                                                                            this.Node[endPointer].getNextNode());
//                    System.out.println("Node[i].setValue(Node[i+1].getValue())" + Node[i+1].getValue());
//                    System.out.println("Node[i].setIndex(Node[i+1].getIndex())" + Node[i+1].getIndex());
//                    System.out.println("Node[i].setNextNode(Node[i+1].getNextNode())" + Node[i+1].getNextNode());
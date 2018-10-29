package assignement_4;

import java.util.Arrays;
import java.util.UUID;

public class Task_2_1 {

    public static void main(String[] args) {

        MyLinkedList1 myLinkedList = new MyLinkedList1();

        myLinkedList.toString();

        myLinkedList.addNode(new Node1(1));



    }
}

class Node1 {

    private int value;
    private int index;
    private Node1 nextNode;

    public Node1(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node1 getNextNode() {
        return nextNode;
    }

    public int getIndex() {
        return index;
    }
}

class MyLinkedList1 {

    private Node1[] Node;
    private UUID session;
    private int endPointer;

    public MyLinkedList1() {

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

    protected void addNode(Node1 node) {

        if (endPointer == 0) {
            this.Node[0] = node;
            this.endPointer = this.Node.length;

        }
    }

    @Override
    public String toString() {
        return "MyLinkedList1{" +
                "Node=" + Arrays.toString(Node) +
                ", session=" + session +
                ", endPointer=" + endPointer +
                '}';
    }
}

package assignment_5;

public class Node {


    private int value;
    private int index;
    private Node nextNode;
    private Object object;

    public Node(Object object, int value)
    {
        this.value = value;
        this.object = object;

        System.out.println("A node has been initialised with the Object put in as follows: " + this.object.toString());
    }

    public Object getObject() {
        return object;
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

    public void setObject(Object object) {
        this.object = object;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", index=" + index +
                ", nextNode=" + nextNode +
                ", object=" + object +
                '}';
    }
}

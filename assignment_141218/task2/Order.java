package assignment_141218.task2;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum Menu {Pizza_1, Pizza_2, Pizza_3, Pizza_4}
    public enum Status {Submitted, Taken, Processed}

    private String orderContent;
    private String status;
    private int orderNumber;
    private int clientId;

    protected Order(int clientId) {
        this.clientId = clientId;
        this.status = Status.Submitted.toString();
        int rnd = Math.toIntExact(Math.round(Math.random()*10));
//        System.out.println(rnd);
        switch(rnd) {
            case 0:
            case 2:
            case 3: this.orderContent = Menu.Pizza_1.toString();
                break;
            case 4:
            case 5:
            case 6: this.orderContent = Menu.Pizza_2.toString();
                break;
            case 7:
            case 8:
            case 9: this.orderContent = Menu.Pizza_3.toString();
                break;
            default:
                this.orderContent = Menu.Pizza_4.toString();
        }
        this.orderNumber = Math.toIntExact(Math.round(Math.random()*1000000));
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderContent='" + orderContent + '\'' +
                ", status='" + status + '\'' +
                ", orderNumber=" + orderNumber +
                ", clientId=" + clientId +
                '}';
    }

    public static void main(String[] args) {

        List<Thread> clients = new ArrayList<>();
        List<Thread> servants = new ArrayList<>();
        List<Thread> cooks = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            servants.add(new Thread(new Servant()));
            cooks.add(new Thread(new Kitchen()));
            clients.add(new Thread(new ClientQueues()));
        }

        for(Thread t : cooks) {
            t.start();
        }

        for(Thread t : servants) {
            t.start();
        }

        for(Thread t : clients) {
            t.start();
        }

        ClientIds clientIds = new ClientIds();
        clientIds.run();

    }
}
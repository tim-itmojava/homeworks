package assignment_141218.task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ClientQueues implements Runnable {

    protected static final BlockingQueue<Order> submittedOrders = new ArrayBlockingQueue<>(30);
    private Map<Integer, String> OrdersMadeByClients = new HashMap<>(100);

    @Override
    public void run() {

        System.out.println("Thread [clients] " + Thread.currentThread() + " is running...");

        boolean done = false;
        while (!done) {

            try {
                int clientOrdering = ClientIds.clientIdCell.take();
                if (clientOrdering == 333) {
                    done = true;
                    ClientIds.clientIdCell.put(clientOrdering);
                    continue;
                }

                Order tempOrder = new Order(clientOrdering);
                System.out.println(tempOrder.toString());
//                System.out.println("Submitted orders queue capacity: " + submittedOrders.remainingCapacity());

                submittedOrders.put(tempOrder);
                OrdersMadeByClients.put(tempOrder.getOrderNumber(), Integer.toString(clientOrdering));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Arrays.toString(OrdersMadeByClients.entrySet().toArray()));

        done = false;

        // taking complete orders from the Cooks' queue
        while (!done) {

            try {

                Order servedOrder = Kitchen.completedOrders.take();
                System.out.println("OrdersMadeByClients remainder is: " + OrdersMadeByClients.size());

                Iterator<Map.Entry<Integer,String>> iterator = OrdersMadeByClients.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, String> pair = iterator.next();
                    if(servedOrder.getOrderNumber()==pair.getKey()) {
                        System.out.println("The order: " + pair.getKey() + " for client: " + pair.getValue()
                        + " is completed" + " || THREAD: " + Thread.currentThread());
                        System.out.println(servedOrder.toString());
                        OrdersMadeByClients.remove(pair);
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(OrdersMadeByClients.size()==0) {
                done=true;
            }
            else {
//                System.out.println("OrdersMadeByClients remainder is: " + OrdersMadeByClients.size());
            }
        }

    }
}

class ClientIds implements Runnable {

    protected static final BlockingQueue<Integer> clientIdCell = new ArrayBlockingQueue<>(30);

    @Override
    public void run() {

        for(int i=1; i<=100; i++) {

            int clientId = i;

            try {
                clientIdCell.put(clientId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            clientIdCell.put(333);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
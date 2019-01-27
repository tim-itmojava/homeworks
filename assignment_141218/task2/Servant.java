package assignment_141218.task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Servant implements Runnable {

    protected static final BlockingQueue<Order> takenOrders = new ArrayBlockingQueue<>(40);

    @Override
    public void run() {

        System.out.println("Thread [servants] " + Thread.currentThread() + " is running...");

        while (!Thread.currentThread().isInterrupted()) {

            try {

                Order orderTaken = ClientQueues.submittedOrders.take();
                orderTaken.setStatus(Order.Status.Taken.toString());
                Thread.sleep(20);
                System.out.println(orderTaken.toString());
                takenOrders.put(orderTaken);
//                System.out.println("Taken orders queue capacity: " + takenOrders.remainingCapacity());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
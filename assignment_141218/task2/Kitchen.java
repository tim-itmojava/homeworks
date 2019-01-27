package assignment_141218.task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Kitchen implements Runnable {

    protected static final BlockingQueue<Order> completedOrders = new ArrayBlockingQueue<>(60);

    @Override
    public void run() {

        System.out.println("Thread [cooks] " + Thread.currentThread() + " is running...");

        while (!Thread.currentThread().isInterrupted()) {

            try {

                Order orderCompleted = Servant.takenOrders.take();
                Thread.sleep(35);
                orderCompleted.setStatus(Order.Status.Processed.toString());
                System.out.println(orderCompleted.toString());
                completedOrders.put(orderCompleted);
                System.out.println("Taken orders queue capacity: " + Servant.takenOrders.remainingCapacity());
                System.out.println("Completed orders queue capacity: " + completedOrders.remainingCapacity());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

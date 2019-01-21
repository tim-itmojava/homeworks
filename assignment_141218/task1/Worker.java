package assignment_141218.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

    protected static  BlockingQueue<Map<String, Integer>> localMapsQueue = new ArrayBlockingQueue<>(10);

    public Worker() {
    }

    @Override
    public void run() {

        System.out.println("Thread " + Thread.currentThread() + " is running...");

        Map<String, Integer> localMap = new HashMap<>();
        String line;

        try {

            while (!(line = CountTopWordsTest.getLines().take()).equals("STOP")){
                String[] splitLine = line.toLowerCase().replaceAll("\\pP", " ").trim().split("\\s");

                for(String s : splitLine) {
                    if(s.equals(""))
                        continue;
                    localMap.merge(s, 1, (oldVal, newVal)-> oldVal + newVal);
                }
            }

            localMapsQueue.put(localMap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static BlockingQueue<Map<String, Integer>> getLocalMapsQueue() {
        return localMapsQueue;
    }
}

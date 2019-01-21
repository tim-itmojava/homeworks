package assignment_141218.task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CountTopWordsTest {

    protected static BlockingQueue<String> lines = new ArrayBlockingQueue<>(50);

    public static BlockingQueue<String> getLines() {
        return lines;
    }

    public static void main(String[] args) {

        List<Thread> container = new ArrayList<>();
        int workersCount = Runtime.getRuntime().availableProcessors();

        Map<String, Integer> finalMap = new HashMap<>();

        for(int i = 0; i < workersCount; i++) {
            container.add(new Thread(new Worker()));
        }

        Instant start = Instant.now();

        for(Thread t : container) {
            t.start();
        }

        try (BufferedReader buff =
                     new BufferedReader(new InputStreamReader(
                             new FileInputStream("/Users/timursuyargulov/IdeaProjects/homeworks/bible.txt"))))
        {
            String line;
            while ((line = buff.readLine()) != null) {
                lines.put(line);
            }

            for (int i = 0; i < workersCount; i++) lines.put("STOP");

            for (Thread t : container) t.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        for(Map<String, Integer> map : Worker.getLocalMapsQueue()) {
            for (Map.Entry entry : map.entrySet()) {
                finalMap.merge(entry.getKey().toString(), (Integer) entry.getValue(), (oldVal, newVal) -> oldVal + newVal);
            }
        }

//        System.out.println("The resulting map:");
//        finalMap.forEach((k, v) ->
//                System.out.println("key=" + k + ", value=" + v));

        finalMap.entrySet().stream().sorted(
                Map.Entry.<String, Integer>comparingByValue()
                        .reversed())
                        .limit(100)
                        .forEach(System.out::println);

        Instant end = Instant.now();
        System.out.println("Time to create individual hashMaps: " + Duration.between(start, end).toNanos()/1000 + " " + '\u03BC' + "s");

    }

}

package assignment_141218.task1;

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

    public static void getTop100(Map<String, Integer> hashMap) {

        // decoupling the method parameter from the original object to avoid object mutation
        Map<String, Integer> inMap = new HashMap<String, Integer>(hashMap);

        Map<String, Integer> top10Map = new HashMap<>();

        for(int i = 1; i <= 100; i++) {
            Integer j = 0;
            String key = null;
            for (Map.Entry<String, Integer> entry : inMap.entrySet()) {
                if ( entry.getValue() > j) {
                    // System.out.println("control point");
                    j = entry.getValue();
                    key = entry.getKey();
                }
            }

            if (!top10Map.containsKey(key)) top10Map.put(key,j);
            inMap.remove(key, j);
        }

        System.out.println("Top100 list:");
        top10Map.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
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
                             new FileInputStream("/Users/timursuyargulov/IdeaProjects/homeworks/wp.txt"))))
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

        getTop100(finalMap);

        Instant end = Instant.now();
        System.out.println("Time to create individual hashMaps: " + Duration.between(start, end).toNanos()/1000 + " " + '\u03BC' + "s");

    }

}

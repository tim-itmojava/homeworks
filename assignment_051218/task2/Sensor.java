package assignment_051218.task2;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    private List<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

    public void changeTemp(int temp){
        System.out.println("Текущая температура: " + temp);
        for (Alarm alarm: alarms) {
            alarm.tempChanged(temp);
        }
    }
}

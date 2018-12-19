package assignment_051218.task2;

public class Main {

    public static void main(String[] args) {

        Sensor sensor = new Sensor();
        sensor.addAlarm(new Green());
        sensor.addAlarm(new Yellow());
        sensor.addAlarm(new Red());

        for (int i = 95; i<=105; i++) {
            sensor.changeTemp(i);
        }

        for (int i = 295; i<=305; i++) {
            sensor.changeTemp(i);
        }

        for (int i = 595; i<=605; i++) {
            sensor.changeTemp(i);
        }
    }
}

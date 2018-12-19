package assignment_051218.task2;

public class Yellow implements Alarm {
    private int currentTemp;
    @Override
    public void tempChanged(int temp) {
        if (temp>=300 && currentTemp <300) System.out.println("Yellow Alarm!");
        currentTemp = temp;
    }
}

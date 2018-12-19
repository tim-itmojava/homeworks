package assignment_051218.task2;

public class Red implements Alarm {
    private int currentTemp;
    @Override
    public void tempChanged(int temp) {
        if (temp>=600 && currentTemp <600) System.out.println("Red Alarm!");
        currentTemp = temp;
    }
}

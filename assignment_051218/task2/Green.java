package assignment_051218.task2;

public class Green implements Alarm{
    private int currentTemp;
    @Override
    public void tempChanged(int temp) {
        if (temp>=100 && currentTemp <100) System.out.println("Green Alarm!");
        currentTemp = temp;
    }
}

package assignment_6.designclasses.dogshow;

public class Dog {

    // { name, weight, colour, age, address }

    public enum nickName { STRANGER, DWELLER }
    private static double avgWeight = 0;
    private static double avgAge = 0;

    private static int breedCounter;
    private static String commonAddress;

    private String name;
    private int age;
    private double weight;
    private String colour;
    private String address;

    {   // initialising block gets performed for each object creation
        breedCounter++;
        commonAddress = "Bill's Burger House";
    }

    // 1st constructor
    public Dog(String name) {
        this.name = name;
        this.weight = avgWeight;
        this.colour = "BLACK";
        this.age = (int) avgAge;
        this.address = commonAddress;
        updateAvgs();
    }

    // 2nd constructor
    public Dog(String name, double weight, double age) {
        this.name = name;
        this.weight = weight;
        this.colour = "BLACK";
        this.age = (int) age;
        this.address = commonAddress;
        updateAvgs();
    }

    // 3rd constructor
    public Dog(double weight, String colour) {
        this.weight = weight;
        this.colour = colour;
        this.name = String.valueOf(nickName.STRANGER);
        this.age = (int) avgAge;
        this.address = commonAddress;
        updateAvgs();
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void updateAvgs() {
        if (!(this.weight==0)) avgWeight = (avgWeight + this.getWeight())/breedCounter;
        if (!(this.age==0)) avgAge = (avgAge + this.getAge())/breedCounter;
    }

    public static int getBreedCounter() {
        return breedCounter;
    }

    public static int getAvgAge() {
        return (int) avgAge;
    }

    public static void showStaticContext() {
        System.out.println("The average weight is: " + Dog.avgWeight);
        System.out.println("The average age is: " + Dog.avgAge);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", colour='" + colour + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Dog my_dog1 = new Dog("Baloon");
        System.out.println("Number of dogs enrolled into voting: " + Dog.getBreedCounter());
        Dog.showStaticContext();
        System.out.println(my_dog1.toString());

        Dog my_dog2 = new Dog("Baloon", 40,5);
        System.out.println("Number of dogs enrolled into voting: " + Dog.getBreedCounter());
        Dog.showStaticContext();
        System.out.println(my_dog2.toString());

        Dog my_dog3 = new Dog("Baloon", 50, 6);
        System.out.println("Number of dogs enrolled into voting: " + Dog.getBreedCounter());
        Dog.showStaticContext();
        System.out.println(my_dog3.toString());

        Dog my_dog4 = new Dog(65, "BLUE");
        System.out.println("Number of dogs enrolled into voting: " + Dog.getBreedCounter());
        Dog.showStaticContext();
        System.out.println(my_dog4.toString());

        Dog my_dog5 = new OneMoreDog(100,"YELLOW","MOSCOW");
        System.out.println("Number of dogs enrolled into voting: " + Dog.getBreedCounter());
        Dog.showStaticContext();
        System.out.println(my_dog5.toString());

        Dog my_dog6 = new OneMoreDog(200,"КРАСНЫЙ","SYDNEY");
        System.out.println("Number of dogs enrolled into voting: " + Dog.getBreedCounter());
        Dog.showStaticContext();
        System.out.println(my_dog6.toString());

    }
}

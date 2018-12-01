package assignment_6.designclasses.catfight;

abstract public class CatAsFighter {

    protected String name;
    protected int age;
    protected int weight;
    protected int strength;

    public CatAsFighter(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    abstract public boolean fight(CatAsFighter anotherCat);

    abstract public int score();

    public boolean isAlive(){
        return this.strength > 0;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

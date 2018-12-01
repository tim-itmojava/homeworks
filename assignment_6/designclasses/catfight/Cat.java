package assignment_6.designclasses.catfight;

public class Cat extends CatAsFighter {


    public Cat(String name, int age, int weight, int strength) {
        super(name, age, weight, strength);
    }

    @Override
    public boolean fight(CatAsFighter anotherCat) {
        return this.score() >= anotherCat.score();
    }

    @Override
    public int score() {
        return (2*this.getAge() - 3*this.getWeight() + 2*this.getStrength());
        // cat1: 2*8 - 3*5 + 2*20 = 41
        // cat2: 2*7 - 3*7 + 2*25 = 43
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat("Black", 8,5,20);
        Cat cat2 = new Cat("White", 7, 7, 25);

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));

    }
}

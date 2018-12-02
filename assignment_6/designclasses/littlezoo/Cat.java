package assignment_6.designclasses.littlezoo;

public class Cat implements Movable, Eatable, Eat {
    private int xDimension;
    private int yDimension;
    private int height;
    private int health;
    private String name;

    public Cat(int xDimension, int yDimension, int height, int health, String name) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.height = height;
        this.health = health;
        this.name = name;
    }

    // Cat can move

    @Override
    public void crawl(int xDimension, int yDimension) {

    }

    @Override
    public void bounceUp(int height) {

    }

    @Override
    public void jumpDown() {

    }

    @Override
    public void walkAround() {

    }

    // Cat can eat

    @Override
    public void attack() {

    }

    // Cat can be bitten/eaten
    @Override
    public void beingBitten(Object object) {
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

}

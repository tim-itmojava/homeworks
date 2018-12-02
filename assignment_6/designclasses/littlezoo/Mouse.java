package assignment_6.designclasses.littlezoo;

public class Mouse implements Movable, Eatable {

    private int xDimension;
    private int yDimension;
    private int height;
    private int health;
    private String name;

    public Mouse(int xDimension, int yDimension, int height, int health, String name) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.height = height;
        this.health = health;
        this.name = name;
    }

    @Override
    public void beingBitten(Object object) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

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
}

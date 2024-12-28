package matala;

public class Penguin {
    private String name;
    private int age;
    private float height;
    private boolean isLeader;

    public Penguin(String name, int age, float height, boolean isLeader) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isLeader = isLeader;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isLeader=" + isLeader +
                '}';
    }
}


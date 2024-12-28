package matala;

public class Lion {
    private String name;
    private int age;
    private float weight;
    private boolean isMale;

    public Lion(String name, int age, float weight, boolean isMale) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isMale = isMale;
    }

    public boolean isMale() {
        return isMale;
    }


    public int meatCount() {//׳₪׳¢׳•׳׳” ׳”׳׳—׳©׳‘׳× ׳›׳׳” ׳§''׳’ ׳‘׳©׳¨ ׳¦׳¨׳™׳ ׳׳”׳‘׳™׳ ׳׳׳¨׳™׳”
        double meat;
        if (this.isMale()) {
            meat = this.weight * this.age * 0.02;
        } else {
            meat = this.weight * this.age * 0.03;
        }
        if (meat > 25)
            return 25;
        return (int) meat;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", isMale=" + isMale +
                '}';
    }
}

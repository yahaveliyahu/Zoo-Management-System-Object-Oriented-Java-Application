package matala;

import java.util.Arrays;
import java.util.Objects;

public class AquariumFish {
    private int age;
    private float length;
    private String sign;
    private String[] colorsArray;


    public AquariumFish(int age, float length, String sign, String[] colors) {
        this.age = age;
        this.length = length;
        this.sign = sign;
        this.colorsArray = colors;
    }
    public AquariumFish(){
        this.colorsArray=new String[0];
    }

    public String[] getColorsArray() {
        return colorsArray;
    }

    public void addColor(String color){
        colorsArray = Arrays.copyOf(colorsArray, colorsArray.length + 1);
        colorsArray[colorsArray.length - 1] = color;
    }
    public boolean isColorExist(String color) {
        for (String s : colorsArray) {
            if (Objects.equals(s, color)) {
                return true;
            }
        }
        return false;
    }
    public float foodCount() {
        if (this.age < 3)
            return 3;
        return this.length + 3;
    }

    @Override
    public String toString() {
        return
                "{age=" + age +
                        ", length=" + String.format("%.2f",length) +
                        ", sign='" + sign + '\'' +
                        ", colors=" + Arrays.toString(colorsArray) +
                        '}';
    }
}

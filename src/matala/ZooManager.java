package matala;

import java.util.Arrays;
import java.util.Random;

public class ZooManager {
    private final String zooName;
    private final Address zooAddress;
    private final String[] fishColors = {"Black", "White", "Green", "Orange", "Blue", "Yellow", "Brown", "Gold", "Red", "Cyan"};
    private final String[] fishPattern = {"Dots", "Strips", "Stains", "Blank"};
    private Lion[] lionArray = new Lion[0];
    private Penguin[] penguinsArray = new Penguin[0];
    private AquariumFish[] fishArray = new AquariumFish[0];

    public void setLionArray(Lion[] lionArray) {
        this.lionArray = lionArray;
    }

    public void setPenguinsArray(Penguin[] penguinsArray) {
        this.penguinsArray = penguinsArray;
    }

    public void setFishArray(AquariumFish[] fishArray) {
        this.fishArray = fishArray;
    }

    public Lion[] getLionArray() {
        return lionArray;
    }

    public Penguin[] getPenguinsArray() {
        return penguinsArray;
    }

    public AquariumFish[] getFishArray() {
        return fishArray;
    }
    @Override
    public String toString() {
        return "Zoo name: '" + zooName + '\'' +
                ", it's address: " + zooAddress;
    }
    public ZooManager() {
        this.zooName = "Hatanachi Zoo";
        this.zooAddress = new Address("Jerusalem", "Aharon Shuluv", "1");
    }
    public void builtInAnimals() {
        Penguin leader = new Penguin("Skeeper", 10, 200, true);//Leader penguin
        penguinsArray = Arrays.copyOf(penguinsArray, penguinsArray.length + 3);
        penguinsArray[0] = leader;
        Penguin p1 = new Penguin("Private", 8, 180, false);
        penguinsArray[1] = p1;
        Penguin p2 = new Penguin("Ricco", 5, 170, false);
        penguinsArray[2] = p2;

        Lion l1 = new Lion("Mufasa", 25, 60, true);// Male that eats 25 Kg of meat
        Lion l2 = new Lion("Simba", 5, 30, true);// Male that eats less than 25 Kg of meat
        Lion l3 = new Lion("Sarabi", 23, 40, false);// Female that eats 25 Kg of meat
        Lion l4 = new Lion("Nala", 7, 30, false);// Female that eats less than 25 Kg of meat
        lionArray = Arrays.copyOf(lionArray, lionArray.length + 4);
        lionArray[0] = l1;
        lionArray[1] = l2;
        lionArray[2] = l3;
        lionArray[3] = l4;

        addFish(10);

    }
    public  void addFish(int num) {
        fishArray = new AquariumFish[num];//it's the start program so this Array has 0 fish in it
        int numOfColors, colorNum, age, patternNum;
        float length;
        String pattern;
        String[] colors = new String[0];
        Random r = new Random();
        for (int i = 0; i < num; i++) {//create num of fish
            numOfColors = r.nextInt(10) + 1;// number of colors a fish have
            age = r.nextInt(10) + 1;
            length = r.nextFloat() + r.nextInt(20);
            patternNum = r.nextInt(4);// choose a random pattern
            pattern = fishPattern[patternNum];
            colors = new String[0];
            AquariumFish fish = new AquariumFish(age, length, pattern, colors);
            colorNum = r.nextInt(10);
            for (int j = 0; j < numOfColors; j++) {
                do {
                    colorNum = r.nextInt(10);//if color exist in the fish, get another random number until you get a color that the fish doesn't have yet
                } while (fish.isColorExist(fishColors[colorNum]));
                fish.addColor(fishColors[colorNum]);
            }
            fishArray[i] = fish;
        }
    }



}

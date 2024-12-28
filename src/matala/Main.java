/** submitting:
    Yahav Eliyahu 315906818,
    Matanya Cohen 312522196,
    Arad Rotem 207748468
**/


package matala;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner s = new Scanner(System.in);
    private final static String[] MENU = {
            "Exit Program",
            "Show Zoo Details",
            "Add a Penguin",
            "Add a Lion",
            "Add a Fish",
            "Show Penguins",
            "Show Lions",
            "Show Fishes",
            "Feed The Animals"
    };

    public static ZooManager zoo = new ZooManager();

    public static void main(String[] args) {

        zoo.builtInAnimals();//Hard coded that was required
        run();
        s.close();
    }


    public static void run() {
        int choice;
        do {

            choice = showMenu();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program, GOODBYE!");
                    break;
                case 1:
                    showZoo(zoo);
                    break;
                case 2:
                    addPenguin();
                    break;
                case 3:
                    addLion();
                    break;
                case 4:
                    addFish();
                    break;
                case 5:
                    showPenguin();
                    break;
                case 6:
                    showLion();
                    break;
                case 7:
                    showFish();
                    break;
                case 8:
                    FeedTheAnimals();
                    break;
                default:
                    System.out.println("Invalid option, try again.");
                    break;

            }
        }
        while (choice != 0);
    }

    private static int showMenu() {
        System.out.println("\n Program Menu: \n");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ") " + MENU[i]);
        }
        System.out.println("Enter your chose:");
        return s.nextInt();
    }

    public static void showZoo(ZooManager z) {
        System.out.println(z.toString());
        System.out.println("The Zoo have:");
        System.out.println(zoo.getPenguinsArray().length + " Penguins");
        System.out.println(zoo.getLionArray().length + " Lions");
        System.out.println("And " + zoo.getFishArray().length + " Fishes");


    }

    private static void showFish() {
        AquariumFish allFishColor = new AquariumFish();// we'll create an empty fish and use only his colorsArray functions to make an array of all the colors in the Aquarium
        for (AquariumFish fish : zoo.getFishArray()) {
            System.out.println(fish.toString());
            for (int i = 0; i < fish.getColorsArray().length; i++) {
                if (allFishColor.getColorsArray() != null) {
                    if (!allFishColor.isColorExist(fish.getColorsArray()[i])) {
                        allFishColor.addColor(fish.getColorsArray()[i]);
                    }
                } else {
                    allFishColor.addColor(fish.getColorsArray()[i]);
                }
            }
        }
        String colors = "";
        for (int i = 0; i < allFishColor.getColorsArray().length; i++) {
            if (i == allFishColor.getColorsArray().length - 1) {
                colors += "and " + allFishColor.getColorsArray()[i].toString();
            } else {
                colors += allFishColor.getColorsArray()[i].toString() + ", ";
            }
        }
        System.out.println("The fishes in the Aquarium have the colors: " + colors);
    }






    private static void showLion() {
        for (Lion l : zoo.getLionArray()) {
            System.out.println(l.toString());
        }
    }

    private static void showPenguin() {
        for (Penguin p : zoo.getPenguinsArray()) {
            System.out.println(p.toString());
        }
    }

    public static void FeedTheAnimals() {
        System.out.println("The animals are being fed.");
        float fishFood = 0;
        for (AquariumFish Fish : zoo.getFishArray()) {
            fishFood += Fish.foodCount();
        }
        System.out.println("The fishes ate " + String.format("%.2f", fishFood) + " food portions for " + zoo.getFishArray().length + " fishes");//print the float with only 2 numbers after the dot

        int penguinFood = zoo.getPenguinsArray().length;
        System.out.println("The Penguins ate " + penguinFood + " Fishes for " + zoo.getPenguinsArray().length + " Penguins");

        int lionFood = 0;
        for (Lion lion : zoo.getLionArray()) {
            lionFood += lion.meatCount();
        }
        System.out.println("The Lions ate " + lionFood + " kg of meat for " + zoo.getLionArray().length + " Lions");
    }

    public static void addFish() {
        AquariumFish[] newFishArray = Arrays.copyOf(zoo.getFishArray(), zoo.getFishArray().length + 1);
        int age = 0, numColors = 0;
        float length = 0;
        String pattern = "", color = "";

        try {
            System.out.print("Enter fish age: ");
            age = s.nextInt();
            if (age <= 0) {
                throw new IllegalArgumentException("Invalid age! The age must be greater than 0.");
            }
         //   System.out.println("The fish age: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the input is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number of age (over 0): ");
            s.next(); // Clear the invalid input from the scanner
            return;
        }

        try {
            System.out.print("Enter fish length (in float): ");
            length = s.nextFloat();
            if (length <= 0) {
                throw new IllegalArgumentException("Invalid length! The length must be greater than 0.");
            }
            System.out.println("The fish's length is: " + length);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the input is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number of length (over 0).");
            s.next(); // Clear the invalid input from the scanner
            return;
        }

        try {
            System.out.println("Enter fish pattern (Dots, Strips, Stains, Blank): ");
            pattern = s.next();
            if (!pattern.equalsIgnoreCase("Dots") &&
                    !pattern.equalsIgnoreCase("Strips") &&
                    !pattern.equalsIgnoreCase("Stains") &&
                    !pattern.equalsIgnoreCase("Blank")) {
                throw new IllegalArgumentException("Invalid pattern. Please enter a valid fish pattern (Dots, Strips, Stains, Blank).");
            }
            // Capitalize the first letter and make the rest lowercase
            pattern = pattern.substring(0, 1).toUpperCase() + pattern.substring(1).toLowerCase();
        //    System.out.println("The fish pattern is: " + pattern);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the pattern is invalid
        }

        try {
            System.out.println("How many colors does the fish have? ");
            numColors = s.nextInt();
            if (numColors > 10 || numColors < 1) {
                throw new IllegalArgumentException("Invalid number of colors! A fish cannot have more than 10 colors or be colorless (considering that the fish can only be of the above 10 colors).");
            }
         //   System.out.println("The fish has " + numColors + " colors.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the input is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number of colors (up to 10).");
            s.next(); // Clear the invalid input from the scanner
            return;
        }

        String[] colors = new String[numColors];
        AquariumFish fish = new AquariumFish(age, length, pattern, colors);

        for (int i = 0; i < numColors; i++) {
            boolean validColor = false;
            boolean colorExists = false;
            try {
                System.out.println("Enter a color (Black, White, Green, Orange, Blue, Yellow, Brown, Gold, Red, Cyan): ");
                color = s.next();
                if (!color.equalsIgnoreCase("Black") && !color.equalsIgnoreCase("White") &&
                        !color.equalsIgnoreCase("Green") && !color.equalsIgnoreCase("Orange") &&
                        !color.equalsIgnoreCase("Blue") && !color.equalsIgnoreCase("Yellow") &&
                        !color.equalsIgnoreCase("Brown") && !color.equalsIgnoreCase("Gold") &&
                        !color.equalsIgnoreCase("Red") && !color.equalsIgnoreCase("Cyan")) {
                    throw new IllegalArgumentException("Invalid color. Please enter a valid color (Black, White, Green, Orange, Blue, Yellow, Brown, Gold, Red, Cyan).");
                }
                validColor = true;
                color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return; // Exit early if the pattern is invalid
            }

            if (validColor) {
                try {
                    if (fish.isColorExist(color)) {
                        throw new IllegalArgumentException("This fish already has this color. Please enter a different color.");
                    }
                    colorExists = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                if (!colorExists) {
                    fish.addColor(color);
                }
            }
        }
        newFishArray[newFishArray.length - 1] = fish;
        zoo.setFishArray(newFishArray);
    }

    public static void addLion() {
        String name = "";
        int age = 0;
        float weight = 0;
        boolean isMale = false;

        try {
            System.out.println("Enter a name of lion: ");
            name = s.next();
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("Invalid name. The name must contain at least one letter or digit, and no special characters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the name is invalid
        }

        try {
            System.out.println("Enter an age of lion: ");
            age = s.nextInt();
            if (age <= 0) {
                throw new IllegalArgumentException("It is not possible for the age to be 0 or less than that.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the age is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number of age (over 0).");
            s.next(); // Clear the invalid input
            return;
        }

        try {
            System.out.println("Enter a weight of lion: ");
            weight = s.nextFloat();
            if (weight <= 0) {
                throw new IllegalArgumentException("It is not possible for the weight to be 0 or less than that.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the weight is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number of weight (over 0).");
            s.next(); // Clear the invalid input
            return;
        }

        try {
            System.out.println("The lion is male? (true/false): ");
            isMale = s.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter true or false.");
            s.next(); // to clear the incorrect input from the scanner
            return; // Exit early if the input for gender is invalid
        }

        Lion lion = new Lion(name, age, weight, isMale);
        Lion[] newLionArray = Arrays.copyOf(zoo.getLionArray(), zoo.getLionArray().length + 1);
        newLionArray[newLionArray.length - 1] = lion;
        zoo.setLionArray(newLionArray);
    }

    public static void addPenguin() {
        String name = "";
        int age = 0;
        float height = 0;

        try {
            System.out.println("Enter Penguin name: ");
            name = s.next();
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("Invalid name. The name must contain at least one letter or digit, and no special characters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the name is invalid
        }

        try {
            System.out.println("Enter Penguin age: ");
            age = s.nextInt();
            if (age <= 0) {
                throw new IllegalArgumentException("It is not possible for the age to be 0 or less than that.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the age is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number for the age (greater than 0).");
            s.next(); // Clear the invalid input from the scanner
            return;
        }

        try {
            System.out.println("Enter Penguin height: ");
            height = s.nextFloat();
            if (height >= 200 || height < 1) {
                throw new IllegalArgumentException("The penguin must be shorter than the leader penguin and its height must be greater than 0.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit early if the age is invalid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number for the height.");
            s.next(); // Clear the invalid input from the scanner
            return;
        }

        Penguin p = new Penguin(name, age, height, false); // the leader is already chosen, so new penguin can't be the leader
        int penguinplace = zoo.getPenguinsArray().length; // default place at the end of the array

        // Check where this penguin should be in the line based on height
        for (int i = 0; i < zoo.getPenguinsArray().length; i++) {
            if (height > zoo.getPenguinsArray()[i].getHeight()) {
                penguinplace = i;
                break;
            }
        }

        Penguin[] newPenguinsArray = Arrays.copyOf(zoo.getPenguinsArray(), zoo.getPenguinsArray().length + 1);

        // Shift penguins to the right to make space for the new one
        for (int j = newPenguinsArray.length - 1; j > penguinplace; j--) {
            newPenguinsArray[j] = newPenguinsArray[j - 1];
        }

        newPenguinsArray[penguinplace] = p;
        zoo.setPenguinsArray(newPenguinsArray);
    }
}
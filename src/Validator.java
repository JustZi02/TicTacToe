import java.util.Scanner;

public class Validator {

    public static Scanner in = new Scanner(System.in);

    public static int validateInteger() {
        while (!in.hasNextInt()) {
            System.out.println("Enter a valid integer.");
            in.nextLine();
        }
        return in.nextInt();
    }

    public static String validateString() {
        while (!in.hasNextLine()) {
            System.out.println("Enter a valid string!");
            in.nextLine();
        }
        return in.nextLine();
    }

}

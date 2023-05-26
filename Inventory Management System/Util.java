import java.util.Scanner;

/* class for clearing and pausing the console */
class Util {
    private static Scanner input = new Scanner(System.in);

    /* static method to clear the console */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /* static method to pause the console */
    public static void pause() {
        System.out.print("\nPress enter to continue...");
        input.nextLine();
    }
}
package no.ntnu;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Represents the text based user interface of the application.
 * This class makes use of the Scanner-class to get input from the
 * user via the standard console.
 *
 * To be used by the students in Ålesund and Gjøvik (IDATA1001/IDATG1001)
 *
 * @author arne
 * @version 2021-12-02
 */
public class LongJumpUI {

    private final LongJumpRegister jumpRegister;
    private static final String VERSION = "v1.0-SNAPSHOT";

    String[] menuItems
            = {
            "1. Register a long jump result",
            "2. List all results",
            "3. Show all results by a given athlete",
            "4. Show the best result",
            "5. Calculate the avarage result"
    };

    // Constants defining the different menu options, to be used in the
    // switch-case.
    private static final int ADD_RESULT = 1;
    private static final int LIST_ALL_RESULTS = 2;
    private static final int SHOW_RESULT_BY_ATHLETE = 3;
    private static final int SHOW_BEST_RESULT = 4;
    private static final int CALCULATE_AVERAGE_RESULT = 5;
    private static final int EXIT = 6;

    /**
     * Creates an instance of the no.ntnu.LongJumpUI User interface.
     */
    public LongJumpUI() {
        this.jumpRegister = new LongJumpRegister();
    }

    public void init() {
        fillRegisterWithLongJumps();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user. Continues until the user decides to exit the application.
     */
    void start() {
        fillRegisterWithLongJumps();
        boolean quit = false;

        while (!quit) {
            int menuSelection = this.getMenuChoice();
            switch (menuSelection) {
                case ADD_RESULT:
                    addNewLongJump();
                    System.out.println("TEST: You selected the ADD_RESULT");
                    break;

                case LIST_ALL_RESULTS:
                    listAllLongJumps();
                    System.out.println("TEST: You selected the LIST_ALL_RESULTS");
                    break;

                case SHOW_RESULT_BY_ATHLETE:
                    showLongJumpsByAthlete();
                    System.out.println("TEST: You selected the SHOW_RESULT_BY_ATHLETE");
                    break;

                case SHOW_BEST_RESULT:
                    showBestResult();
                    System.out.println("TEST: You selected the SHOW_BEST_RESULT");
                    break;

                case CALCULATE_AVERAGE_RESULT:
                    showAverageResult();
                    System.out.println("TEST: You selected the CALCULATE_AVERAGE_RESULT");
                    break;

                case EXIT:
                    System.out.println("\nThank you for using the Long Jump Application "
                            + VERSION + ". Bye!\n");
                    quit = true;
                    break;

                default:
                    System.out.println(
                            "\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items..
     * The method returns the input from the user. If the input from the user is
     * invalid, 0 is returned.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     */
    private int getMenuChoice() {
        int menuSelection = 0;

        System.out.println("\n**** Long Jump Results Tool " + VERSION + " ****\n");
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        if (reader.hasNextInt()) {
            menuSelection = reader.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuSelection;
    }

    /**
     * Adds a new longjump to the register, it takes input from the user using the terminal
     * and if the user submits all the input is valid a new longjump will be added to the register,
     * if the input is invalid the user will be informed and needs to start over.
     */
    public void addNewLongJump() {
        int startNumber = 0;
        String name = "";
        double jumpLength = 0.0;
        boolean validJump = false;
        String timeJumpedString = "";

        boolean userInputValidSoFar = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details about the long jump to be added");

        //Startnumber
        System.out.println("A positive startnumber");
        if (scanner.hasNextInt()) {
            startNumber = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid input");
            userInputValidSoFar = false;
        }

        //Athlete name
        if (userInputValidSoFar){
            System.out.println("The name of the athlete");
            name = scanner.nextLine();
        } else {
            System.out.println("Invalid input");
            userInputValidSoFar = false;
        }

        //Length of the jump
        if (userInputValidSoFar){
            System.out.println("The length of the jump - use a comma :-)");
            jumpLength = scanner.nextDouble();
        } else {
            System.out.println("Invalid input");
            userInputValidSoFar = false;
        }

        //Jump validity
        if (userInputValidSoFar){
            System.out.println("If the jump is valid or not, true if valid, false if invalid");
            validJump = scanner.nextBoolean();
            scanner.nextLine();
        } else {
            System.out.println("Invalid input");
            userInputValidSoFar = false;
        }

        //Time of the jump
        if (userInputValidSoFar){
            System.out.println("The time of the jump in format HH:MM");
            timeJumpedString = scanner.nextLine();
        } else {
            System.out.println("Invalid input");
            userInputValidSoFar = false;
        }

        //Register everything and create a new longjump if input is OK
        if(userInputValidSoFar){
            LongJump longJump = new LongJump(startNumber, name, jumpLength, validJump, LocalTime.parse(timeJumpedString));
            this.jumpRegister.addLongJump(longJump);
            System.out.println("New long jump successfully added!: ");
            displayLongJumpInformation(longJump);
        } else {
            System.out.println("Something went wrong, please try again");
        }
    }

    /**
     * Lists all the longjumps in the register.
     */
    public void listAllLongJumps() {
        Iterator<LongJump> it = this.jumpRegister.getAllJumps();

        if (this.jumpRegister.getNumberOfJumps() == 0) {
            System.out.println("There are no jumps registered");
        } else {
            System.out.println("List of all the jumps in the register");
            while (it.hasNext()) {
                LongJump longJump = it.next();
                displayLongJumpInformation(longJump);
            }
        }
    }

    /**
     * Shows all the longjumps performed by e certain athlete's startnumber.
     */
    public void showLongJumpsByAthlete() {
        System.out.println("Enter the athlete's start number");
        Scanner scanner = new Scanner(System.in);
        int startNumberSearchedFor = scanner.nextInt();
        if (startNumberSearchedFor < 0) {
            System.out.println("Please enter a valid startnumber");
        } else {
            System.out.println("Listing athlete the found athlete's registered jumps");
            Iterator<LongJump> it = jumpRegister.findAllJumpsByStartNumber(startNumberSearchedFor).iterator();
            while (it.hasNext()) {
                LongJump l = it.next();
                displayLongJumpInformation(l);
            }
        }
    }

    /**
     * Displays the longest jump length in the register.
     */
    public void showBestResult() {
        System.out.println("Displaying the longest jump so far");
        displayLongJumpInformation(jumpRegister.getLongestJump());
    }

    /**
     * Displays the average jump length in the register.
     */
    public void showAverageResult() {
        System.out.println("The average jump length is " + jumpRegister.calculateAverageJumpLength());

    }
    /**
     * The main start method of the application.
     *
     * @param args Commandline arguments as an array of String
     */
    public static void main(String[] args) {
        LongJumpUI longJumpUI = new LongJumpUI();
        longJumpUI.start();

    }

    /**
     * Displays the details of the given longjump.
     *
     * @param longJump the longjump to display.
     */
    private void displayLongJumpInformation(LongJump longJump) {
        if (longJump == null) {
            System.out.println("could not display information");
        }
        String displayString =
                "Startnumber: " + longJump.getStartNumber() + "\n" +
                "Athelete name: " + longJump.getName() + "\n" +
                "Jump length: " + longJump.getJumpLength() + "\n" +
                "Is the jump valid: " + longJump.isValidJump() + "\n" +
                "The time the jump was performed " + longJump.getTimeJumped() + "\n" +
                "";

        System.out.println(displayString);
    }

    /**
     * Fills the register with dummy data for testing purposes.
     */
    private void fillRegisterWithLongJumps() {
        this.jumpRegister.addLongJump(new LongJump(10, "Jakob Arnsesen", 3.9, true, LocalTime.parse("06:30")));
        this.jumpRegister.addLongJump(new LongJump(10, "Jakob Arnsesen", 6.9, false, LocalTime.parse("07:30")));
        this.jumpRegister.addLongJump(new LongJump(90, "Kjell Ange", 6.4, true, LocalTime.parse("09:30")));
    }

}

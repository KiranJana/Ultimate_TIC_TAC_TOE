import java.util.Scanner;
public class HPlayer extends APlayer{ // extends APlayer.

    // Variables for the class and scanner.
    int selectBoard; // To select the 9 boards.
    int box; // To select the 9 boxes.
    Scanner input = new Scanner(System.in); // to take in user input.

    public HPlayer(String name, Character symbol)
    {
        super(name, symbol);
    } // Constructor that calls super and initializes name and symbol.


    // Method that allows the player to select a box between index (0-8) but box 1-9.
    public int selectBox()
    {
        // Getting user input.
        System.out.print("Please Select a Box between 1-9: ");
        box = input.nextInt();

        // Validating if the user entered a valid value. If not display error message.
        while(box > 9 || box < 1 )
        {
            System.out.println("ERROR Invalid Box Selected, PLease Try Again"); // Error message
            System.out.println("Please Select a Valid Box between 1-9: "); // Retaking in values.
            box = input.nextInt(); // taking in user input.
        }
        return box -1; // Returning box -1 as boxes are still 0-8.
    }

    // Method to select Board.
    public int selectBoard()
    {
        // Taking in user input.
        System.out.print("Please Select a Board between 1-9: ");
        selectBoard = input.nextInt();

        // Validating if the entered number is in bounds.
        while(selectBoard > 9 || selectBoard < 1)
        {
            System.out.println("ERROR Invalid Board Selected, PLease Try Again");  // Error Message
            System.out.print("Please Select a Valid Board between 1-9: "); // Re taking in values.
            selectBoard = input.nextInt();
        }
        return selectBoard -1; // Returning board-1 as Boards are indexed 0-8.
    }


}

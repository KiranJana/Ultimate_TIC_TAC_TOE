public class DriverMain {

    /* Hari Kiran Jana  : CS 2336.002 */

    /* The main purpose of this project was to create a Ultimate Tic-Tac-Toe made of smaller Tic-Tac-Toe boards.
       Moreover, we also had to implement two players one being a computer player and a Human player.*/

    /* I started this project by creating a Box class that would hold the symbol of the players. This Box class would represent the smallest
    * level of a single Board and would have nine elements. Then I created another level called Board which is collection of boxes, in this case
    * 9 boxes. We use setter and getters to change the contents of the boxes. Furthermore, multiple methods to check if the Boxes are full, winner of each board.
    * Then I moved up another level and Implemented the Ultimate Board, 9 Normal Boards. I Implemented two players using Polymorphism so that the user
    * can switch between Human VS Human to Computer VS Human. I also accounted for out of bounds error that may occur due to mistyping.*/


    public static void main(String[] args) {
        UTTGame UTT = new UTTGame(new ComputerPlayer("Player1", 'X'), new ComputerPlayer("Player2", 'O')); // Initializing a new game with two players or type human or computer.
        System.out.println("WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME: "); // Welcome message.
        UTT.start(); // call to the start method on UTT_GAME.
    }

}

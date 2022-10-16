public class ComputerPlayer extends APlayer{ // Extends APlayer.

    // Constructor that initializes the variables using a super call.
    public ComputerPlayer(String name, Character symbol)
    {
        super(name, symbol);

    }

    // Implementing the abstract methods from the super class.
    @Override
    public int selectBoard() {
        return (int) (Math.random()*9); // returning a random number between 1 - 9.
    }
    @Override
    public int selectBox() {
        return (int) (Math.random()*9);
    } // returning a random number between 1-9.
}

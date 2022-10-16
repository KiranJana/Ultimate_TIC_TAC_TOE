public abstract class ABoard {

    // Abstract methods for the Board class.
    public ABoard() {
    }



    public abstract boolean isWinner();

    public abstract boolean isFull();


    public abstract boolean move(int value, char mark);

}

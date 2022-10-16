public class Board extends ABoard{
    final int size = 9; // size of the board.
    Box [] Sqaures = new Box[size]; // Array of 9 boxes.
    Character winner = 'k'; // winner is empty before the game.

    // Constructor.
    public Board()
    {
        // Initializing 9 boxes to create a board.
        for(int i = 0; i < size; i++)
        {
            Sqaures[i] = new Box();
            Sqaures[i].setValue('_');
        }

    }

    // Method the checks the winner of the board by rows, columns and diagonal.
    public boolean isWinner()
    {
        if((Sqaures[0].getContent()!='_')&&(Sqaures[0].getContent().equals(Sqaures[1].getContent()))&&(Sqaures[0].getContent().equals(Sqaures[2].getContent()))){
            setWinner(Sqaures[0].getContent()); // Checking first row and setting winner.
            return true;
        }

        else if((Sqaures[3].getContent()!='_')&&(Sqaures[3].getContent().equals(Sqaures[4].getContent()))&&(Sqaures[3].getContent().equals(Sqaures[5].getContent()))){
            setWinner(Sqaures[3].getContent());  //Checking second row and setting winner.
            return true;
        }

        else if((Sqaures[6].getContent()!='_')&&(Sqaures[6].getContent().equals(Sqaures[7].getContent()))&&(Sqaures[6].getContent().equals(Sqaures[8].getContent()))){
            setWinner(Sqaures[6].getContent());  //Checking third row and setting winner.
            return true;
        }

        else if((Sqaures[0].getContent()!='_')&&(Sqaures[0].getContent().equals(Sqaures[3].getContent()))&&(Sqaures[0].getContent().equals(Sqaures[6].getContent()))){
            setWinner(Sqaures[0].getContent());  //Checking first column and setting winner.
            return true;
        }

        else if((Sqaures[1].getContent()!='_')&&(Sqaures[1].getContent().equals(Sqaures[4].getContent()))&&(Sqaures[1].getContent().equals(Sqaures[7].getContent()))){
            setWinner(Sqaures[1].getContent());  //Checking second column and setting winner.
            return true;
        }

        else if((Sqaures[2].getContent()!='_')&&(Sqaures[2].getContent().equals(Sqaures[5].getContent()))&&(Sqaures[2].getContent().equals(Sqaures[8].getContent()))){
            setWinner(Sqaures[2].getContent()); //Checking third column and setting winner.
            return true;
        }

        else if((Sqaures[0].getContent()!='_')&&(Sqaures[0].getContent().equals(Sqaures[4].getContent()))&&(Sqaures[0].getContent().equals(Sqaures[8].getContent()))){
            setWinner(Sqaures[0].getContent());  ////Checking first diagonal and setting winner.
            return true;
        }

        else if((Sqaures[2].getContent()!='_')&&(Sqaures[2].getContent().equals(Sqaures[4].getContent()))&&(Sqaures[2].getContent().equals(Sqaures[6].getContent()))){
            setWinner(Sqaures[2].getContent());  //Checking second diagonal and setting winner.
            return true;
        }

        return false;
    }

    // Getter and Setter methods for Winner.
    public Character getWinner() {
        return winner;
    }
    public void setWinner(Character winner)
    {
        this.winner = winner;
    }

    // Method to check if the board is full or not.
    public boolean isFull()
    {
        for(int i = 0; i < Sqaures.length; i++)
        {
            if(Sqaures[i].getContent().equals('_')) {
                return false; // if it is an underscore that means its empty.
            }
        }
        return true; // if the is not an underscore it is not empty.
    }




    // Checks if the board has been won.
    public boolean hasWon()
    {
        return (!winner.equals('k'));
    }

    // This method is to make a move on the boxes and to set the symbol of the box to that of the player.
    public boolean move(int value, char symbol)
    {
        if(Sqaures[value].setValue(symbol)) {
            return true;
        }
        return false; // Returns false if no move was made.
    }

}

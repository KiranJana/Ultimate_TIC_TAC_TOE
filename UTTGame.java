import java.sql.SQLOutput;

public class UTTGame {

    // Variables used in this class.
    int size = 9; // Size of the board.
    int currentPlayer; // Stores who the current player is.
    Board[] UTBoard = new Board[size];  // Array of 9 Boards.
    APlayer[] Player = new APlayer[2]; // Initializing two new Players of type Abstract.
    int selectBoard; // Holds which board we are on currently.
    int firstTurn; // Variable to check if its first turn.
    int currentBox; // Holds what box we are on currently.
    int previousBox; // To keep track of Boxes in case of Invalid input.


    // Constructor.
    public UTTGame(APlayer player1, APlayer player2)
    {
        // Initializing 9 Boards to create the Ultimate Board and players for the board.
        for(int i = 0; i < size; i++)
        {
            UTBoard[i] = new Board();
        }

        this.Player[0] = player1;
        this.Player[1] = player2;

        // Setting current player and first turn to one.
        currentPlayer = 1;
        firstTurn = 1;
    }


    // Method that runs the game.
    public void start()
    {
        // Do while loop to iterate until we have a winner.
        do
        {
            changePlayer(); // We begin by changing player, to alternate between the two players.
            print(); // Print the Board.
            boardWinners(); // Check if there are any individual board winners.
            System.out.println("The Current Player is : " + Player[currentPlayer].getSymbol()); // This shows who the current player is with their Symbol.
            if(firstTurn == 1 || UTBoard[selectBoard].isFull()) // Validating when the player can select a different Board. IT would be in the beginning or when a board is full.
            {
                selectBoard = Player[currentPlayer].selectBoard(); // Allowing the player to select a New Board.
                firstTurn++; // Incrementing first turn as there is only one firstturn.
            }
            else
            {
                selectBoard = currentBox; // If Board isn't full nor its th3e first turn select a Box.
            }

            System.out.println("You are currently on Board # " + (selectBoard + 1)); // This shows the Players what board they are currently on.
            currentBox = Player[currentPlayer].selectBox(); // This lets players select a Box in a board, and it alternates based on the current player.
            previousBox = selectBoard; // This is to remember the previous Board.

            // Validating if the board of the play has already been won if not check to see if there is a winner.
            if(UTBoard[selectBoard].move(currentBox, Player[currentPlayer].getSymbol()))
            {
                if(!UTBoard[selectBoard].hasWon()) // Checking if a player has already won the current board.
                {
                    UTBoard[selectBoard].isWinner();
                }
                selectBoard = currentBox;
                continue;
            }
            // Error statement for playing on a box that is already taken.
            else
            {
                System.out.println("INVALID MOVE, Box is already Occupied");
                changePlayer(); // We switch players so the current player gets to correct his mistake when the loop runs again.
                currentBox = previousBox; // We move back to where the player was before the mistake.
            }


        } while(!isGameOver()); // Iterates until the game is over.

    }

    // Method checks if there is a winner or if the Game is a tie.
    public boolean isGameOver()
    {
        // Validating if there is a winner and Printing the boards that each player won and the Final Board.
        if(isWinner())
        {
            System.out.println("THE FINAL BOARD: ");
            print();
            boardWinners();
            isWinner();
            return true;
        }
        // Validating if there is no winner and Printing it is a Tie.
        else if(isFull())
        {
            System.out.println("THE FINAL BOARD: ");
            print();
            boardWinners();
            System.out.println("NO ONE HAS WON: ");
            return true;
        }
        return false;
    }

    // Method that validating winner of the UTT board by horizontal, vertical or diagonal.
    public boolean isWinner()
    {
        // Checking if first row of boards have a winner.
        if((UTBoard[0].getWinner().equals(UTBoard[1].getWinner()))&&(UTBoard[0].hasWon())&&(UTBoard[0].getWinner().equals(UTBoard[2].getWinner()))){
            System.out.println(UTBoard[0].getWinner()+" has won"); //displays winner
            return true;
        }
        // Checking if second row of boards have a winner.
        else if((UTBoard[3].getWinner().equals(UTBoard[4].getWinner()))&&(UTBoard[3].hasWon())&&(UTBoard[3].getWinner().equals(UTBoard[5].getWinner()))){
            System.out.println(UTBoard[3].getWinner()+" has won");    //displays winner
            return true;
        }
        // Checking if third row of boards have a winner.
        else if((UTBoard[6].getWinner().equals(UTBoard[7].getWinner()))&&(UTBoard[6].hasWon())&&(UTBoard[6].getWinner().equals(UTBoard[8].getWinner()))){
            System.out.println(UTBoard[6].getWinner()+" has won");    //displays winner
            return true;
        }
        //Checking if first column of boards have a winner.
        else if((UTBoard[0].getWinner().equals(UTBoard[3].getWinner()))&&(UTBoard[0].hasWon())&&(UTBoard[0].getWinner().equals(UTBoard[6].getWinner()))){
            System.out.println(UTBoard[0].getWinner()+" has won");    //displays winner
            return true;
        }
        //Checking if second column of boards have a winner.
        else if((UTBoard[1].getWinner().equals(UTBoard[4].getWinner()))&&(UTBoard[1].hasWon())&&(UTBoard[1].getWinner().equals(UTBoard[7].getWinner()))){
            System.out.println(UTBoard[1].getWinner()+" has won");    //displays winner
            return true;
        }
        //Checking if third column of boards have a winner.
        else if((UTBoard[2].getWinner().equals(UTBoard[5].getWinner()))&&(UTBoard[2].hasWon())&&(UTBoard[2].getWinner().equals(UTBoard[8].getWinner()))){
            System.out.println(UTBoard[2].getWinner()+" has won");    //displays winner
            return true;
        }
        //Checking if the first diagonal of boards have a winner.
        else if((UTBoard[0].getWinner().equals(UTBoard[4].getWinner()))&&(UTBoard[0].hasWon())&&(UTBoard[0].getWinner().equals(UTBoard[8].getWinner()))){
            System.out.println(UTBoard[0].getWinner()+" has won");    //displays winner
            return true;
        }
        //Checking if the second diagonal of boards have a winner.
        else if((UTBoard[2].getWinner().equals(UTBoard[4].getWinner()))&&(UTBoard[2].hasWon())&&(UTBoard[2].getWinner().equals(UTBoard[6].getWinner()))){
            System.out.println(UTBoard[2].getWinner()+" has won");    //displays winner
            return true;
        }

        return false;
    }

    // Method checks if the board is full and return true if it is.
    public boolean isFull()
    {
        // Iterating through the Boards.
        for(int i = 0; i < UTBoard.length; i++ )
        {
            if(!UTBoard[i].isFull())
            {
                return false; // Returns false if it isn't full.
            }
        }
        return true;
    }
    // Method to print the UTT Board.
    public void print()
    {
        // Styling
        System.out.println("++++++++++++++++++++++");


        // Prints the first three values of the first board.
        // We use nested for Loops to create the board as we see.
        for(int i = 0; i < 3; i++)
        {
            if(i != 0)
                System.out.print("| ");
                for (int k = 0; k < 3; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " "); // Printing the first boards first three contents.
                }


        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(i != 0)
                System.out.print("| ");
                for (int k = 3; k < 6; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " "); // Printing the second boards first three contents.
                }


        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(i != 0)
                System.out.print("| ");
                for (int k = 6; k < 9; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " "); // Printing the third boards first three contents.
                }


        }
        // Styling
        System.out.println();
        System.out.println("++++++++++++++++++++++");

        // Prints the middle three values of the boards.
        for(int i = 3; i < 6; i++)
        {
            if(i != 3)
                System.out.print("| ");
                for (int k = 0; k < 3; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " ");

            }

        }
        System.out.println();

        for(int i = 3; i < 6; i++)
        {
            if(i != 3)
                System.out.print("| ");
                for (int k = 3; k < 6; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " ");
                }


        }
        System.out.println();
        for(int i = 3; i < 6; i++)
        {
            if(i != 3)
                System.out.print("| ");
                for (int k = 6; k < 9; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " ");
                }


        }
        // Styling
        System.out.println();
        System.out.println("++++++++++++++++++++++");

        // Prints the last three values of the boards.
        for(int i = 6; i < 9; i++)
        {
            if(i != 6)
                System.out.print("| ");
                for (int k = 0; k < 3; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " ");

            }

        }
        System.out.println();

        for(int i = 6; i < 9; i++)
        {
            if(i != 6)
                System.out.print("| ");
                for (int k = 3; k < 6; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " ");
                }


        }
        System.out.println();
        for(int i = 6; i < 9; i++)
        {
            if(i != 6)
                System.out.print("| ");
                for (int k = 6; k < 9; k++) {
                    System.out.print(UTBoard[i].Sqaures[k].getContent() + " ");
                }


        }
        // Styling
        System.out.println();
        System.out.println("++++++++++++++++++++++");

    }

    // Method that changes the players.
    public void changePlayer()
    {
        if(currentPlayer == 0) // If the current player is 0, make it 1.
        {
            currentPlayer = 1;
        }
        else // If it is one make it 0.
            currentPlayer = 0;
    }

    // Method to check individual Board Winners and print them out when they win.
    public void boardWinners()
    {
        for(int i = 0; i < size; i++)
        {
            if(UTBoard[i].hasWon()) // Checking if the player has won individual boards.
            {
                System.out.println("The winner of Board # " + (i+1) + " is "+ UTBoard[i].getWinner() ); // Print message when a board is won.
            }
        }
    }




}

public abstract class APlayer { // Abstract class for Player.

    // Variables for the class.
    Character symbol;
    String name;

    // Constructor for the class.
    public APlayer(String name, Character symbol)
    {
        setName(name);
        setSymbol(symbol);
    }

    // Getter and Setter methods for the variables.
    public Character getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name =  name;
    }

    // Abstract methods that are implemented in the Player class.
    public abstract int selectBox();
    public abstract int selectBoard();


}

public class Box {
    // Variables for the class.
    Character content;

    public Box()
    {
        this.content = '_';
    } // Setting content to an underscore.

    // Method to change the value of the box.
    public boolean setValue(char symbol)
    {
        if(!isFull()) // Check if it is full first, if its not then change the value to the palyer's symbol.
        {
            this.content = symbol;
            return true;
        }
        return false; // if it is full return false.
    }
    public boolean isFull()
    {
        return(this.content != '_');
    } // returns true if the content is a symbol and false if it is an underscore.

    public Character getContent() {
        return content;
    } // Getter method for the content.
}

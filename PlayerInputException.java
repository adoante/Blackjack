
/**
* PlayerInputException.java: Custom Exception for getting vaild input from user when asking for thier name or money
*
* <p>
* Discription: The exception should be thrown when a player enters a name that isn't a string or money that isnt an integer
* </p>
*
* @author Adolfo Sanpedro Gante
* @version 1.0
*/

public class PlayerInputException extends Exception {

 /**
  * Tells user that their money amount isn't valid
  * @param name thier wanted money amount
  */
 public PlayerInputException() {
   super("The money amount you entered must not be negitive or zero. Try again.");
 }

}

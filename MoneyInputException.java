
/**
* MoneyInputException.java: Custom Exception for getting vaild input from user when asking for thier money
*
* <p>
* Discription: The exception should be thrown when a player enters money that isnt an integer
* </p>
*
* @author Adolfo Sanpedro Gante
* @version 1.0
*/

public class MoneyInputException extends Exception {

 /**
  * Tells user that their money amount isn't valid
  * @param name thier wanted money amount
  */
 public MoneyInputException() {
   super("The money amount you entered must not be negitive or zero. Try again.");
 }

 public MoneyInputException(int bet) {
   super("Your bet of " + bet + " isn't a valid bet.");
 }

}

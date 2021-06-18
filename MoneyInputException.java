
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
 * Tells user that their money amount is over the max or under the min
 * @param bet [description]
 */
 public MoneyInputException(int bet) {
   super("Your bet of " + bet + " must be in increments of $5 & meet the Min/Max bet.");
 }
 /**
  * Tells user that thier money amount cannot be negitive or zero.
  */
 public MoneyInputException() {
   super("The money amount you entered must be a non-negitive whole number greater than zero.");
 }

}


/**
* CharacterLimitException.java: Custom Exception for setting a player name character limit to 15 letters.
*
* <p>
* Discription: The exception should be thrown when a player enters a name that is longer than 15 letters
* </p>
*
* @author Adolfo Sanpedro Gante
* @version 1.0
*/

public class CharacterLimitException extends Exception {

 /**
  * Tells user that their name is too long
  * @param name thier wanted money amount
  */
 public CharacterLimitException() {
   super("The name you entered is too long. There is a 15 letter limit. Try again.");
 }

}

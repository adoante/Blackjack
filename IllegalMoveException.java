/**
* IllegalMoveException.java: Custom Exception for getting vaild input from user when asking for either Hit or Stay
*
* <p>
* Discription: The exception should be thrown when a player enters anything that ins't Hit or Stay
* </p>
*
* @author Adolfo Sanpedro Gante
* @version 1.0
*/

public class IllegalMoveException extends Exception {
  /**
   * Players must hit or stay on thier turn.
   * @param move users input
   */
  public IllegalMoveException(String move) {
    super(" \""+ move + "\"" + " isn't hit or stay. Try again.");
  }
}

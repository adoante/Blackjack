/**
 * Card.java: Creates a 52 card deck.
 * <p>
 * <b>Discription</b>:<br /b>
 *
 * @author Adolfo Sanpedro Gante
 * @version 1.0
 */

public class Card {
  //Instance variables
  int value = 0;              //The cards face value.
  String suit = "";           //The cards suit.

  /**
   * Two Arg-Constructor holding a Cards value and suit.
   * @param value 1 - 11
   * @param suit Clubs, Diamond, Hearts, Spades
   */
  public Card(int value, String suit) {
    this.value = value;
    this.suit = suit;
  }

  /**
   * No Arg-Constructor.
   */
  public Card() {

  }

  //Getters and Setters

  /**
   * Gets a Cards Value.
   * @return 1 - 11
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Gets a Cards suit.
   * @return Clubs, Diamond, Hearts, Spades
   */
  public String getSuit() {
    return this.suit;
  }

  /**
   * Sets a Cards value.
   * @param value 1 - 11
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * Sets a Cards Suit.
   * @param suit Clubs, Diamond, Hearts, Spades
   */
  public void setSuit(String suit) {
    this.suit = suit;
  }

  //toString and equals

  /**
   * Prints a Cards Value and Suit.
   * @return Value and Suit
   */
  public String toString() {
    return ( "Vale: " + value + ", Suit: " + suit);
  }

  /**
   * Checks if two Cards are equal to each other.
   * @param  anObject A Card Object
   * @return          true or false
   */
  public boolean equals(Object anObject) {
    if (anObject == null) {
      return false;
    }
    if (getClass() != anObject.getClass()) {
      return false;
    }
    Card anotherCard = (Card) anObject;
    return (suit.equals(anotherCard.getSuit()) && value == anotherCard.getValue());
  }


}

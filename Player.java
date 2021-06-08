/**
 * Player.java: Player class that holds thier name and initial money amount.
 * <p>
 * <b>Discription</b>:<br /b> This player class will be used to keep the player name and running
 *                            money amount through out multiple games. It will also have methods specific to
 *                            a Player such as Hit or Stay.
 * </p>
 *
 * @author Adolfo Sanpedro Gante
 * @version 1.0
 */

public class Player {
  //Instance variables
  private int money = 0;                //The Player money amount
  private String name= "";              //The Players name

  /**
   * Player with a name and money amount.
   * @param name  The players name.
   * @param money The playes money amount.
   */
  public Player (String name, int money) {
    this.name = name;
    this.money = money;
  }

  /**
   * No Arg-Constructor
   */
  public Player () {

  }


  //Getters and Setters

  /**
   * Gets a players money amount.
   * @return an amount of money
   */
  public int getMoney() {
    return this.money;
  }

  /**
   * Gets a players name.
   * @return a name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets a players money amount.
   * @param money the amount of money a player has
   */
  public void setMoney(int money) {
    this.money = money;
  }

  /**
   * Sets a players name
   * @param name a name
   */
  public void setName(String name) {
    this.name = name;
  }

  //toString and Equals

  /**
   * Prints a players name and money amount
   * @return Players name and money amount
   */
  public String toString() {
    return ( "Name: " + name + ", Money: " + money);
  }

  /**
   * Checks if two players are equal to each other
   * @param  anObject A Player object
   * @return          true or false
   */
  public boolean equals(Object anObject) {
    if (anObject == null) {
      return false;
    }
    if (getClass() != anObject.getClass()) {
      return false;
    }
    Player anotherPlayer = (Player) anObject;
    return (name.equals(anotherPlayer.getName()) && money == anotherPlayer.getMoney());
  }

}

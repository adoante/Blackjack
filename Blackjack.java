/**
 * Blackjack.java: A simple blackjack game.
 * <p>
 * <b>Discription</b>:<br /b> BlackJack is a card game (52  cards) where
 *                 the player tries to beat the dealer. Players place a bet and are
 *                 given a card face up. The dealer recives a card face up and then the
 *                 player is given thier second card face up. The dealer than recives their
 *                 second card face down. The player than has the option to stay or hit. Staying
 *                 ends the players turn. Hitting gives the player another card. The player is
 *                 trying to get a total card value closer to 21 than the dealer. If the player or
 *                 dealer has a hand value of over 21 they bust and lose the game. If the get 21
 *                 aka blackjack they instantly win the game. If they have the same hand value
 *                 the game is a tie and no one wins or loses thier bet. If the player wins thier bet
 *                 is multipled by 2x, 2.5x if they hit blackjack. If the dealer wins the player loses
 *                 thier bet and it goes to the dealer (house).
 * </p>
 *
 * <p>
 * <b>Problem Statement</b>:<br /b> Create a text based blackajck game in the console.
 * </p>
 *
 * <b>Algorithm</b>:
 *   <ol>
 *       <li> Create a Card Class containing all 52 cards. All cards have a value and suit. </li>
 *       <li> Create a Player Class. All players have a Name and Initial Money amount. </li>
 *       <li> Create a Dealer Class. This class will have dealer specific methods such as a Shuffle Deck Method. </li>
 *       <li> The Program will have a Main game loop and sub loops. The Main game loop will have the overall game
 *            while the sub loops will be specific to the player and dealer. </li>
 *       <li> The Main game loop will break when the player enters No/N when asked if they wish to keep playing or when
 *            the player runs out of money. </li>
 *       <li> The Player sub loop will end when the player busts, stays, or hits blackjack. </li>
 *       <li> The dealer sub loop will start if the player stays or hits blackjack. It will end when the dealer hits 17 or over. </li>
 *       <li> During the sub loops is when a winner or tie will be found. Depending on the result the Players money amount will be updated. </li>
 *       <li> The Player will then be asked if they wish to either cash out (end program) or keep playing (loop back). </li>
 *   </ol>
 *
 * @author Adolfo Sanpedro Gante
 * @version 1.0
 */

public BlackJack {
  //Constants

  //Instance variables

  public static void main(String[] args) {



  }
}

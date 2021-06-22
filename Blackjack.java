import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.ArrayList;

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

public class Blackjack {
  //Constants
  public static final int MIN_BET = 5;
  public static final int MAX_BET = 200;

  //Instance variables
  public int betAmount = 0;
  public static int cardNum = 0;
  public static Player player = new Player();
  public static Random rand = new Random();

  public static ArrayList <Card> deck = new ArrayList <Card>(52);
  public static ArrayList <Integer> shuffle = new ArrayList <Integer>();

  public static ArrayList <Card> playerHand = new ArrayList <Card>(11);
  public static ArrayList <Card> dealerHand = new ArrayList <Card>(11);

  public static void main(String[] args) {
    //Creates a 52 card deck
    createDeck();
    //shuffles the deck
    shuffleDeck();

    //Loops untill user enters a proper name
    while (true) {
      try {
        //Asks for players Name
        askPlayerName();
        //Ends Loop
        break;
      } catch (CharacterLimitException e) {
        System.out.println(e.getMessage());
      }
    }

    //Loops untill user enter a proper money amount
    while (true) {
      //Trys to get proper input from user
      try {
        //Asks for players money amount
        askPlayerMoney();
        //Ends Loop
        break;
      }
      catch (InputMismatchException e) {
        System.out.println("The money amount you entered must be a whole integer number. Try again.");
      }
      catch (MoneyInputException e) {
        System.out.println(e.getMessage());
      }
    }

    //Loops untill user enter a proper bet amount
    while (true) {
      //Trys to get proper input from user
      try {
        //Asks for players bet amount
        askBetAmount();
        //Ends Loop
        break;
      }
      catch (InputMismatchException e) {
        System.out.println("The money amount you entered must be a whole integer number. Try again.");
      }
      catch (MoneyInputException e) {
        System.out.println(e.getMessage());
      }
    }

    dealCards();

    printTable();

    //Loops untill player turn ends
    while (true) {
      try {
        //Asks player for either hit or bust
        if (playerMove()) {
          break;
        }

        printTable();
      } catch (IllegalMoveException e) {
        System.out.println(e.getMessage());
      }

    }
}

  //Helper methods

  public static void askPlayerName() throws CharacterLimitException{
    //Creates a scanner to get user input
    Scanner userInput = new Scanner(System.in);

    //Asks player for thier name.
    System.out.print("Enter your name: ");
    String name = userInput.next();

    //Checks name length
    if (name.length() > 15) {
      throw new CharacterLimitException();
    }
    else {
      //Sets players name.
      player.setName(name);
    }
  }

  public static void askPlayerMoney() throws MoneyInputException {
    //Creates a scanner to get user input
    Scanner userInput2 = new Scanner(System.in);

    //Asks user for thier inital amount of money
    System.out.print("Enter your amount of money: ");
    int money = userInput2.nextInt();

    //Checks for valid user input
    if (money <= 0) {
      throw new MoneyInputException();
    }
    //Sets players money amount
    player.setMoney(money);
  }

  public static void askBetAmount() throws MoneyInputException {
    //Creates a scanner to get user input
    Scanner userInput3 = new Scanner(System.in);

    //Asks player for thier name.
    System.out.println("Min: $" + MIN_BET + ", Max: $" + MAX_BET);
    System.out.print("Enter your bet amount in increments of $5: ");
    int betAmount = userInput3.nextInt();

    //Checks for valid user input
    if ((betAmount % 5) != 0) {
      throw new MoneyInputException(betAmount);
    }
    if (betAmount < MIN_BET || betAmount > MAX_BET) {
      throw new MoneyInputException(betAmount);
    }
  }

  public static void createDeck() {
    String suit = "";
    for (int i = 0; i < 4; i++) {
      switch (i){
        case 0: suit = "H";
        deck.add (new Card(1, suit, "One"));
        deck.add (new Card(2, suit, "Two"));
        deck.add (new Card(3, suit, "Three"));
        deck.add (new Card(4, suit, "Four"));
        deck.add (new Card(5, suit, "Five"));
        deck.add (new Card(6, suit, "Six"));
        deck.add (new Card(7, suit, "Seven"));
        deck.add (new Card(8, suit, "Eight"));
        deck.add (new Card(9, suit, "Nine"));
        deck.add (new Card(10, suit, "Ten"));
        deck.add (new Card(10, suit, "Jack"));
        deck.add (new Card(10, suit, "King"));
        deck.add (new Card(10, suit, "Queen"));
        break;
        case 1: suit = "D";
        deck.add (new Card(1, suit, "One"));
        deck.add (new Card(2, suit, "Two"));
        deck.add (new Card(3, suit, "Three"));
        deck.add (new Card(4, suit, "Four"));
        deck.add (new Card(5, suit, "Five"));
        deck.add (new Card(6, suit, "Six"));
        deck.add (new Card(7, suit, "Seven"));
        deck.add (new Card(8, suit, "Eight"));
        deck.add (new Card(9, suit, "Nine"));
        deck.add (new Card(10, suit, "Ten"));
        deck.add (new Card(10, suit, "Jack"));
        deck.add (new Card(10, suit, "King"));
        deck.add (new Card(10, suit, "Queen"));
        break;
        case 2: suit = "C";
        deck.add (new Card(1, suit, "One"));
        deck.add (new Card(2, suit, "Two"));
        deck.add (new Card(3, suit, "Three"));
        deck.add (new Card(4, suit, "Four"));
        deck.add (new Card(5, suit, "Five"));
        deck.add (new Card(6, suit, "Six"));
        deck.add (new Card(7, suit, "Seven"));
        deck.add (new Card(8, suit, "Eight"));
        deck.add (new Card(9, suit, "Nine"));
        deck.add (new Card(10, suit, "Ten"));
        deck.add (new Card(10, suit, "Jack"));
        deck.add (new Card(10, suit, "King"));
        deck.add (new Card(10, suit, "Queen"));
        break;
        case 3: suit = "S";
        deck.add (new Card(1, suit, "One"));
        deck.add (new Card(2, suit, "Two"));
        deck.add (new Card(3, suit, "Three"));
        deck.add (new Card(4, suit, "Four"));
        deck.add (new Card(5, suit, "Five"));
        deck.add (new Card(6, suit, "Six"));
        deck.add (new Card(7, suit, "Seven"));
        deck.add (new Card(8, suit, "Eight"));
        deck.add (new Card(9, suit, "Nine"));
        deck.add (new Card(10, suit, "Ten"));
        deck.add (new Card(10, suit, "Jack"));
        deck.add (new Card(10, suit, "King"));
        deck.add (new Card(10, suit, "Queen"));
        break;
        default:
        break;
      }
    }
  }

  public static void shuffleDeck() {
    while(shuffle.size() < 51) {
      int deckSpot = rand.nextInt(52);
      if (!shuffle.contains(deckSpot)) {
        shuffle.add(deckSpot);
        deck.add(deck.get(deckSpot));
        deck.remove(deckSpot);
      }
    }
  }

  public static boolean playerMove() throws IllegalMoveException {
    //Creates a scanner to get user input
    Scanner userInput5 = new Scanner(System.in);

    //Asks player for thier name.
    System.out.print("Enter Hit or Stay: ");
    String move = userInput5.next();

    move = move.toUpperCase();
    if (move.equals("STAY")) {
      return (true);
    }
    else if (move.equals("HIT")) {
      playerHand.add(deck.get(0));
      deck.remove(0);
      return (false);
    }
    else {
      throw new IllegalMoveException(move);
    }
  }

  public static void printTable() {
    System.out.println();

    System.out.println("Dealer's Hand ------ Player's Hand");
    System.out.println("|  " + dealerHand.get(cardNum).getName() + ", " + dealerHand.get(cardNum).getSuit() +
                       "  |      |  " + playerHand.get(cardNum).getName() + ", " + playerHand.get(cardNum).getSuit() + "  |");
    System.out.println("----------------------------------");
    cardNum++;
  }

  public static void dealCards() {
    playerHand.add(deck.get(0));
    deck.remove(0);
    dealerHand.add(deck.get(0));
    deck.remove(0);
    playerHand.add(deck.get(0));
    deck.remove(0);
    dealerHand.add(deck.get(0));
    deck.remove(0);
  }
}

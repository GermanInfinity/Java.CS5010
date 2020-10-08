import java.util.ArrayList;
import java.util.Random;

/**
 * Arena class: represents the driver class. The driver class, Arena,
 *              runs a role playing game which initializes two characters
 *              with certain attires that give them attack and defense. These 
 *              Characters then engage in a fight till a winner is declared. 
 * @author  Ugo Nwachuku 
 *
 */
public class Arena {
  
  private Boolean gameOn;
  private int firstFighter;
  String fightStatus;

  /**
   * Arena class constructor: creates an arena for two incoming 
   *                          players to fight till the end. Constructor sets first
   *                          fighter also. 
   * @param Character player1, Character player2
   * Returns Arena object
   */
  public Arena(Character player1, Character player2) {
    this.gameOn = true;
    this.fightStatus = "Let's get ready to rumble!";
    System.out.println(this.fightStatus);
    setFirstPlayer(player1, player2);
  }
  
  
  
  /** 
   * setFirstPlayer: determines the first player too throw a punch in the fight!
   * @param does not take a parameter
   * Returns: nothing
   */
  public void setFirstPlayer(Character player1, Character player2) {
    Random ran = new Random();
    int randomStarter = ran.nextInt(2) + 0;
    if (randomStarter == 0) { this.firstFighter = 0; }
    if (randomStarter == 1) { this.firstFighter = 1; }
  }
  
  
  
  /**
   * fightMedic function checks how much health has been lost for both players after a 
   *                      duel or attack. Determines if the fight can continue, or it is a 
   *                      draw or who wins. 
   * @param Character player 1, Character player 2
   * Return does not return anything
   */
  public void fightMedic(Character player1, Character player2) { 
    if (player1.getDefense() < 0 && player2.getDefense() < 0) { 
      this.gameOn = false; 
      this.fightStatus = "Draw!";
    }
    if (player2.getDefense() < 0) { 
      this.gameOn = false; 
      this.fightStatus = player1.getName() + " wins the Fight!";
    }
    if (player1.getDefense() < 0) { 
      this.gameOn = false; 
      this.fightStatus = player2.getName() + " wins the Fight!";
    }
    else { 
      System.out.println(player1.getDefense());
      System.out.println(player2.getDefense());
      this.gameOn = true; 
      this.fightStatus = "Fight is ongoing, keep an eye out for low blows!";
    }
    System.out.println(this.fightStatus);
  }
  
  
  
  /**
   * Duel: function enables an attack on a character player from another player. 
   *       It does this by reducing defense on a hit player with the attack points
   *       of the attacking player. 
   * @param Character player 1, Character player 2, int turn
   * Return does not return anything
   */
  public void Duel(Character player1, Character player2, int turn) { 
    if (turn == 0) { 
      int attackValue = player1.getAttack();
      int defenseValue = player2.getDefense();
      int hurt = defenseValue - attackValue; 
      
      player2.setDefense(hurt); 
    }
    if (turn == 1) { 
      int attackValue = player2.getAttack();
      int defenseValue = player1.getDefense();
      int hurt = defenseValue - attackValue; 
      
      player1.setDefense(hurt); 
    }
  }
  
  
  
  /**
   * Fight: function implements an ongoing fight between two characters. 
   *        This function also determines the character to attack and defend.
   * @param Character player 1, Character player 2
   * Return Character winner of fight
   */
  public void Fight(Character player1, Character player2) { 
    while (this.gameOn) { 
      //System.out.println(this.firstFighter);
      Duel(player1, player2, this.firstFighter);
      fightMedic(player1, player2);
      //System.out.println(this.firstFighter % 1);
    }
    System.out.println(this.fightStatus);
  }
  
  /**
   * This main function creates two characters and puts them in the arena to 
   * battle it out. 
   */
  public static void main(String args[]) {
    ArrayList <WearableGear> list = new ArrayList<WearableGear>();
    
    Footwear foot = new Footwear("Fat shoes", 3, 2, false, true);
    list.add(foot);
    
    HeadGear head = new HeadGear("Heavy heads", 30, false, true);
    list.add(head);
    
    HandGear hand = new HandGear("Slow hands", 1, false, true);
    list.add(hand);
    
    
    CharacterBuilder player1 = new CharacterBuilder("John Snow", list);
    Character playerA = player1.build();
    
    ArrayList <WearableGear> list2 = new ArrayList<WearableGear>();
    
    Footwear foot2 = new Footwear("Fat shoes", 3, 1, false, true);
    list2.add(foot2);
    
    HeadGear head2 = new HeadGear("Heavy heads", 20, false, true);
    list2.add(head2);
    
    HandGear hand2 = new HandGear("Slow hands", 4, false, true);
    list2.add(hand2);
    
    
    CharacterBuilder player2 = new CharacterBuilder("Undertaker", list2);
    Character playerB = player2.build();
    
    
    
    //System.out.println(playerA.getAttire());
    Arena battleRoyal = new Arena(playerA, playerB);
    
    battleRoyal.Fight(playerA, playerB);
    //System.out.println(playerB.toString());
    
  }

}

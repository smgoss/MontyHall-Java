/**
 * Door.java
 * @author Stephen Goss
 * A class representing a Door in the Monty Hall problem.
 *
 */
public class Door {
	// The number of the door in the game.
	// It should be positive and greater 
	// than zero.
	private int doorNumber;
	private Prize prize;
	//private boolean playerDoor = false;
	/**
	 * Constructor
	 * @param doorNumber - The number of this door
	 */
	public Door(int doorNumber){
		this.doorNumber=doorNumber;
	}
	/**
	 * Constructor
	 * @param doorNumber - The number of this door
	 * @param prize - The prize behind this door
	 */
	public Door(int doorNumber, Prize prize){
		this.doorNumber=doorNumber;
		this.prize=prize;
	}
	/**
	 * Gets the number of this door.
	 * @return doorNumber - The number of this door
	 */
	public int getNumber(){
		return doorNumber;
	}
	/**
	 * @return	Returns the prize behind this door
	 */
	public Prize getPrize(){
		return this.prize;
	}
	/**
	 * Sets the prize behind this door.
	 * @param prize - the prize to be set
	 */
	public void setPrize(Prize prize){
		this.prize = prize;
	}
}

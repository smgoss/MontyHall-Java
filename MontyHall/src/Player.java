/**
 * Player.java
 * @author Stephen Goss
 * The class representing a player in the
 * Monty Hall problem/game.
 */
public class Player {
	private Door door;
	private String name;
	/**
	 * Constructor
	 */
	public Player(){
		this.name = "Player";
	}
	/**
	 * setDoor - sets the players door
	 * @param door - the door to set
	 */
	public void setDoor(Door door){
		this.door = door;
	}
	/**
	 * getDoor - gets the player door
	 * @return The players door
	 */
	public Door getDoor(){
		return this.door;
	}
	/**
	 * setName - sets the players name
	 * @param name
	 */
	public void setName(String name){
		this.name=name;
	}
	/**
	 * getName - Gets the player door
	 * @return - the players name
	 */
	public String getName(){
		return this.name;
	}
}

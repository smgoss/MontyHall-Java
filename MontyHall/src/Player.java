
public class Player {
	private Door door;
	private String name;
	/**
	 * Constructor
	 */
	public Player(){
		this.name = "Player";
	}
	public void setDoor(Door door){
		this.door = door;
	}
	public Door getDoor(){
		return this.door;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}

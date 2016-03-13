import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
/**
 * Game.java
 * @author Stephen Goss
 * A class to play the Monty Hall problem/game.
 */
public class Game {
	// The list of doors to pick from.
	private List<Door> doors;
	//The player in this game.
	private Player player = new Player();
	//The number of doors in this game.
	private int size;
	/**
	 * Constructor - Makes an instance of a game.
	 * @param size - the number of doors in this game
	 */
	public Game(int size){
		// Sets the size of this game
		this.size = size;
		// Initializes the list of doors.
		doors = new ArrayList<Door>();
	}
	/**
	 * buildGame - Builds the game to be played.
	 */
	public void buildGame(){
		// Random number generator
		Random r = new Random();
		int winner = r.nextInt(this.size);
		// Loop through and add all the doors to the list.
		for(int i = 0; i < this.size; i++){
			if(i != winner){
				// Add the Zonks
				doors.add(i,new Door(i+1,Prize.ZONK));
			} else {
				// Add the winning door
				doors.add(i, new Door(winner+1, Prize.CAR));
			}
		}
	}
	/**
	 * setPlayerDoor - Gets the players initial door.
	 * @param door - the door the player wants
	 */
	public void setPlayerDoor(int door){
		player.setDoor(doors.remove(door-1));
	}
	/**
	 * shuffleDoors - Randomizes the doors.
	 */
	public void shuffleDoors(){
		// Random Number Generator
		Random r = new Random();
		// Loop through and swap all the doors around
	    for (int i = doors.size(); i > 1; i--){
	        swapDoors( i - 1, r.nextInt(i));
	    }
	}
	/**
	 * swapDoors - swaps the position of two doors.
	 * @param door1 - Index of first door to swap with
	 * @param door2 - Index of second door to swap with
	 */
	private void swapDoors(int door1, int door2){
		// Store door 1 before it is over written
		Door tmp = doors.get(door1);
		// Replace door 1 with door 2
		doors.set(door1, doors.get(door2));
		// Replace door 2 with the saved door 1
		doors.set(door2, tmp);
	}
	/**
	 * revealDoors - Show all but one of the doors. 
	 */
	public void revealDoors(boolean silent){
		int counter = 0;	
		// Loop through showing each door.
		while(doors.size() > 1){
			// Check if there is a car behind the door
			if (doors.get(counter).getPrize() != Prize.CAR){
				// Show the door if it is a Zonk
				Door thedoor = doors.remove(counter);
				if(!silent){
					System.out.println("Door "+thedoor.getNumber()+"is a "+thedoor.getPrize().toString()+".");
				}
			} else {
				// Don't show this door.
				counter++;
			}
			
		}	
	}
	/**
	 * checkWinner - Check to see if the player won.
	 * @return - true if we won.
	 */
	public boolean checkWinner(boolean silent){
		if (player.getDoor().getPrize() == Prize.CAR){
			if(!silent){
				System.out.println("You won a "+player.getDoor().getPrize().toString()+"!");
			}
			return true;
		} else {
			if(!silent){
				System.out.println("You loose and get a "+player.getDoor().getPrize().toString());
			}
			return false;
		}
		
	}
	/**
	 * switchDoor - switch the player door with the first
	 * 				(and only) door in the queue.
	 */
	public void switchPlayerDoor(){
			Door tmp = doors.remove(0);
			doors.add(player.getDoor());
			player.setDoor(tmp);
	}
}


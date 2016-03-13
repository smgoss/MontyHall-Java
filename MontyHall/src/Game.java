import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Game {
	private List<Door> doors;
	//private int listSize = 0;
	private Player player = new Player();
	private int size;
	/*
	 * Constructor
	 * @param size - the number of doors in this game
	 */
	public Game(int size){
		this.size = size;
		doors = new ArrayList<Door>();
	}
	public void buildGame(){
		
		Random r = new Random();
		int winner = r.nextInt(this.size);
		Door winningDoor=new Door(winner+1, Prize.CAR);
		System.out.println("The winning door is " + winningDoor.getNumber());
		for(int i = 0; i < this.size; i++){
			if(i != winner){
				doors.add(i,new Door(i+1,Prize.ZONK));
			} else {
				doors.add(i, winningDoor);
				
			}
		}
		
	}
	private void setPlayerDoor(int door){
		player.setDoor(doors.remove(door-1));
		System.out.println("Player Door is: "+player.getDoor().getNumber());
		//System.out.println("Next Door: " +doors.remove(door).getNumber());
	}
	public void shuffleDoors(){
		Random r = new Random();
	    for (int i = doors.size(); i > 1; i--){
	        swapDoors( i - 1, r.nextInt(i));
	    }
	}
	private void swapDoors(int door1, int door2){
		Door d1 = doors.get(door1);
		Door d2 = doors.get(door2);
		doors.set(door1, d2);
		doors.set(door2, d1);
	}
	public void revealDoors(){
		int counter = 0;
		int mysize = doors.size();
		while(mysize > 1){
			if (doors.get(counter).getPrize() != Prize.CAR){
				Door thedoor = doors.remove(counter);
				System.out.println("Door: " + thedoor.getNumber() + " is a " + thedoor.getPrize().toString());
				mysize--;
			} else {
				counter++;
			}
			
		}	
	}
	public boolean checkWinner(){
		System.out.println("The player wins a: "+player.getDoor().getPrize().toString());
		if (player.getDoor().getPrize() == Prize.CAR){
			return true;
		} else {
			return false;
		}
		
	}
	public void switchDoor(boolean change){
		if (change){
			Door tmp = doors.remove(0);
			doors.add(player.getDoor());
			player.setDoor(tmp);
			System.out.println("New Player Door is: "+player.getDoor().getNumber());
		}
	}
	public static void main(String[] args){
		double wins = 0;
		for( int i = 0; i < 1000000; i ++){
			Game theGame = new Game(100);
			//System.out.print("What number would you like?: ");
			Scanner in = new Scanner(System.in);
			//int num = in.nextInt();
			Random r = new Random();
			theGame.buildGame();
			theGame.setPlayerDoor(r.nextInt(3)+1);
			theGame.shuffleDoors();
			theGame.revealDoors();
			theGame.switchDoor(true);
			
			if (theGame.checkWinner()){
				wins++;
			}
		}
		double percent = ( wins / 1000000 ) * 100;
		System.out.println("Wins = "+wins);
		System.out.println("Percent: " + percent);
		
		
	}
}


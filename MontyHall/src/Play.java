import java.util.Random;
import java.util.Scanner;
public class Play {
	public Play(){
	}
	public void simulator(int numDoors, int trials, boolean playerChoice){
		double wins = 0;
		Random r = new Random();
		for (int i = 0; i < trials; i++ ){
			Game theGame = new Game(numDoors);
			theGame.buildGame();
			theGame.setPlayerDoor(r.nextInt(numDoors)+1);
			theGame.shuffleDoors();
			theGame.revealDoors(true);
			if(playerChoice){
				theGame.switchPlayerDoor();
			}
			if(theGame.checkWinner(false)){
				wins++;
			}
		}
		double percent= (wins/trials)*100;
		System.out.println("Percentage won: "+ percent);
	}
	public static void main(String[] args){	
		int numDoors = 0;
		int numTrials = 0;
		int playerChoice = 0;
		// The user may enter bad input.
		try{
			System.out.print("How many doors would you like to play with? ");
			Scanner s1 = new Scanner(System.in);
			numDoors = s1.nextInt();
			System.out.print("How many trials would you like to run? ");
			numTrials = s1.nextInt();
			System.out.print("Would you like to say or switch?\n[1] Stay\n[2] Switch\n:");
			playerChoice = s1.nextInt();
			if ((playerChoice != 1) && (playerChoice!= 2)){
				System.out.println("Bad Input!");
				System.exit(-1);
			}
		} catch (Exception e){
			System.out.println("Bad input entered!");
			System.exit(-1);
		}
		Play p1 = new Play();
		if (playerChoice == 1){
			p1.simulator(numDoors, numTrials, false);
		} else {
			p1.simulator(numDoors, numTrials, true);
		}
	}
}

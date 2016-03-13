
public class Play {
	public Play(){
	}
	public static void main(String[] args){
		double wins = 0;
		int trials = 1000000;
		for (int i = 0; i < trials; i++ ){
			Game theGame = new Game(4);
			if (theGame.playGame(true)){
				wins++;
			}
		}
		double percent= (wins/trials)*100;
		System.out.println("Percentage won: "+ percent);
	}
}

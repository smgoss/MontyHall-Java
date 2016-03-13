/**
 * An enumeration representing the prize
 * @author Stephen Goss
 */
public enum Prize {
	ZONK, CAR;
	/**
	 * @return	The string representing this prize
	 */
	public String toString() {
		switch(this){
		case ZONK:	return "Zonk";
		case CAR:	return "Car";
		default: 	return "Error";
		}
	}
	/**
	 * 
	 * @return 	True is this is a winning prize
	 * 			otherwise returns false.
	 */
	public boolean isWinner(){
		switch(this){
		case CAR:	return true;
		default: 	return false;
		}
	}
}

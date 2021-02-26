public class Battleship extends Ship {

	public Battleship() {
		
		numHits = 0;
		size = 4;
		marker = "B";
		
		
	}
	
	@Override
	public String toString() {
		
		return "battleship";
	}
	
	
}
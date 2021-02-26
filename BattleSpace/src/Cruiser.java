public class Cruiser extends Ship {

	public Cruiser() {
		
		numHits = 0;
		size = 3;
		x = -1;
		y = -1;
		marker = "R";
		
		
	}
	
	@Override
	public String toString() {
		
		return "cruiser";
	}
	
	
}
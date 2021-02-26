public class Submarine extends Ship {

	public Submarine() {
		
		numHits = 0;
		size = 3;
		x = -1;
		y = -1;
		marker = "S";
		
		
	}
	
	@Override
	public String toString() {
		
		return "submarine";
	}
	
	
}
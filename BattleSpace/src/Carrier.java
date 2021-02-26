public class Carrier extends Ship {

	public Carrier() {
		
		numHits = 0;
		size = 5;
		x = -1;
		y = -1;
		marker = "C";
		
		
	}
	
	@Override
	public String toString() {
		
		return "carrier";
	}
	
	
}
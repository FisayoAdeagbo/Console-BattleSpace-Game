public class Submarine extends Ship {

	public Submarine() {
		
		numHits = 0;
		size = 3;
		x = -1;
		y = -1;
		marker = "S";
		
		
	}
	
	public void setCoordinates(int x, int y) {
		
		
		
	}
	
	public boolean isHit(int x, int y) {
		
		return false;
	}
	
	public boolean isDestoryed() {
		
		return false;
	}
	
	@Override
	public String toString() {
		
		return marker;
	}
	
	private void toNorth() {
		
		
		
	}
	
	
}
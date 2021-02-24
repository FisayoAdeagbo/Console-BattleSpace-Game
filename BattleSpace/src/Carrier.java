public class Carrier extends Ship {

	public Carrier() {
		
		numHits = 0;
		size = 5;
		x = -1;
		y = -1;
		marker = "C";
		
		
	}
	public void rotateClockwise() {
	
		
	}
	
	public void rotateAntiClockwise() {
		
		
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
	
	public boolean isSunk() {
		
		if(numHits >= size) {
			return true;
		}
		return false;
		
		
	}
	
	
}
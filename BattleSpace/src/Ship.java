public abstract class Ship {
	
	int  numHits;
	int size;
	boolean placed;
	
	int x;
	int y;
	
	String marker;
	String hitMarker;
	Direction direction;
	
	public Ship() {
		
		hitMarker = "X";
		placed = false;
		
	}
	
	abstract public void setCoordinates(int x, int y);
	
	public boolean isSunk() {
		
		if(numHits == size) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		
		return marker;
		
	}
	
	
	
}
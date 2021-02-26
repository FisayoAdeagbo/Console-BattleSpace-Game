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
	
	public void setCoordinates(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	
	public String toString() {
		
		return marker;
		
	}
	
	
	
}
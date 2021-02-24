import java.util.ArrayList;

public class Grid {
	
	ArrayList<Ship> nonPlacedShips;
	ArrayList<Ship> placedShips;
	ArrayList<Ship> destroyedShips;
	String[][] grid;
	int shipsDestroyed;
	
	Carrier carrier;
	Battleship battleship;
	Cruiser cruiser;
	Submarine submarine;
	Destroyer destroyer;
	
	
	public static void main(String[] args) {
		
		Grid nGrid = new Grid();
		nGrid.placeShip(nGrid.submarine, Direction.EAST, 3, 3);
		nGrid.placeShip(nGrid.destroyer, Direction.SOUTH, 4,4);
		nGrid.placeShip(nGrid.carrier, Direction.WEST, 4, 4);
		nGrid.placeShip(nGrid.cruiser, Direction.NORTH, 7, 1);
		nGrid.placeShip(nGrid.battleship, Direction.EAST, 2, 2);
		nGrid.rotateShipClockwise(nGrid.carrier);
		nGrid.hit(3,3);
		nGrid.showGrid();
		System.out.println(nGrid.placedShips);
		
	}
	
	public Grid() {
		
		destroyer = new Destroyer();
		cruiser = new Cruiser();
		submarine = new Submarine();
		carrier = new Carrier();
		battleship = new Battleship();
		
		nonPlacedShips = new ArrayList<Ship>();
		placedShips = new ArrayList<Ship>();
		destroyedShips = new ArrayList<Ship>();
		shipsDestroyed = 0;

		nonPlacedShips.add(carrier);
		nonPlacedShips.add(battleship);
		nonPlacedShips.add(cruiser);
		nonPlacedShips.add(submarine);
		nonPlacedShips.add(destroyer);
		
		
		grid = new String[8][8];
		setUp();
		
	}
	
	void setUp() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid[i][j] = " ";
			}
		}
	}
	
	void showGrid() {
		
		System.out.println();
        System.out.print("  ");
        for(int i = 0; i < 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y] + "|");
            }

            System.out.println(x);
            System.out.println();
            
            
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < 8; i++)
            System.out.print(i + " ");
        System.out.println();
		
	}
	
	void placeShip(Ship ship, Direction direction, int x, int y) {
		
		int xStart = x;
		int yStart = y;
		int xStop = x + 1;
		int yStop = y + 1;
				
		if(direction.equals(Direction.NORTH)){
			xStart = x - ship.size + 1;
			xStop = x + 1; 
		} else if (direction.equals(Direction.SOUTH)){
			xStart = x;
			xStop = x + ship.size;
		} else if (direction.equals(Direction.EAST)){
			yStart = y;
			yStop = y + ship.size;
		} else if (direction.equals(Direction.WEST)){
			yStart = y - ship.size + 1;
			yStop = y + 1;
		}

		try{
			for(int i = xStart; i < xStop; i++){
				for(int j = yStart; j < yStop; j++){
					if (grid[i][j].equals(" ")) {
						grid[i][j] = ship.marker;
					} else {
						removeShip(ship);
						System.out.println("Overlap");
						break;
					}

				}	
			}
		} catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			removeShip(ship);
			return;
		}
		 
		ship.x = x;
		ship.y = y;
		ship.direction = direction;
		ship.placed = true;
		
		placedShips.add(ship);
		nonPlacedShips.remove(ship);
		
		
	}
	
	void removeShip(Ship ship) {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j].equals(ship.marker)) {
					grid[i][j] = " ";
				}
			}
		}
		
		placedShips.remove(ship);
		if (!nonPlacedShips.contains(ship)) {
			nonPlacedShips.add(ship);
		}
		
	}
	
	void rotateShipClockwise(Ship ship) {
		
		try {
			if (ship.direction.equals(Direction.NORTH)) {
				removeShip(ship);
				placeShip(ship, Direction.EAST, ship.x, ship.y);
				
			} else if (ship.direction.equals(Direction.SOUTH)) {
				removeShip(ship);
				placeShip(ship, Direction.WEST, ship.x, ship.y);
				
			} else if (ship.direction.equals(Direction.EAST)) {
				removeShip(ship);
				placeShip(ship, Direction.SOUTH, ship.x, ship.y);
				
			} else if (ship.direction.equals(Direction.WEST)) {
				removeShip(ship);
				placeShip(ship, Direction.NORTH, ship.x, ship.y);
				
			}
		} catch (Exception e) {
			System.out.println("Cannot rotate ship" + e);
		}
		
	}
	
	void rotateShipAntiClockwise (Ship ship) {
		
		try {
			if (ship.direction.equals(Direction.NORTH)) {
				removeShip(ship);
				placeShip(ship, Direction.WEST, ship.x, ship.y);
				
			} else if (ship.direction.equals(Direction.SOUTH)) {
				removeShip(ship);
				placeShip(ship, Direction.EAST, ship.x, ship.y);
				
			} else if (ship.direction.equals(Direction.EAST)) {
				removeShip(ship);
				placeShip(ship, Direction.NORTH, ship.x, ship.y);
				
			} else if (ship.direction.equals(Direction.WEST)) {
				removeShip(ship);
				placeShip(ship, Direction.SOUTH, ship.x, ship.y);
				
			}
		} catch (Exception e) {
			System.out.println("Cannot rotate ship" + e);
		}
		
	}
	
	boolean hit(int x, int y) {
		
		if (grid[x][y].equals(" ")) {
			return false;
		
		} else if (grid[x][y].equals("C")) {
			grid[x][y] = carrier.hitMarker;	
		} else if (grid[x][y].equals("B")) {
			grid[x][y] = battleship.hitMarker;	
		} else if (grid[x][y].equals("R")) {
			grid[x][y] = cruiser.hitMarker;	
		} else if (grid[x][y].equals("S")) {
			grid[x][y] = submarine.hitMarker;	
		} else if (grid[x][y].equals("D")) {
			grid[x][y] = destroyer.hitMarker;	
		}
		return true;
	}
	
	boolean isDestroyed(Ship ship) {
		
		int xStart = ship.x;
		int yStart = ship.y;
		int xStop = ship.x + 1;
		int yStop = ship.y + 1;
				
		if(ship.direction.equals(Direction.NORTH)){
			xStart = ship.x - ship.size + 1;
			xStop = ship.x + 1; 
		} else if (ship.direction.equals(Direction.SOUTH)){
			xStart = ship.x;
			xStop = ship.x + ship.size;
		} else if (ship.direction.equals(Direction.EAST)){
			yStart = ship.y;
			yStop = ship.y + ship.size;
		} else if (ship.direction.equals(Direction.WEST)){
			yStart = ship.y - ship.size + 1;
			yStop = ship.y + 1;
		}

		for(int i = xStart; i < xStop; i++){
			for(int j = yStart; j < yStop; j++){
				if (grid [i][j].equals(ship.marker)) {
					return false;
				}
			}	
		}
		
		destroyedShips.add(ship);
		shipsDestroyed++;
		return true;
	}
	
	int shipsRemaining() {
		
		return 5 - shipsDestroyed;
	}
	
	int shipsDestroyed() {
		
		return shipsDestroyed;
		
	}
	
	boolean checkLost() {
		
		if (shipsDestroyed == 5) {
			return true;
		}
		return false;
	}
	
	int[] getCoordinates(Ship ship) {
		
		int[] coords = new int[2];
		coords[0] = ship.x;
		coords[1] = ship.y;
		return coords;
		
	}
	
	boolean isEmpty(String cell) {
		
		if (cell != " ") {
			return false;
		}
		return true;
		
	}
}
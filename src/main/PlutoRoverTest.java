package main;

import org.junit.Test;
import org.junit.Assert;
import static main.Orientation.*;

public class PlutoRoverTest {
	
	private static final int PLUTO_LENGTH = 1000; //Random chosen length and width for pluto
	private static final int PLUTO_WIDTH = 1000;
	
	@Test
	//Ensures that on initialisation, rover is at origin
	public void initialLocationAtOrigin() {
		PlutoRover rover = new PlutoRover();
		int[] orig_loc = {0, 0};
		Orientation orig_ord = Orientation.NORTH; 
		
		Assert.assertArrayEquals(rover.getLocation(), orig_loc);
		Assert.assertEquals(rover.getOrd(), orig_ord);
	}
	
	@Test
	//Ensures that forward movement updates the location properly
	public void forwardMovement() {
		PlutoRover rover = new PlutoRover();
		int[] new_loc = {0, 1};
		rover.moveForward();
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		rover.rightTurn();
		rover.moveForward();
		new_loc[0] = 1;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		rover.rightTurn();
		rover.moveForward();
		new_loc[1] = 0;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		rover.rightTurn();
		rover.moveForward();
		new_loc[0] = 0;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
	}
	
	@Test
	//Asserts that backward movement updates the location properly
	public void backwardMovement() {
		PlutoRover rover = new PlutoRover();
		int[] new_loc = {0, PLUTO_LENGTH - 1};
		rover.moveBackward();
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		rover.rightTurn();
		rover.moveBackward();
		new_loc[0] = PLUTO_WIDTH - 1;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		rover.rightTurn();
		rover.moveBackward();
		new_loc[1] = 0;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		rover.rightTurn();
		rover.moveBackward();
		new_loc[0] = 0;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
	}
	
	@Test
	//Checks that left turns point to the right direction
	public void leftTurnMovement() {
		PlutoRover rover = new PlutoRover();
		rover.leftTurn();
		Assert.assertEquals(rover.getOrd(), WEST);
		rover.leftTurn();
		Assert.assertEquals(rover.getOrd(), SOUTH);
		rover.leftTurn();
		Assert.assertEquals(rover.getOrd(), EAST);
		rover.leftTurn();
		Assert.assertEquals(rover.getOrd(), NORTH);
		
	}
	
	@Test
	//Checks that left turns point to the right direction
	public void rightTurnMovement() {
		PlutoRover rover = new PlutoRover();
		rover.rightTurn();
		Assert.assertEquals(rover.getOrd(), EAST);
		rover.rightTurn();
		Assert.assertEquals(rover.getOrd(), SOUTH);
		rover.rightTurn();
		Assert.assertEquals(rover.getOrd(), WEST);
		rover.rightTurn();
		Assert.assertEquals(rover.getOrd(), NORTH);
	}
	
	@Test 
	//Checks that the rover warps correctly
	public void warpCorrectly() {
		PlutoRover rover = new PlutoRover();
		int[] orig = {0, 0};
		int[] new_loc = {0, PLUTO_LENGTH - 1};
		
		//Check that rover is at top leftmost point of grid when moving backwards at origin
		rover.moveBackward();
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		//Check that rover is at top rightmost point of grid when moving left 
		//at top leftmost point
		rover.leftTurn();
		rover.moveForward();
		new_loc[0] = PLUTO_WIDTH - 1;
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
		
		//Move back to origin
		rover.moveBackward();
		rover.rightTurn();
		rover.moveForward();

		for (int i=0; i<PLUTO_LENGTH; i++) {
			rover.moveForward();
		}
		
		//Check that rover is at origin when moving forward from top leftmost point of grid
		Assert.assertArrayEquals(rover.getLocation(), orig);
	}
	

}

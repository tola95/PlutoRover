package main;

import org.junit.Test;
import org.junit.Assert;
import static main.Orientation.*;

public class PlutoRoverTest {
	
	@Test
	public void initialLocationAtOrigin() {
		PlutoRover rover = new PlutoRover();
		int[] orig_loc = {0, 0};
		Orientation orig_ord = Orientation.NORTH; 
		Assert.assertArrayEquals(rover.getLocation(), orig_loc);
		Assert.assertEquals(rover.getOrd(), orig_ord);
	}
	
	@Test
	public void forwardMovementNorth() {
		PlutoRover rover = new PlutoRover();
		int[] new_loc = {0, 1};
		rover.moveForward();
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
	}
	
	@Test
	public void backwardMovementNorth() {
		PlutoRover rover = new PlutoRover();
		int[] new_loc = {0, -1};
		rover.moveBackward();
		Assert.assertArrayEquals(rover.getLocation(), new_loc);
	}
	
	@Test
	public void leftTurn() {
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
	public void rightTurn() {
		
	}
	

}

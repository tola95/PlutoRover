package main;

import org.junit.Test;
import org.junit.Assert;

public class PlutoRoverTest {
	
	@Test
	public void initialLocationAtOrigin() {
		PlutoRover rover = new PlutoRover();
		int[] orig_loc = {0, 0};
		Orientation orig_ord = Orientation.NORTH; 
		Assert.assertArrayEquals(rover.getLocation(), orig_loc);
		Assert.assertEquals(rover.getOrd(), Orientation.NORTH);
	}
	

}

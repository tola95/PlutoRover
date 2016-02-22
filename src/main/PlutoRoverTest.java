package main;

import org.junit.Test;
import org.junit.Assert;

public class PlutoRoverTest {
	
	@Test
	public void initialLocationAtOrigin() {
		PlutoRover rover = new PlutoRover();
		int[] orig = {0, 0};
		Assert.assertArrayEquals(rover.getLocation(), orig);
	}

}

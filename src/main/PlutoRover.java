package main;

public class PlutoRover {
	
	private int x;
	private int y;
	private Orientation ord;

	public PlutoRover() {
		//Initialise location of Rover
		this.x = 0;
		this.y = 0;
		this.ord = Orientation.NORTH;
	}
	
	public int[] getLocation() {
		int[] res = new int[2];
		res[0] = x;
		res[1] = y;
		return res;
	}

	public Orientation getOrd() {
		return ord;
	}

}

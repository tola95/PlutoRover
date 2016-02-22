package main;

import static main.Orientation.*;

public class PlutoRover {
	
	private int x;
	private int y;
	private Orientation ord;
	private static final int PLUTO_LENGTH = 1000; //Random chosen length and width for pluto
	private static final int PLUTO_WIDTH = 1000;

	public PlutoRover() {
		//Initialise location of Rover
		this.x = 0;
		this.y = 0;
		this.ord = NORTH;
	}
	
	private int getX() {
		return this.x;
	}
	
	private void setX(int x) {
		this.x = x;
	}
	
	private int getY() {
		return this.y;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	//Returns x,y location of rover
	public int[] getLocation() {
		int[] res = new int[2];
		res[0] = x;
		res[1] = y;
		return res;
	}

	private void setOrd(Orientation ord) {
		this.ord = ord;
	}
	
	//Returns current direction rover points to
	public Orientation getOrd() {
		return ord;
	}
	
	//Updates rovers location depending on direction being pointed to
	public void moveForward() {
		switch (ord) {
			case NORTH : setY((getY() + 1 + PLUTO_LENGTH) % PLUTO_LENGTH); break;
			case SOUTH : setY((getY() - 1 + PLUTO_LENGTH) % PLUTO_LENGTH); break;
			case EAST : setX((getX() + 1 + PLUTO_WIDTH) % PLUTO_WIDTH); break;
			case WEST : setX((getX() - 1 + PLUTO_WIDTH) % PLUTO_WIDTH); break;
			default : break;
		}
	}
	
	//Updates rovers location depending on direction being pointed to
	public void moveBackward() {
		switch (ord) {
			case NORTH : setY((getY() - 1 + PLUTO_LENGTH) % PLUTO_LENGTH ); break;
			case SOUTH : setY((getY() + 1 + PLUTO_LENGTH) % PLUTO_LENGTH); break;
			case EAST : setX((getX() - 1 + PLUTO_WIDTH) % PLUTO_WIDTH); break;
			case WEST : setX((getX() + 1 + PLUTO_WIDTH) % PLUTO_WIDTH); break;
			default : break;
		}
	}
	
	//Changes rovers orientation depending on current orientation
	public void leftTurn() {
		switch (ord) {
			case NORTH : setOrd(WEST); break;
			case SOUTH : setOrd(EAST); break;
			case EAST : setOrd(NORTH); break;
			case WEST : setOrd(SOUTH); break;
			default : break;
		}
	}

	//Changes rovers orientation depending on current orientation
	public void rightTurn() {
		switch (ord) {
			case NORTH : setOrd(EAST); break;
			case SOUTH : setOrd(WEST); break;
			case EAST : setOrd(SOUTH); break;
			case WEST : setOrd(NORTH); break;
			default : break;
		}
	}
}

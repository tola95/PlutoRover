package main;

import static main.Orientation.*;

public class PlutoRover {
	
	private int x;
	private int y;
	private Orientation ord;

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
	
	public int[] getLocation() {
		int[] res = new int[2];
		res[0] = x;
		res[1] = y;
		return res;
	}

	private void setOrd(Orientation ord) {
		this.ord = ord;
	}
	
	public Orientation getOrd() {
		return ord;
	}
	
	public void moveForward() {
		switch (ord) {
			case NORTH : setY(getY() + 1); break;
			case SOUTH : setY(getY() - 1); break;
			case EAST : setX(getX() + 1); break;
			case WEST : setX(getX() - 1); break;
			default : break;
		}
	}
	
	public void moveBackward() {
		switch (ord) {
			case NORTH : setY(getY() - 1); break;
			case SOUTH : setY(getY() + 1); break;
			case EAST : setX(getX() - 1); break;
			case WEST : setX(getX() + 1); break;
			default : break;
		}
	}
	
	public void leftTurn() {
		switch (ord) {
			case NORTH : setOrd(WEST); break;
			case SOUTH : setOrd(EAST); break;
			case EAST : setOrd(NORTH); break;
			case WEST : setOrd(SOUTH); break;
			default : break;
		}
	}

}

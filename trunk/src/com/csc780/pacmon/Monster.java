package com.csc780.pacmon;

public class Monster {

	private int x;
	private int y;
	private int dir;
	private int normalSpeed;
	
	private int state;  // 0 = in cage, 1 = door step, 2 outside
	
	
	public Monster(){
		x = 7 * 32;
		y = 9 * 32;
		dir = 2;
		normalSpeed = 2;
		state = 0;
	}
	
	
	
	public void spawnMonster(){
		
	}


	

	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getDir() {
		return dir;
	}



	public int getNormalSpeed() {
		return normalSpeed;
	}



	public void setNormalSpeed(int normalSpeed) {
		this.normalSpeed = normalSpeed;
	}



	public void setDir(int newDirection) {
		// TODO Auto-generated method stub
		
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}
	
}

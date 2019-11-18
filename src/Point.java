/*
* Represents a point in space
*/
public class Point {

	private int x;
	private int y;
	
	// Constructors
	// Default Point Constructors
	public Point() {
        this(0,0);
	}
	
	// Creating a point by x and y Coordinate
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Copy Constructor
	public Point (Point p){
		this ();
		if (p!=null){
		x=p.getX();
		y=p.getY();
		}
	}
	
	// get the x Coordinate
	public int getX() {
		return x;
	}
	
	// get the y Coordinate
	public int getY() {
		return y;
	}
	
	//set new X Coordinate
	public void setX (int x){
		this.x=x;
		}
	
	//set new Y Coordinate
	public void setY (int y){
		this.y=y;
		}
	
	//get the Point as a String 
	public String toString(){
		return "("+x+","+y+")";
		
	}

	//Checking if 2 points are equal
	public Boolean equals(Point p){
		if (p==null)
			return false;
		else
		    return x==p.x & y==p.y;
	}
}

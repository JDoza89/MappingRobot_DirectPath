package DirectRouteCalculator;

import java.awt.Point;
import java.util.ArrayList;

public class DirectPath implements PathInterface {
	
	
	private static Point endPoint;
	private static ArrayList<String> directPath = new ArrayList<String>();
	
	DirectPath(RobotMovement r){
		this.setEndPoint(r.getEndPoint());
		setDirectPath(r.getEndPoint());
	}
	
	public void setEndPoint(int x, int y) {
		endPoint = new Point(x,y);
	}
	
	public void setDirectPath(Point end) {
		String direction = "";
		if(end.y >0) {
			direction = "R" + end.y;
			directPath.add(direction);
			if(end.x > 0) {
				direction = "R" + end.x;
			}
			if(end.x < 0) {
				directPath.add("L" + end.x);
			}
		}
		if(end.y < 0) {
			direction = "L" + end.y;
			directPath.add(direction);
			if(end.x > 0) {
				direction = "L" + end.x;
			}
			if(end.x < 0) {
				directPath.add("R" + end.x);
			}
		}
	}
	
	public ArrayList<String> getPath() {
		return directPath;
	}

	@Override
	public void setEndPoint(Point p) {
		endPoint = p;
		
	}

	@Override
	public void printPath() {
		for(int i = 0; i < directPath.size(); i++) {
			System.out.println(i);
		}
		
	}

}

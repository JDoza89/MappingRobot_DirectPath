package DirectRouteCalculator;

import java.awt.Point;
import java.util.ArrayList;

public class DirectPath implements PathInterface {
	
	
	private static Point endPoint;
	private static ArrayList<String> directPath;
	private String date; 
	private String destination;
	
	DirectPath(RobotMovement r){
		directPath = new ArrayList<String>();
		this.setEndPoint(r.getEndPoint());
		date = r.getRoute().getDate();
		destination = r.getRoute().getDestination();
		directPath.add(date);
		directPath.add(destination);
		setDirectPath(r.getStartPoint(), r.getEndPoint());
	}
	
	public void setEndPoint(int x, int y) {
		endPoint = new Point(x,y);
	}
	
	public void setDirectPath(Point start, Point end) {
		String direction = "";
		
/*		Since our graph does not start at 0,0 and has no negative coordinates, we base out coordinates on:
		end.y < start.y = top of graph
		end.y > start.y = bottom of graph
		example:
		0 0 0 0 E1 0
		0 0 0 S 0  0
		0 E2 0 0 0 0
		
		In this 3x6 graph, we see that:
		E1 is (4,0)
		S = (3, 1)
		E2 = (1, 2)
		
		E2.y > S.y && E1. y < S
		*/
		
		if(end.y > start.y) {
			direction = "L" + (start.y - end.y);
			directPath.add(direction);
			if(end.x < start.x) {
				direction = "R" + (start.x - end.x);
				directPath.add(direction);
			}
			else if(end.x > start.x) {
				direction = "L" + (end.x - start.x);
				directPath.add(direction);
			}
			else {
				direction = "R" + 0;
				directPath.add(direction);
			}
		}
		else if(end.y <= start.y) {
			direction = "R" + (start.y - end.y);
			directPath.add(direction);
			if(end.x < start.x) {
				direction = "L" + (start.x - end.x);
				directPath.add(direction);
			}
			else if(end.x > start.x) {
				direction = "R" + (end.x - start.x);
				directPath.add(direction);
			}
			else {
				direction = "R" + 0;
				directPath.add(direction);
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
		System.out.print(date + "; " + destination + "; ");
		for(int i = 2; i < directPath.size(); i++) {
			System.out.print(directPath.get(i) + " ");
		}
		System.out.println();
	}

}

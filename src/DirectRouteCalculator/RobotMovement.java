package DirectRouteCalculator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class RobotMovement implements Movement{
	private static String facing;
	ArrayList<String> faces = new ArrayList<String>(Arrays.asList("N", "W", "E", "S"));
	private static Point startPoint;
	private static Point currentPosition;
	private static Point endPoint;
	private Graph graph = null;
	private Route route;
	
	RobotMovement(Graph g, Route r){
		facing = "W";
		graph = g;
		startPoint = g.getStartPoint();
		currentPosition = g.getStartPoint();
		route =r;
		setDirections(r);
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setDirections(Route dir) {
		String[] directs = dir.getParsedDirections();
		for(int i = 0; i < directs.length; i++) {
		//	System.out.println(s);
			if(directs[i].charAt(0) == 'L') {
				moveLeft(Integer.parseInt(directs[i].substring(1)));
			}
			else if(directs[i].charAt(0) == 'R') {
				moveRight(Integer.parseInt(directs[i].substring(1)));
			}
			if(i == directs.length-1) {
				endPoint = currentPosition;
			}
		}
		
	}
	
	public void setFacing(String s) {
		if(faces.contains(s)) {
			facing = s;
		}
	}
	
	public void setGraph(Graph g) {
		graph = g;
	}
	
	public Point moveLeft(int l) {

		if(facing.equals("W")) {
			graph.setPoint(currentPosition.x,currentPosition.y +l,2);
			currentPosition = new Point(currentPosition.x,currentPosition.y +l);
			facing = "S";
		}
		else if(facing.equals("N")) {
			graph.setPoint(currentPosition.x-l ,currentPosition.y,2);
			currentPosition = new Point(currentPosition.x-l,currentPosition.y);
			facing = "W";
		}
		
		else if(facing.equals("E")) {
			graph.setPoint(currentPosition.x,currentPosition.y-l,2);
			currentPosition = new Point(currentPosition.x,currentPosition.y-l);
			facing = "N";
		}
		
		else if(facing.equals("S")) {
			graph.setPoint(currentPosition.x+l,currentPosition.y,2);
			currentPosition = new Point(currentPosition.x+l,currentPosition.y);
			facing = "E";
		}
	
		else System.out.println("Incorrect value format. Must be one of the following N, E, S, W.");
	return currentPosition;
}

public Point moveRight(int r) {
		
		if(facing.equals("W")) {
			graph.setPoint(currentPosition.x,currentPosition.y - r, 2);
			currentPosition = new Point(currentPosition.x,currentPosition.y -r);
			facing = "N";
		}
		else if(facing.equals("N")) {
			graph.setPoint(currentPosition.x + r,currentPosition.y,2);
			currentPosition = new Point(currentPosition.x +r,currentPosition.y);
			facing = "E";
		}
		
		else if(facing.equals("E")) {
			graph.setPoint(currentPosition.x,currentPosition.y+r,2);
			currentPosition = new Point(currentPosition.x,currentPosition.y+r);
			facing = "S";
		}
		
		else if(facing.equals("S")) {
			graph.setPoint(currentPosition.x-r,currentPosition.y,2);
			currentPosition = new Point(currentPosition.x-r,currentPosition.y);
			facing = "W";
		}
		
		else System.out.println("Incorrect value format. Must be one of the following N, E, S, W.");
	
	return currentPosition;
}
	
	public void setEndPoint(int x, int y) {
		endPoint = new Point(x,y);
	}
	
	public Point getEndPoint() {
		
		return endPoint;
	}

	@Override
	public Point getStartPoint() {
		return startPoint;
	}

	@Override
	public void setStartPoint(int x, int y) {
		startPoint = new Point(x,y);
		
	}

	@Override
	public void setEndPoint(Point p) {
		endPoint = p;
		
	}

	@Override
	public void setStartPoint(Point p) {
		startPoint = p;
		
	}
	
}

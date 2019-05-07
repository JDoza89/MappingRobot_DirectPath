package DirectRouteCalculator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class RobotMovement implements Movement{
	private static String facing = "W";
	ArrayList<String> faces = new ArrayList<String>(Arrays.asList("N", "W", "E", "S"));
	private static Point startPoint;
	private static Point currentPosition;
	private static Point endPoint = new Point();
	private Graph graph = null;
	
	RobotMovement(Graph g){
		graph = g;
		startPoint = g.getStartPoint();
		currentPosition = g.getStartPoint();
		setDirections(g.getRoute());
	}
	
	public void setDirections(Route dir) {
		String[] directs = graph.getRoute().getParsedDirections();
		for(String s : directs) {
			//System.out.println(s);
			if(s.charAt(0) == 'L') {
				moveLeft(Integer.parseInt(s.substring(1)));
			}
			else if(s.charAt(0) == 'R') {
				moveRight(Integer.parseInt(s.substring(1)));
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
				graph.setPoint(currentPosition.x - l,currentPosition.y,1);
				currentPosition = new Point(currentPosition.x - l,currentPosition.y);
				facing = "S";
			}
			if(facing.equals("N")) {
				graph.setPoint(currentPosition.x,currentPosition.y - l,1);
				currentPosition = new Point(currentPosition.x,currentPosition.y - l);
				facing = "W";
			}
			
			if(facing.equals("E")) {
				graph.setPoint(currentPosition.x + l,currentPosition.y,1);
				currentPosition = new Point(currentPosition.x + l,currentPosition.y);
				facing = "N";
			}
			
			if(facing.equals("S")) {
				graph.setPoint(currentPosition.x,currentPosition.y + l,1);
				currentPosition = new Point(currentPosition.x,currentPosition.y + l);
				facing = "E";
			}
		
			else System.out.println("Incorrect value format. Must be one of the following N, E, S, W.");
		return new Point();
	}
	
	public Point moveRight(int r) {
			
			if(facing.equals("W")) {
				graph.setPoint(currentPosition.x + r,currentPosition.y, 1);
				currentPosition = new Point(currentPosition.x + r,currentPosition.y);
				facing = "N";
			}
			if(facing.equals("N")) {
				graph.setPoint(currentPosition.x,currentPosition.y + r,1);
				currentPosition = new Point(currentPosition.x,currentPosition.y + r);
				facing = "E";
			}
			
			if(facing.equals("E")) {
				graph.setPoint(currentPosition.x - r,currentPosition.y,1);
				currentPosition = new Point(currentPosition.x - r,currentPosition.y);
				facing = "S";
			}
			
			if(facing.equals("S")) {
				graph.setPoint(currentPosition.x,currentPosition.y - r,1);
				currentPosition = new Point(currentPosition.x,currentPosition.y - r);
				facing = "W";
			}
			
			else System.out.println("Incorrect value format. Must be one of the following N, E, S, W.");
		
		return new Point();
	}
	
	public void setEndPoint(int x, int y) {
		endPoint = new Point(x,y);
	}
	
	public Point getEndPoint() {
		
		return endPoint;
	}
	
}

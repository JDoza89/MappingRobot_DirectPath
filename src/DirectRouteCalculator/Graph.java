package DirectRouteCalculator;

import java.awt.Point;
import java.util.ArrayList;

public class Graph implements GraphInterface{
	private static int[][] graph;
	Route directions;
	
	Graph(Route r){
		directions = r;
		createGraph();
	}
	
	public void createGraph() {
		graph = new int[100][100];
		
		for(int i = 0; i < graph[0].length; i++) {
			for(int j = 0; j < graph.length; j++) {
				graph[i][j] = 0;
			}	
		}
		graph[graph.length/2][graph.length/2] = 1;
	}
	
	public Point getStartPoint() {
		return new Point(graph.length/2, graph.length/2);
	}
	
	public Route getRoute() {
		return directions;
	}
	
	public int[][] getGraph() {
		return graph;
	}

	@Override
	public void setPoint(Point p, int value) {
		graph[p.x][p.y] = value;
	}

	@Override
	public void setPoint(int x, int y, int value) {
		graph[x][y] = value;
	}
	
}


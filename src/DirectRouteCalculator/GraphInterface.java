package DirectRouteCalculator;

import java.awt.Point;

public interface GraphInterface {
	
	public void createGraph(int size);
	
	public int[][] getGraph();
	
	public void setPoint(Point p, int value);
	
	public void setPoint(int x, int y, int value);

	public Point getStartPoint();
}

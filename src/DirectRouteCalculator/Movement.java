package DirectRouteCalculator;

import java.awt.Point;

public interface Movement {
	
	public Point moveLeft(int l);
	
	public Point moveRight(int r);
	
	public Point getStartPoint();
	
	public Point getEndPoint();
	
	public void setEndPoint(int x, int y);
	
	public void setStartPoint(int x, int y);
	
	public void setEndPoint(Point p);
	
	public void setStartPoint(Point p);

}

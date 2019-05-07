package DirectRouteCalculator;

import java.awt.Point;
import java.util.ArrayList;

//This interface can be used if there are other path finding programs created.

public interface PathInterface {
	
	public void setEndPoint(int x, int y);
	
	public void setEndPoint(Point p);
	
	public void setDirectPath(Point end);
	
	public ArrayList<String> getPath();
	
	public void printPath();
	

}

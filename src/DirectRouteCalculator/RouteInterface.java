package DirectRouteCalculator;

public interface RouteInterface {
	
	public String getDate();
	
	public String getDestination();
	
	public String getDirections();
	
	public String getRoute();
	
	public void printRoute();
	
	public String[] getParsedDirections();
}

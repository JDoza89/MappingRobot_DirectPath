package DirectRouteCalculator;

public class Route implements RouteInterface{
	private static String date, destination, directions;
	private static String[] directionsList;
	
	Route(String date, String destination, String directions){
		this.date = date;
		this.destination = destination;
		this.directions = directions;
		this.directionsList = directions.split("\\s*,\\s+");
	}
	
	Route(String s){
		String[] str = s.split("\\s*;\\s+");
		date = str[0];
		destination = str[1];
		directions = str[2];
		directionsList = str[2].split("\\s*,\\s+");
	}

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public String getDestination() {
		return destination;
	}

	@Override
	public String getDirections() {
		return directions;
	}

	@Override
	public String getRoute() {
		return this.toString();
	}

	@Override
	public void printRoute() {
		System.out.println(date + "; " + destination + "; " + directions);
		
	}

	@Override
	public String[] getParsedDirections() {
		return directionsList;
	}

	@Override
	public int getTotalBlocks() {
		int total = 0;
		for(int i =0; i < directionsList.length; i++) {
			total += Integer.parseInt(directionsList[i].substring(1));
		}
		return total;
	}
	


}

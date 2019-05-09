package DirectRouteCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ReadInput {
	private Graph graph;
	
	public static void readFile(String file) {
		try {
		FileReader inputFile = new FileReader(file);
		BufferedReader reader = new BufferedReader(inputFile);
		
		String strLine;

		while ((strLine = reader.readLine()) != null) {
				Graph graph = new Graph(new Route(strLine));
				RobotMovement rm = new RobotMovement();
				rm.setGraph(graph);
				rm.setRoute(new Route(strLine));
				DirectPath dp = new DirectPath();
				dp.setRobotMovement(rm);
				//print graph
				/*
				 * for(int[] j : graph.getGraph()) {
					for (int i : j) {
						System.out.print(i);
				        System.out.print("\t");
				       }
				       System.out.println();
				   }*/
				dp.printPath();

		}
		reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public static void main(String[] args) {
		readFile("src//input.txt");
				if(args.length == 0) {
			System.out.println("Please type in file you would like to read");
		}
		
		for(String s : args) {
			readFile(s);
		}
		

}
}

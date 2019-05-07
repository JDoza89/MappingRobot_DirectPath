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
		//StringTokenizer st = null;
		
		while ((strLine = reader.readLine()) != null) {
			//String[] s = strLine.split("\\s*;\\s+");
			/*for(String ss : s) {
				System.out.println(ss);
			}*/
				Graph graph = new Graph(new Route(strLine));
				RobotMovement rm = new RobotMovement(graph);
				DirectPath dp = new DirectPath(rm);
				dp.printPath();
/*			st = new StringTokenizer(strLine,"\\s*;\\s+");
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
		*/
		}
		reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}
	
/*	public static String[] parseData(String line) {
		
	}
*/
	public static void main(String[] args) {
		//readFile("src//input.txt");
				if(args.length == 0) {
			System.out.println("Please type in file you would like to read");
		}
		
		for(String s : args) {
			readFile(s);
		}
		

}
}

import java.util.*;

public class Test {
	
	public static void main(String []args){
		long startTime = System.nanoTime();
		Location[] parent = readData();
		double iter = 0;
		while(iter <= 50000000){
			double length=parent[0].dist(parent[1]);	
			
			iter+=1;
		}
		long endTime = System.nanoTime();	
		long duration = (endTime - startTime);
		System.out.println(duration);
		
		
	}
	public static Location[] readData(){
		Scanner scanner = new Scanner(System.in);
		int Nlocations = Integer.parseInt(scanner.nextLine());
		Location[] parent = new Location[Nlocations];
		int index = 0;
		while(scanner.hasNext()) {
			String[] temp = scanner.nextLine().split(" ");//temp holds the values of the line before they are converted to a string and 2 doubles 
			parent[index] = new Location(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]));
			index += 1;
			
		}
		scanner.close();
		return parent;
	}

}
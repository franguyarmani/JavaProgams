


import java.util.*;

public class TravelingSalesman {
	static int Npaths = 10000;
	static double mutationrate = 0.95;





	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Random R = new Random();
		Location[] parent = readData();
		System.out.println("Data imported");
		Path[] population = new Path[Npaths];

		for(int i=0; i<Npaths; i++){					//an array of locations to be converted to a Path
			population[i] = new Path(FYshuffle(parent));
		}
		System.out.println("Population created");

		double mutationPopulation = Npaths*mutationrate;
		int iter = 0;
		while(iter<2000){
			
			Arrays.sort(population);
			for (int i = Npaths-1; i>(int)mutationPopulation-1 ; i--){
				population[i] = population[R.nextInt((int)mutationPopulation)].getMutant();
			}
			iter+=1;
			
			population[0].draw();
			
		}
		long endTime = System.nanoTime();	
		long duration = (endTime - startTime);
		System.out.println("done");
		System.out.println(duration/1000000);
		
		System.out.println(population[0].length());
		
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
	
	public static Location[] FYshuffle(Location[] array){
		Location[] shuffled = new Location[array.length];
		System.arraycopy(array, 0, shuffled, 0, array.length);
	    Random R = new Random();
	    
	    for (int i = shuffled.length - 1; i > 0; i--){
	    	int index = R.nextInt(i + 1);
	    	Location a = shuffled[index];
	    	shuffled[index] = shuffled[i];
	    	shuffled[i] = a;
	    }
	    return shuffled;
	  }

}

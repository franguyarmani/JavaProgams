
import java.util.Random;



public class Path implements Comparable<Path> {
	private Location[] Path;
	private int Nlocations;
	private double length;
	Random R = new Random();
	
	// constructor
	public Path(Location[] pathArray) {
		Nlocations = pathArray.length;
		Path = new Location[Nlocations];
		System.arraycopy(pathArray, 0, Path, 0, Nlocations);
		
		for(int i = 0; i < Nlocations-1; i++){
			Location Location1 = this.Path[i];
			Location Location2 = this.Path[i+1];			
			length+=Location1.dist(Location2);	
		}
		length+=this.Path[Nlocations-1].dist(this.Path[0]);
	}
	// compute the length of this Path
	public double length() {
		
		return length;
	}
	
	// fulfill the Comparable<Path> interface
	// our comparison should have the property: shortPath < longPath
	public int compareTo(Path other){
		return Double.compare(this.length(), other.length());	
	}
	
	// reproduce this Path with a random swap mutation
	public Path getMutant() {
		Location[] mutant = new Location[Nlocations];
		System.arraycopy(Path, 0, mutant, 0, Nlocations);
		int index1 = R.nextInt(Nlocations);
		int index2 = R.nextInt(Nlocations);
    	Location a = mutant[index1];
    	mutant[index1] = mutant[index2];
    	mutant[index2] = a;
		Path mutantPath = new Path(mutant);
		return mutantPath;
	}
	// (optional) draw the Path using StdDraw
	public void draw() {
		
		for (int i=0; i<Nlocations-1; i++){
			StdDraw.line(Path[i].getLatitudeDeg(), Path[i].getLongitudeDeg(), Path[i+1].getLatitudeDeg(), Path[i+1].getLongitudeDeg());
			System.out.println("pen");
			draw();
		}
		StdDraw.line(Path[Nlocations-1].la, Path[Nlocations-1].lo, Path[0].la, Path[0].lo);
		
	}
}

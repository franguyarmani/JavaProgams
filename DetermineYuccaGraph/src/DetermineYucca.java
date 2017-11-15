import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class DetermineYucca {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("src/Input6.txt");
		BufferedReader buff = new BufferedReader(reader);
		Scanner input = new Scanner(buff);
		int[][] matrix = new int[6][6];
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 6; j++) {
				if (input.hasNextInt()) {
					int temp = input.nextInt();
					matrix[i][j] = temp;
				}
			}
		}
		input.close();
		System.out.println(Arrays.deepToString(matrix));
		if (checkMatrix(matrix)) {
			System.out.println("the graph is yucca");
		}else{
			System.out.println("the graph is not yucca");
		};
		
		
	}
	
	public static boolean checkMatrix(int[][] matrix) {
		for (int x = 0; x < 6; x++) {
			if (!checkRow(matrix, x)) {
				continue;
			}
			if (!checkCol(matrix, x)) {
				continue;
			}
			return true;
		}
		return false;	
		
	}
	
	public static boolean checkRow(int[][] matrix, int pointer) {
		for (int y = 0; y < 6; y++) {
			if(matrix[pointer][y] == 0 && y != pointer) {
				System.out.print(pointer);
				System.out.println(y);
				System.out.println(matrix[pointer][y]);
				return false;
			}
		}
		return true;
	}
	public static boolean checkCol(int[][] matrix, int pointer) {
		for (int y = 0; y < 6; y++) {
			if(matrix[y][pointer] == 1 && y != pointer) {
				return false;
			}
		}
		return true;
	}

}

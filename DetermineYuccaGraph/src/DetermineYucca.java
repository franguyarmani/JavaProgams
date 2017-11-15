import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class DetermineYucca {

	public static void main(String[] args) {
		FileReader reader = new FileReader("Input0.txt");
		BufferedReader buff = new BufferedReader(reader);
		int[][] matrix = new int[6][6];
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 6; j++) {
				if (buff.hasNextInt()) {
					int temp = input.nextInt();
					matrix[i][j] = temp;
					System.out.println(temp);
				}
			}
		}
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
			if(matrix[y][pointer] == 0 && y != pointer) {
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

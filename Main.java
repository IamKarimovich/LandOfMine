import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int row,col;
		
		System.out.println("Welcome to my Land of Mine game!");
		System.out.println("Please select dimension of map: ");
		System.out.print("Row: ");
		row = scan.nextInt();
		System.out.print("Column: ");
		col = scan.nextInt();
		
		LandOfMine mine = new LandOfMine(row, col);
		
		mine.run();
		
	}

}

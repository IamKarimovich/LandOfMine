import java.util.Random;
import java.util.Scanner;

public class LandOfMine {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	int[][] map;
	int[][] board;
	int size,rowNumber,colNumber;
	
	LandOfMine(int rowNumber,int colNumber) {		
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.map = new int[rowNumber][colNumber];
		this.board = new int[rowNumber][colNumber];
		this.size = rowNumber*colNumber;
	}
		
	public void run()
	{
		prepareGame();
		//print(map);
		//System.out.println("------------------------------");
		print(board);
		int row,col,counter = 0;
		boolean gameStatus = true;
		
		while(gameStatus)
		{
		System.out.println("Row: ");
		row = scan.nextInt();
		System.out.println("Column: ");
		col = scan.nextInt();
			if(row>=0 && col>=0 && row<=rowNumber && col<=colNumber) {
				if(map[row-1][col-1] != -1) {
					
					if(board[row-1][col-1]!=0) {
						System.out.println("You have selected here! ");
						continue;
					}
					else
					{
						check(row, col);
						
						System.out.println("You found empty place,continue");
						
						print(board);
						counter++;
						if(counter == (size - (size/4))) {
							System.out.println("You win!");
							gameStatus = false;
						}
					
					}
				}
				else {
					System.out.println("You lose with "+counter+" point!");
					gameStatus = false;
				}
			}else {
				System.out.println("Entered incorrect value! try again");
				continue;
			}
			
		}
		
	}
	
	public void prepareGame()
	{
		int count = 0,randCol,randRow;
		
		while(count != (size/4))
		{
			randCol = rand.nextInt(colNumber);
			randRow = rand.nextInt(rowNumber);
			
			if(map[randRow][randCol] != -1) {
				map[randRow][randCol] = -1;
				count++;
			}
		}	
	}
	
	public void print(int[][] array)
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j =0;j<array[0].length;j++)
			{
				if(array[i][j]>=0)
					System.out.print(" ");
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void check(int row,int col)
	{
		if(map[row-1][col-1]==0) 
		{
			if((row-2)>=0 && map[row-2][col-1] == -1) //ust
				board[row-1][col-1]++;
			if((col-2)>=0 && map[row-1][col-2] == -1) //sol
				board[row-1][col-1]++;
			if( (col<colNumber) && map[row-1][col] == -1) // sag
				board[row-1][col-1]++;
			if( (row<rowNumber) && map[row][col-1] == -1) // alt
				board[row-1][col-1]++;
			if( board[row-1][col-1]==0)
				board[row - 1][col - 1] = -2;
		}
		
	
	}
	
	
	
}

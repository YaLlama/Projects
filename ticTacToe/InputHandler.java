
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
	
	private int input, colum, row;
	Scanner getinput = new Scanner(System.in);

	public int getInput(int Turn, int gameArray[][]) {
		while(1 <= 1) {
			try {
				System.out.print("Pick a place to move player " + (Turn+1) + ":" );
				input = getinput.nextInt();
				if(1 <= input && input <= 9) {
					colum = input % 3 - 1;
					row = Math.floorDiv(input, 3);
					if(colum == -1) {
						colum = 2;
						row--;
					}
					if(gameArray[row][colum] == 2) {
						break;
					}
					else {
						System.out.println("Sorry, that number is invalid, please try again.");
					}
						
					
				}
				else {
					System.out.println("Sorry, that number is invalid, please try again.");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Sorry, that number is invalid, please try again.");
			}
			getinput.nextLine();
		}
		return(input);
	}
	
}

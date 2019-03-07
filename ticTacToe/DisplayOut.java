
public class DisplayOut {
	public void displayOut(int gameArray[][]) {
		for(int rows = 0; rows <gameArray.length; rows++) {

			for(int colums = 0; colums < gameArray[rows].length; colums++) {
			
				switch(gameArray[rows][colums]) {
			
				case 0:
					System.out.print("| o |");
					break;
				case 1:
					System.out.print("| x |");
					break;
				case 2:
					System.out.print("| " + (1 + (rows*gameArray[rows].length + colums)) + " |");
					break;
				}
			}
	
			System.out.println();	
		}
	}
}

public class MainLoop {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//class objects
		DisplayOut output = new DisplayOut();
		InputHandler input = new InputHandler();
		
		
		//variables
		boolean GameEnd = false;
		int totalTurns = 0;
		int move;
		int row;
		int colum;
		int xWin = 0;
		int oWin = 0;
		int gameArray[][] = {{2, 2, 2},
							 {2, 2, 2},
							 {2, 2, 2}};
		int WinningSet[][] = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
		int xSet[] = {0,0,0,0,0,0,0,0,0};
		int oSet[] = {0,0,0,0,0,0,0,0,0};
		
		//turns and game loop
		for(int Turn = 0; Turn < 2; Turn++) {
			if(GameEnd) {
				break;
			}
			
			//game Display
			output.displayOut(gameArray);
			
			//input Handler
			move = input.getInput(Turn ,gameArray);
			
			// game Update
			
			if(1 <= move && move <= 9) {
				colum = move % 3 - 1;
				row = Math.floorDiv(move, 3);
				if(colum == -1) {
					colum = 2;
					row--;
				}
				gameArray[row][colum] = Turn;
				if(Turn == 0) {
					oSet[move-1] = 1;
				}
				else {
					xSet[move-1] = 1;
				}
			}
			
			// keep turn below 2
			if(Turn == 1) {
				Turn = -1;
			}
			
			//Winning the game
			for(int setnum = 0; setnum < WinningSet.length; setnum++) {
				
				//winning set groups winningSet[set]
				
				
				
				for(int n = 0; n < WinningSet[setnum].length; n++) {
					//x win
					for(int player = 0; player < xSet.length; player++) {
						if(xSet[player] == 1) {
							if(WinningSet[setnum][n] == player+1) {
								xWin++;
								if(xWin == 3) {
									System.out.println("x Wins!");
									GameEnd = true;
									output.displayOut(gameArray);
								}
							}
						}
						
					}
					
					//o win
					for(int player = 0; player < oSet.length; player++) {
						if(oSet[player] == 1) {
							if(WinningSet[setnum][n] == player+1) {
								oWin++;
								if(oWin == 3) {
									System.out.println("o Wins!");
									GameEnd = true;
									output.displayOut(gameArray);
								}
							}
						}

					}
				}
				oWin = 0;
				xWin = 0;
			}

			totalTurns++;
			if(totalTurns == 9) {
				System.out.println("Tie!");
				break;
			}
		}
	}
	
}

	
	


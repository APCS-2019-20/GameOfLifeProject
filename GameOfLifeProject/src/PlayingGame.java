import java.util.Scanner; 
import java.util.ArrayList; 

public class PlayingGame
{
	static Scanner userInput = new Scanner(System.in); 
	static int currentPlayer = 1; 
	static int notCurrentPlayer = 0; 
	static boolean playing = true; 

	public static void play()
	{ 
		while(playing)
		{ 
			//switches player before the turn 
			
					
			SwitchPlayers.switchCurrentPlayer();
			
			if (Runner.players.get(currentPlayer).getTotalMoney() >= 200000
					|| Runner.players.get(notCurrentPlayer).getTotalMoney() >= 200000)
				{
				Runner.screen.updateMessage(
							"You win the game of life! Now you can retire and live a happy, rich life");
					playing = false;
				}
			
	
			Runner.screen.updateMessage(Runner.players.get(currentPlayer).getName() + ", press enter to spin for your turn...");
			
			int currentPlayerSpin = (int)((Math.random() * 7) + 1);
			
			int currentPlace = Runner.players.get(currentPlayer).getPlaceOnBoard();
			
			Runner.screen.updateMessage(Runner.players.get(currentPlayer).getName() + ", you spun a total of " + currentPlayerSpin + ".");
					
			Runner.players.get(currentPlayer).moveForward(currentPlayerSpin);
			
			OptionsWhenYouLandOnTile.landOnTile(currentPlace + currentPlayerSpin);
			

		

			
			
			
		}
	}

}

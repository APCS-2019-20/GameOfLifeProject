import java.util.Scanner; 

public class OptionalTileMethods 
{
	static Player currentPlayer = Runner.players.get(PlayingGame.currentPlayer); 
	
	public static void randomOptionalMethod()
	{
		
		int randomNumber = (int)((Math.random() * 5) + 1);
		
		if(randomNumber == 2)
		{ 
			Runner.screen.updateMessage("Night Classes, you moved back 1 tile.");
			int place = currentPlayer.getPlaceOnBoard(); 
			currentPlayer.setPlaceOnBoard(place-1);
			
		}
		
		else if(randomNumber == 1)
		{ 
			Runner.screen.updateMessage("You won the lottery! You won 15000");
			currentPlayer.addMoney(15000);
		}
		
		else if(randomNumber == 3)
		{
			Runner.screen.updateMessage("You had a kid! Move forward 3 spaces");
			int place = currentPlayer.getPlaceOnBoard(); 
			currentPlayer.setPlaceOnBoard(place+3);
		}
		
		else if(randomNumber == 4)
		{
			Runner.screen.updateMessage("Tax! You are taxed $3000");
			currentPlayer.addMoney(-3000);
		}
		
		else if(randomNumber == 5)
		{
			Runner.screen.updateMessage("Stock market crash, you lost 4000");
			currentPlayer.addMoney(-4000);
			
		}
	}
	

}

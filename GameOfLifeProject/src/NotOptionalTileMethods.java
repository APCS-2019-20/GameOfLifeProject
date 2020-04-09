
public class NotOptionalTileMethods 
{
	static Player currentPlayer = Runner.players.get(PlayingGame.currentPlayer); 
	
	public static void randomNotOptionalMethod()
	{ 
		int randomNumber = (int)((Math.random() * 5) + 1);
		
		if(randomNumber == 1)
		{ 
			Runner.screen.updateMessage("Tax! You are taxed $5000");
			currentPlayer.addMoney(-5000);
		}
		
		else if(randomNumber == 2)
		{ 
			Runner.screen.updateMessage("You won the lottery! You won $10000");
			currentPlayer.addMoney(10000);
		}
		
		else if(randomNumber == 3)
		{
			Runner.screen.updateMessage("You climbed everest! Here's $2000 for your efforts!");
			currentPlayer.addMoney(2000);
		}
		
		else if(randomNumber == 4)
		{
			Runner.screen.updateMessage("House Fire! You lost $6000");
			currentPlayer.addMoney(-6000);
		}
		
		else if(randomNumber == 5)
		{
			Runner.screen.updateMessage("You took more classes and you got a bonus of $20000!");
			currentPlayer.addMoney(20000); 
		}
	}
}


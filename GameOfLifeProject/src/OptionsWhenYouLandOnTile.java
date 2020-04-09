import java.util.Scanner; 

public class OptionsWhenYouLandOnTile 
{
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputInt = new Scanner(System.in); 
	
	public static void landOnTile(int place)
	{ 
		
		if(Runner.board.get(place).getType().equals("MiniGameTile"))
		{
			 landOnMiniGameTile(); 
		}
		
		else if(Runner.board.get(place).getType().equals("LifeTile"))
		{ 
			landOnLifeTile(); 
		}
		
		else if(Runner.board.get(place).getType().equals("NotOptionalTile"))
		{ 
			landOnNotOptionalTile(); 
		}
		
		else if(Runner.board.get(place).getType().equals("OptionalTile"))
		{ 
			landOnOptionalTile(); 
		}
		
		else if(Runner.board.get(place).getType().equals("GetMarriedTile"))
		{ 
			landOnGetMarriedTile(); 
		}
		
		else if(Runner.board.get(place).getType().equals("HouseDeedTile"))
		{ 
			landOnHouseDeedTile(); 
			
		}
		
		else if(Runner.board.get(place).getType().equals("MoneyTile"))
		{ 
			landOnMoneyTile(); 
		}
	}
	
	
	public static void landOnMiniGameTile()
	{ 
		Minigames.randomChooser();
	}
	
	public static void landOnLifeTile()
	{ 
		int random = ((int)Math.random()*7) + 1;
		
		LifeTileCard card = Runner.lifeTileCards.get(random); 
		String phrase = card.getPhrase(); 
		int amount = card.getAmount(); 
	
		String[] message = {"You landed on a Life Tile! You get 1 Life Tile Card.", "Statement: " + phrase, "The amount for this is $" + amount};
		Runner.players.get(PlayingGame.currentPlayer).getPlayersLifeTiles().add(card);
		
	}
	
	public static void landOnNotOptionalTile()
	{ 
		String[] message = {"You landed on a Not Optional Tile!","This means you have to complete it."}; 
		Runner.screen.updateMessage(message);
		NotOptionalTileMethods.randomNotOptionalMethod();
	}
	
	public static void landOnOptionalTile()
	{ 
		String[] message1 = {"You landed on an Optional Tile!", "This means that you get to choose if you want to complete it"};
		Runner.screen.updateMessage(message1);
		String[] message2 = {"Would you like to complete this task? You wont find out until after you decide...", "(1) Yes", "(2) No"};
		Runner.screen.updateMessage(message2); 
		
		int choice = userInputInt.nextInt(); 
		
		if(choice == 1)
		{ 
			OptionalTileMethods.randomOptionalMethod();
		}
		
		Runner.screen.updateMessage("Moving on with the game...");
		
		
	}
	
	public static void landOnGetMarriedTile() 
	{ 
		Runner.screen.updateMessage("You landed on the Get Married Tile! Congradulations, you are now happily married!");
		
	}
	
	public static void landOnHouseDeedTile()
	{ 
		Player currentPlayer = Runner.players.get(PlayingGame.currentPlayer); 
		int random = ((int)Math.random()*8) + 1; 
		HouseDeedCard card = Runner.houseDeedCards.get(random); 
		currentPlayer.getPlayersCards().add(card); 
		int price = card.getCost(); 
		String name = card.getHouseName();
		Runner.screen.updateMessage("You landed on the House Tile! You get to buy a house, now drawing a card...");
		String[] message = {"You drew the " + name + " house.", "The price of this house is $" + price};
		Runner.screen.updateMessage("Would you like to buy this house?\n(1) Yes\n(2) No");
		
		String choice = userInputString.next(); 
		
		if(choice.equals("1"))
		{ 
			currentPlayer.addMoney(-price);
			int currentMoney = currentPlayer.getTotalMoney();
			String[] message2 = {"Great! Your total money is now " + currentMoney}; 
		}
		
		
		
	}
	
	public static void landOnMoneyTile()
	{
		Player currentPlayer = Runner.players.get(PlayingGame.currentPlayer); 
				
		final int initialBalance = currentPlayer.getTotalMoney();
		int salary = 0; 
		
		for(int i = 0; i < currentPlayer.getPlayersCards().size(); i++)
		{ 
			if(currentPlayer.getPlayersCards().get(i).getCardType().equals("CareerCard"))
			{ 
				CareerCard career = ((CareerCard) currentPlayer.getPlayersCards().get(i));
				salary += career.getSalary();
			}
		}
		
		currentPlayer.addMoney(salary); 
		
		int finalBalance = currentPlayer.getTotalMoney(); 

		String[] message = {"You landed on a Pay Day Tile! Time to get paid!", "Your current balance is " + initialBalance, "Your salary is " + salary, "Your total balance is now " + finalBalance};
		
		Runner.screen.updateMessage(message);
	}
}

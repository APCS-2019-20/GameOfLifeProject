import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Runner
	{

		static ArrayList<Player> players = new ArrayList<Player>();	
		static ArrayList<Tile> board = new ArrayList<Tile>(); 
		static ArrayList<LifeTileCard> lifeTileCards = new ArrayList<LifeTileCard>(); 
		static ArrayList<HouseDeedCard> houseDeedCards = new ArrayList<HouseDeedCard>(); 
		static Screen screen = new Screen (35, 140, 10, 10, 23, 45, 10, 10, 10, "THE GAME OF LIFE", "Welcome To The Game Of Life.", true);
		
		public static void main(String[] args) throws FileNotFoundException 
			{
				
				AllCareers.addCareers();
				ReadTileData.fillBoard();
				ReadLifeTileCardsData.readLifeTileCards();
				ReadHouseDeedCardsData.readHouseDeedCards();
				Introduction.greetPlayers();
				Introduction.choosePath(Introduction.playerOneName);
				SwitchPlayers.switchCurrentPlayer();
				Introduction.choosePath(Introduction.playerTwoName);
				SwitchPlayers.switchCurrentPlayer(); 
				PlayingGame.play();


			}

	}

import java.util.ArrayList;
import java.util.List;

public class Player
	{
		private String name;
		//private String jobTitle;
		private int totalMoney;
		private int totalLoans;
		private int placeOnBoard;
		private boolean degree; 
		
		private ArrayList<LifeTileCard> playersLifeTiles = new ArrayList<LifeTileCard>();
		private ArrayList<Card> playersCards = new ArrayList<Card>();

		public Player(String n,/* String jt*/ int tM, int tL, int p, ArrayList<LifeTileCard> pL, ArrayList<Card> pC, boolean d)
			{
				name = n;
				//jobTitle = jt;
				totalMoney = tM;
				totalLoans = tL;
				placeOnBoard = p;
				playersLifeTiles = pL;
				playersCards = pC;
				degree = d; 

			}

//		public String getJobTitle()
//			{
//				return jobTitle;
//			}
//
//		public void setJobTitle(String jobTitle)
//			{
//				this.jobTitle = jobTitle;
//			}

		public boolean isDegree() {
			return degree;
		}

		public void setDegree(boolean degree) {
			this.degree = degree;
		}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getTotalMoney()
			{
				return totalMoney;
			}

		public void setTotalMoney(int totalMoney)
			{
				this.totalMoney = totalMoney;
			}

		public int getTotalLoans()
			{
				return totalLoans;
			}

		public void setTotalLoans(int totalLoans)
			{
				this.totalLoans = totalLoans;
			}

		public int getPlaceOnBoard()
			{
				return placeOnBoard;
			}

		public void setPlaceOnBoard(int placeOnBoard)
			{
				this.placeOnBoard = placeOnBoard;
				Runner.screen.updateBoard();
			}

		public ArrayList<LifeTileCard> getPlayersLifeTiles()
			{
				return playersLifeTiles;
			}

		public void setPlayersLifeTiles(ArrayList<LifeTileCard> playersLifeTiles)
			{
				this.playersLifeTiles = playersLifeTiles;
			}

		public ArrayList<Card> getPlayersCards()
			{
				return playersCards;
			}

		public void setPlayersCards(ArrayList<Card> playersCards)
			{
				this.playersCards = playersCards;
			}

		public void moveForward(int spaces) {
			int spacey = spaces + placeOnBoard;
			if(spacey > 39) {
				spacey -= 40;
			}
			setPlaceOnBoard(spacey);
		}


    public void addMoney(int amount) {
	    totalMoney+=amount;
    }

	}

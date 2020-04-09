import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Introduction
	{
		static Scanner userInput = new Scanner(System.in);
		static Scanner intInput = new Scanner(System.in);
		static String playerOneName;
		static String playerTwoName;
		static ArrayList<LifeTileCard> playerOneLifeTiles = new ArrayList<LifeTileCard>();
		static ArrayList<Card> playerOneCards = new ArrayList<Card>();
		static ArrayList<LifeTileCard> playerTwoLifeTiles = new ArrayList<LifeTileCard>();
		static ArrayList<Card> playerTwoCards = new ArrayList<Card>();

		static String playerOneJobChoice;
		static String playerTwoJobChoice; 

		public static void greetPlayers()
			{
				Runner.screen.updateMessage("Hello, welcome to the Game Of Life. This is a 2 player game.");
				Runner.screen.updateMessage("Player 1, what is your name?");
				playerOneName = userInput.next();
				Runner.screen.updateMessage("Hello " + playerOneName);
				Runner.players.add(new Player(playerOneName, 10000, 0, 0, playerOneLifeTiles, playerOneCards, false));
						
						
				Runner.screen.updateMessage("Player 2, what is your name?");
				playerTwoName = userInput.next();
				Runner.screen.updateMessage("Hello " + playerTwoName);
				Runner.players.add(new Player(playerTwoName, 10000, 0, 0, playerTwoLifeTiles, playerTwoCards, false));

				
				Runner.screen.updateBoard();

				Runner.screen.updateMessage("Okay, it's time to play...");

				Runner.screen.updateMessage("The player with the most money at the end of the game wins");
						
				Runner.screen.updateMessage("Both players start with $10,000");
			} 
		
		public static void choosePath(String name)
		{ 
				String[] s3 = {"To begin the game, " + name + ", would you like to...", "(1) Start your career", "(2) Go to college"};
				Runner.screen.updateMessage(s3);
						
				int playerChoice = intInput.nextInt();

				if (playerChoice == 1)
					{
						String[] s4 = {"You have chosen to start your career!", "Your board position will be set at 10"};
						Runner.screen.updateMessage(s4);
						Runner.players.get(PlayingGame.currentPlayer).setPlaceOnBoard(10);
								
						String[] s5 = {"Now pick a job you would like to have to start your career...", "None of these jobs require a degree"};
						Runner.screen.updateMessage(s5);
						
						
						ArrayList<CareerCard> noDegreeCareers = new ArrayList<CareerCard>(); 
						
						for(int j = 0; j < AllCareers.allCareers.size(); j++)
						{ 
							if(!AllCareers.allCareers.get(j).isDegree())
							{ 
								CareerCard tempCareerCardOne = AllCareers.allCareers.get(j); 
								noDegreeCareers.add(tempCareerCardOne); 
							}
						}
							
						
						ArrayList<String> noDegreeCareerNames = new ArrayList<String>(); 
						
						int counter = 1; 
						
						for(int i = 0; i < AllCareers.allCareers.size(); i++)
						{
							if(!AllCareers.allCareers.get(i).isDegree())
							{ 
								CareerCard tempCareerCard = AllCareers.allCareers.get(i); 
								noDegreeCareerNames.add("(" + counter + ") " + tempCareerCard.getName()); 
								counter++; 
								
							}
						}
						
						
						String[] names = new String[10]; 
								
						for(int i = 0; i < noDegreeCareerNames.size(); i++)
						{
							names[i] = noDegreeCareerNames.get(i); 
						}
						
						Runner.screen.updateMessage(names);
						
						int chosenCareer = intInput.nextInt(); 
						
						String careerName = names[chosenCareer-1]; 
						
						Runner.screen.updateMessage("Great! You chose a career in the " + careerName + " industry.");
						
						CareerCard careerToAdd = noDegreeCareers.get(chosenCareer-1); 
						
						Runner.players.get(PlayingGame.currentPlayer).getPlayersCards().add(careerToAdd); 

																	
							}
				
				else if (playerChoice == 2)
							{
								Runner.players.get(PlayingGame.currentPlayer).setDegree(true);
								
								Runner.screen.updateMessage("You have chosen to go to college!");
							
								Runner.screen.updateMessage("Here is a loan of $40,000, which you must pay back at the end of the game!"); 
								
								Runner.screen.updateMessage("Choose a career for after college!");
								
								
								Runner.players.get(PlayingGame.currentPlayer).setTotalLoans(40000);
								
								ArrayList<CareerCard> degreeCareers = new ArrayList<CareerCard>(); 
								
								for(int j = 0; j < AllCareers.allCareers.size(); j++)
								{ 
									if(AllCareers.allCareers.get(j).isDegree())
									{ 
										CareerCard tempCareerCardOne = AllCareers.allCareers.get(j); 
										degreeCareers.add(tempCareerCardOne); 
									}
								}
									
								
								ArrayList<String> degreeCareerNames = new ArrayList<String>(); 
								
								int counter = 1; 
								
								for(int i = 0; i < AllCareers.allCareers.size(); i++)
								{
									if(AllCareers.allCareers.get(i).isDegree())
									{ 
										CareerCard tempCareerCard = AllCareers.allCareers.get(i); 
										degreeCareerNames.add("(" + counter + ") " + tempCareerCard.getName()); 
										counter++; 
										
									}
								}
								
								
								String[] names = new String[14]; 
										
								for(int i = 0; i < degreeCareerNames.size(); i++)
								{
									names[i] = degreeCareerNames.get(i); 
								}
								
								Runner.screen.updateMessage(names);
								
								int chosenCareer = intInput.nextInt(); 
								
								String careerName = names[chosenCareer-1]; 
								
								Runner.screen.updateMessage("Great! You chose a career in the " + careerName + " industry.");
								
								CareerCard careerToAdd = degreeCareers.get(chosenCareer-1); 
								
								Runner.players.get(PlayingGame.currentPlayer).getPlayersCards().add(careerToAdd); 

							}
						}
					}

			

//		public static void playGame()
//			{
//				while (stillPlaying)
//					{
//						Runner.screen.updateMessage(playerOneName + ", press enter to spin for your turn!");
//						String playerOneSpin = userInput.nextLine();
//						int spin = Spinner.spinSpinner();
//						Runner.screen.updateMessage("You spun for a total of " + spin);
//						
//						Runner.players.get(0).setPlaceOnBoard(Runner.players.get(0).getPlaceOnBoard() + spin);
//
//						if (Runner.players.get(0).getTotalMoney() >= 500000
//								|| Runner.players.get(1).getTotalMoney() >= 500000)
//							{
//							Runner.screen.updateMessage(
//										"You win the game of life! Now you can retire and live a happy, rich life");
//								stillPlaying = false;
//							}
//
//						if (Runner.players.get(0).getPlaceOnBoard() % 2 == 0)
//							{
//
//								Runner.screen.updateMessage("You landed on a Money Tile! Now you will get paid for your job");
//								Runner.players.get(0).setTotalMoney(Runner.players.get(0).getTotalMoney() + 50000);
//
//
//							}
//
//					}

//			}

		// test



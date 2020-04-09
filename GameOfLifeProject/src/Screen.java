import java.util.ArrayList;
import java.util.Scanner;

public class Screen 
{ 
protected int screenHeight;
protected int screenWidth;
protected int boardDistanceToLeft;
protected int boardDistanceToRight;
protected int boardHeight;
protected int boardWidth;
protected int messageDistanceToTop;
protected int messageDistanceToBottom;
protected int messageDistanceToRight;
protected String title;
protected String[] screenMessage;
protected String[] theBoard;
protected String[] screen;
protected boolean setupScreen;
protected boolean setupBoard;


	public Screen(int screen_Height, int screen_Width, int board_Distance_To_Left, int board_Distance_To_Right, int board_Height, int board_Width, int message_Distance_To_Top, int message_Distance_To_Bottom, int message_Distance_To_Right, String theTitle, String welcome_Message, boolean set_Screen_Size) {
		screenHeight = screen_Height;
		screenWidth = screen_Width;
		boardDistanceToLeft = board_Distance_To_Left;
		boardDistanceToRight = board_Distance_To_Right;
		boardHeight = board_Height;
		boardWidth = board_Width;
		messageDistanceToTop = message_Distance_To_Top; 
		messageDistanceToBottom = message_Distance_To_Bottom;
		messageDistanceToRight = message_Distance_To_Right;
		title = theTitle;
		setupScreen = true;
		setupBoard = true;
		if(set_Screen_Size) {
			setScreenSize();
		}
		updateMessage(welcome_Message);;
		updateBoard();
		updateScreen();
	}
	
	public void updateBoard() {
		int [] playerPositions = getPlayerPositions();
		String[] bS = new String[40];
		for(int i = 0; i < 40; i++) {
			bS[i] = " ";
			for(int k = 0; k < playerPositions.length; k++) {
				if(playerPositions[k] == i) {
					bS[i] = "X";
				}
			}
		}
		String[] tempBoard = {
								"+---+---+---+---+---+---+---+---+---+---+---+",
								"| " + bS[30] + " | " + bS[31] + " | " + bS[32] + " | " + bS[33] + " | " + bS[34] + " | " + bS[35] + " | " + bS[36] + " | " + bS[37] + " | " + bS[38] + " | " + bS[39] + " | " + bS[0] + " |",
								"+---+---+---+---+---+---+---+---+---+---+---+",
								"| " + bS[29] + " |" + "                                   " + "| " + bS[1] + " |", 
								"+---+                                   +---+", 
								"| " + bS[28] + " |" + "                                   " + "| " + bS[2] + " |", 
								"+---+                                   +---+", 
								"| " + bS[27] + " |" + "                                   " + "| " + bS[3] + " |", 
								"+---+                                   +---+", 
								"| " + bS[26] + " |" + "                                   " + "| " + bS[4] + " |", 
								"+---+                                   +---+", 
								"| " + bS[25] + " |" + "                                   " + "| " + bS[5] + " |", 
								"+---+                                   +---+", 
								"| " + bS[24] + " |" + "                                   " + "| " + bS[6] + " |", 
								"+---+                                   +---+", 
								"| " + bS[23] + " |" + "                                   " + "| " + bS[7] + " |", 
								"+---+                                   +---+", 
								"| " + bS[22] + " |" + "                                   " + "| " + bS[8] + " |", 
								"+---+                                   +---+", 
								"| " + bS[21] + " |" + "                                   " + "| " + bS[9] + " |", 
								"+---+---+---+---+---+---+---+---+---+---+---+",
								"| " + bS[20] + " | " + bS[19] + " | " + bS[18] + " | " + bS[17] + " | " + bS[16] + " | " + bS[15] + " | " + bS[14] + " | " + bS[13] + " | " + bS[12] + " | " + bS[11] + " | " + bS[10] + " |",
								"+---+---+---+---+---+---+---+---+---+---+---+"
								
				
								};
			theBoard = tempBoard;
			
			
			
			if(!setupScreen && !setupBoard) {
				updateScreen();
				}
				setupBoard = false;
			
		}
		
		
	

	public void updateMessage(String message) {
		int messageLinesNumber = screenHeight - messageDistanceToTop - messageDistanceToBottom;
		int messageLinesWidth = screenWidth - boardDistanceToLeft - boardWidth - boardDistanceToRight - messageDistanceToRight;
		String[] tempMessageLines = new String[messageLinesNumber];
		if(messageLinesNumber * messageLinesWidth < message.length()) {
			message = message.substring(0, messageLinesNumber * messageLinesWidth);
		}
		ArrayList<String> theLines = new ArrayList<String>();
		for(int i = 0; i < message.length() / messageLinesWidth + 1; i++) {
			if(i < message.length() / messageLinesWidth) {
			theLines.add(message.substring(i * messageLinesWidth, (i + 1) * messageLinesWidth));
			}
			else {
			theLines.add(message.substring(i * messageLinesWidth));
			}
		}
		String[] messageLines = new String[theLines.size()];
		for(int i = 0; i < messageLines.length; i++) {
			messageLines[i] = theLines.get(i);
		}
		updateMessage(messageLines);
		
		
		
		
	}
	public void updateMessage(String[] messageLines) {
		int messageLinesNumber = screenHeight - messageDistanceToTop - messageDistanceToBottom;
		int messageLinesWidth = screenWidth - boardDistanceToLeft - boardWidth - boardDistanceToRight - messageDistanceToRight;
		String[] tempMessageLines = new String[messageLinesNumber];
		int bufferTop = (messageLinesNumber - messageLines.length)/2;
		int bufferBottom = (messageLinesNumber - messageLines.length)/2;
		String spacer2 = "";
		for(int i = 0; i < messageLinesWidth; i++) {
			spacer2 += " ";
		}
		if(bufferTop + bufferBottom + messageLines.length < messageLinesNumber) {
			bufferBottom ++;
		}
		int counter = 0;
		for(int j = 0; j < tempMessageLines.length; j++) {
			if(j < bufferTop || j >= messageLinesNumber - bufferBottom) {
				tempMessageLines[j] = spacer2;
			}
			else {
				
			String tempLast = messageLines[counter];
			int lastLength = tempLast.length();
			String spacer = "";
			for(int i = 0; i < (messageLinesWidth - lastLength)/2; i++) {
				spacer += " ";
			}
			tempLast = spacer + tempLast + spacer;
			if(tempLast.length() < messageLinesWidth) {
				tempLast += " ";
			}
			tempMessageLines[j] = tempLast;
			counter ++;
			}
		}
		screenMessage = tempMessageLines;
		
		if(!setupScreen && !setupBoard) {
			updateScreen();
			}
			setupScreen = false;
			pause(5.0);
	}
	
	public void updateScreen() {
		
		String[] tempScreen = new String[screenHeight];
		String boardLeft = "";
		String boardRight = "";
		String boardDistance = "";
		for(int i = 0; i < boardDistanceToLeft; i++) {
			boardLeft += " ";
		}
		for(int i = 0; i < boardDistanceToRight; i++) {
			boardRight += " ";		
		}
		for(int i = 0; i < boardWidth; i++) {
			boardDistance += " ";
		}
		
		
		int boardBufferTop = (screenHeight - boardHeight) / 2;
		int boardBufferBottom = (screenHeight - boardHeight) / 2;
		if(boardBufferTop + boardBufferBottom + boardHeight < screenHeight) {
			boardBufferBottom += 1;
		}
		
		int counter = 0;
		for(int i = 3; i < screenHeight; i++) {
			if(i < boardBufferTop || i >= screenHeight - boardBufferBottom) {
				tempScreen[i] = boardLeft + boardDistance + boardRight;
			} 
			else {
			tempScreen[i] = boardLeft + theBoard[counter] + boardLeft;
			counter++;
			}
		}
		
		int messageLinesWidth = screenWidth - boardDistanceToLeft - boardWidth - boardDistanceToRight - messageDistanceToRight;
		
		
		String messageRight = "";
		String messageDistance = "";
		for(int i = 0; i < messageDistanceToRight; i++) {
			messageRight += " ";		
		}
		for(int i = 0; i < messageLinesWidth; i++) {
			messageDistance += " ";
		}
		
		int counter1 = 0;
		for(int i = 3; i < screenHeight; i++) {
			if(i < messageDistanceToTop || i >= screenHeight - messageDistanceToBottom) {
				tempScreen[i] += messageDistance + messageRight;	
			} 
			else {
				tempScreen[i] += screenMessage[counter1] + messageRight;
				counter1++;
			}
		}
		int screenBuffer1 = (screenWidth - title.length()) / 2;	
		String screenBufferL = "";
		for(int i = 0; i < screenBuffer1; i++) {
			screenBufferL += " ";
		}
		String screenBufferR = screenBufferL;
		if(2 * screenBuffer1 + title.length() < screenWidth) {
			screenBufferR += " ";
			}
		tempScreen[2] = screenBufferL + title + screenBufferR;
		
		String spaceBuffer = "";
		for(int i = 0; i < screenWidth; i++) {
			spaceBuffer += " ";
		}
		tempScreen[1] = spaceBuffer;
		tempScreen[0] = spaceBuffer;
		screen = tempScreen;
		
		
		
		printScreen();
	}

	public void printScreen() {
		
		for(int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		
	
	}

	public int[] getPlayerPositions() {
		int[] theReturn = new int[Runner.players.size()];
		for(int i = 0; i < theReturn.length; i++) {
			theReturn[i] = Runner.players.get(i).getPlaceOnBoard();
		}
		return theReturn;
	}
	
	public void setScreenSize() {
		System.out.println("Please adjust your screen size:");
		System.out.println();
		System.out.println();
		String spaceBuffer = "";
		for(int i = 0; i < screenWidth - 2; i ++) {
			spaceBuffer += " ";
		}
		
		System.out.println("*" + spaceBuffer + "*");
		for(int i = 0; i < screenHeight - 2; i++) {
			System.out.println();
		}
		System.out.println("*" + spaceBuffer + "*");
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		
	}
	public static void pause(Double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			
			
		}
	}
	
}

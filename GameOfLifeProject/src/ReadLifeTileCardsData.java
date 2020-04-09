import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class ReadLifeTileCardsData 
{
	public static void readLifeTileCards() throws FileNotFoundException
	{ 
		Scanner file = new Scanner(new File("LifeTileCardsData"));
		
		while(file.hasNext())
		{ 
			String line = file.nextLine(); 
			String[] lifeTileArr = line.split("[+]");
			String phrase = lifeTileArr[0]; 
			String amountStr = lifeTileArr[1]; 
			int amount = Integer.parseInt(amountStr); 
			
			Runner.lifeTileCards.add(new LifeTileCard("LifeTileCard", phrase, amount)); 
			
			
		}
	}

}

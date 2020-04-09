import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class ReadHouseDeedCardsData 
{

	public static void readHouseDeedCards() throws FileNotFoundException
	{ 
		Scanner file = new Scanner(new File("houseDeedCardsData"));
		
		while(file.hasNext())
		{ 
			String line = file.nextLine(); 
			String[] houseDeedCardArr = line.split("[+]");
			String name = houseDeedCardArr[0]; 
			String costStr = houseDeedCardArr[1]; 
			String insuranceStr = houseDeedCardArr[2]; 
			int cost = Integer.parseInt(costStr); 
			int insurance = Integer.parseInt(insuranceStr); 

			Runner.houseDeedCards.add(new HouseDeedCard("HouseDeedCard", name, cost, insurance)); 
		}
	}
}

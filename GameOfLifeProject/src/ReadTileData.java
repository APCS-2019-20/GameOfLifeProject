import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTileData {
	


	public static ArrayList<String> readLines(String TileData) 
	{
		String line = null;
		ArrayList<String> theLines = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(TileData);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				theLines.add(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + TileData + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + TileData + "'");
		}
		return theLines;
	}

	public static void fillBoard()
	{ 
		ArrayList<String> myArray = readLines("TileData"); 
		
		for(int i = 0; i < myArray.size(); i++)
		{ 
			String word = myArray.get(i); 
			String[] words = word.split("[+]"); 
			String type = words[0]; 
			String indexStr = words[1]; 
			int index = Integer.parseInt(indexStr); 
			Runner.board.add(new Tile(type, index)); 
		}
		
		
		
		
		
		
	}
	
}

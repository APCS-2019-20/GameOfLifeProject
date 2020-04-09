import java.util.ArrayList;

public class AllCareers {
	 static ArrayList<CareerCard> allCareers =new ArrayList<CareerCard>();
	public static void addCareers()
	
	{
		
		allCareers.add(new CareerCard("CareerCard", "Acting",5000,80000,false));
		allCareers.add(new CareerCard("CareerCard", "Animation Art/Comics",18000,80000,true));
		allCareers.add(new CareerCard("CareerCard", "Art and Design",18000,110000,true));
		allCareers.add(new CareerCard("CareerCard", "Aviation",22000,90000,true));
		allCareers.add(new CareerCard("CareerCard", "Beauty",20000,90000,false));
		allCareers.add(new CareerCard("CareerCard", "Broadcasting",20000,80000,true));
		allCareers.add(new CareerCard("CareerCard", "Building",22000,90000,false));
		allCareers.add(new CareerCard("CareerCard", "Computer/Internet",20000,80000,false));
		allCareers.add(new CareerCard("CareerCard", "Corporate",18000,100000,true));
		allCareers.add(new CareerCard("CareerCard", "Criminal Justice",25000,120000,true));
		allCareers.add(new CareerCard("CareerCard", "Design",22000,90000,true));
		allCareers.add(new CareerCard("CareerCard", "Education",20000,90000,true));
		allCareers.add(new CareerCard("CareerCard", "Enviornment/Agriculture",25000,100000,false));
		allCareers.add(new CareerCard("CareerCard", "Health",25000,120000,true));
		allCareers.add(new CareerCard("CareerCard", "Hospitality",20000,85000,false));
		allCareers.add(new CareerCard("CareerCard", "Journalism",21000,90000,true));
		allCareers.add(new CareerCard("CareerCard", "Military",21000,100000,true));
		allCareers.add(new CareerCard("CareerCard", "Retail",21000,80000,false));
		allCareers.add(new CareerCard("CareerCard", "Music",20000,60000,false));
		allCareers.add(new CareerCard("CareerCard", "Small Buisness",19000,110000,false));
		allCareers.add(new CareerCard("CareerCard", "Science",20000,75000,true));
		allCareers.add(new CareerCard("CareerCard", "Sports",22000,12000,false));
		allCareers.add(new CareerCard("CareerCard", "Writer/Media",25000,12000,true));
		allCareers.add(new CareerCard("CareerCard", "Movie",23000,11000,true));
	}

}

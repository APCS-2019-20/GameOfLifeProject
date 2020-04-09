
public class HouseDeedCard extends Card
{
	protected String houseName; 
	protected int cost; 
	protected int insuranceCost; 
	//protected String houseStyle; 
	
	public HouseDeedCard(String cT, String h, int c, int i /*String s*/)
	{ 
		super(cT); 
		houseName = h; 
		cost = c; 
		insuranceCost = i; 
		//houseStyle = s; 
	}

//	public String getHouseStyle() {
//		return houseStyle;
//	}
//
//	public void setHouseStyle(String houseStyle) {
//		this.houseStyle = houseStyle;
//	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(int insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

}

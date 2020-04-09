public class CareerCard extends Card
{
	
	private String name;
	private int salary;
	private int promoSalary;
	private boolean degree;
	
	public CareerCard(String t, String n,int s, int pS,boolean d) 
	{
		super(t); 
		name=n;
		salary=s;
		promoSalary=pS;
		degree=d;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPromoSalary() {
		return promoSalary;
	}
	public void setPromoSalary(int promoSalary) {
		this.promoSalary = promoSalary;
	}
	public boolean isDegree() {
		return degree;
	}
	public void setDegree(boolean degree) {
		this.degree = degree;
	}

}

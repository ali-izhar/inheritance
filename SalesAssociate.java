package deptStore;

/**
 * A class to create a SalesAssociate working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public class SalesAssociate extends Employee {

	private String department;
	private double revenue;
	private int sales;
	private double productivity = calculateProductivity();
	private final int DAILY_SALES_TARGET = 3;
	private double DAILY_REVENUE_TARGET = 1000;
	
	/**
	 * Create a sales person with the given details.
	 * @param name the name of the sales person.
	 * @param employeeID the ID of the sales person.
	 * @param hourlyWage the hourly wage of the sales person.
	 * @param department the department of the sales person.
	 */
	public SalesAssociate(String name, int employeeID, double hourlyWage, String department) {
		super(name, employeeID, hourlyWage);
		this.department = department;
	}

	/**
	 * Make a sale and add that amount of money to the revenue.
	 * @param randomAmount
	 */
	public void makeSale(double randomAmount) {
		sales++;
		this.revenue += randomAmount;
	}
	
	/**
	 * Calculate the sale person's productivity.
	 */
	public double calculateProductivity() {
		double sale_metric = this.sales/DAILY_SALES_TARGET;
		double revenue_metric = this.revenue/DAILY_REVENUE_TARGET;
		return (sale_metric + revenue_metric)/2.0;
	}
	
	/**
	 * Print the sale person's object with added details from the parent class.
	 */
	public String toString() {
		System.out.println(super.toString());
		return "Department: " + this.department + "\nNumber of sales: " + this.sales +
			   "\nAmount of Revenue: %.2f".formatted(this.revenue);
	}

}

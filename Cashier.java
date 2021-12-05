package deptStore;

/**
 * A class to create a Cashier working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public class Cashier extends Employee {
	
	private double drawerAmount;
	private double productivity = calculateProductivity();
	private int transactions = 0;
	private final int DAILY_TRANSACTIONS_LIMIT = 20;
	
	/**
	 * Create a cashier with the given details.
	 * @param name the name of the cashier.
	 * @param employeeID the ID of the cashier.
	 * @param hourlyWage the hourly wage of the cashier.
	 * @param drawerAmount the drawer amount.
	 */
	public Cashier(String name, int employeeID, double hourlyWage, double drawerAmount) {
		super(name, employeeID, hourlyWage);
		this.drawerAmount = drawerAmount;
	}

	/**
	 * The amount of money from sales that rings up.
	 * @param d the amount of money.
	 */
	public void ringup(double d) {
		transactions++;
		this.drawerAmount += d;
	}

	/**
	 * The amount of money that the cashier completes return for.
	 * @param d the amount of money.
	 */
	public void completeReturn(double d) {
		transactions++;
		drawerAmount -= d;
	}
	
	/**
	 * Calculate the cashier's productivity.
	 */
	public double calculateProductivity() {
		return (double) transactions/DAILY_TRANSACTIONS_LIMIT;
	}
	
	/**
	 * Print the cashier object with added details from the parent class.
	 */
	public String toString() {
		System.out.println(super.toString());
		return "Drawer Amount: %.2f".formatted(this.drawerAmount);
	}
}


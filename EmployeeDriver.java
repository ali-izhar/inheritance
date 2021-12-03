package deptStore;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A Driver to display Employees created
 * 
 * @author OOPDA Instructor
 *
 */
public class EmployeeDriver {
	private static HashSet<Employee> employees = new HashSet<>();
	
	public static void main(String[] args) {
		makeEmployees();
		employees.forEach(e -> simulateSalesDay(e));
		displayEmployees();
	}
	


	/**
	 * This method creates an instance of all three types of 
	 * Employees and adds them to a HashSet
	 */
	private static void makeEmployees() {
		Cashier cashier1 = new Cashier("Franny Wilkins", 100, 10.75, 200);
		Cashier cashier2 = new Cashier("Barbara Smith", 76, 11.00, 100);
		SalesAssociate sa = new SalesAssociate("Will Martin", 166, 11.50, "Shoes");
			
		employees.add(cashier1);
		employees.add(cashier2);
		employees.add(sa);	
	}
	
	private static void simulateSalesDay(Employee emp) {
		if (emp instanceof Cashier) {
			makeTransactions((Cashier) emp);
		}
		else if (emp instanceof SalesAssociate) {
			makeSales((SalesAssociate) emp);
		}
	}
	
	private static void makeTransactions(Cashier emp) {
		// Set parameters for the simulation
		final int MIN_SALES = 4;
		final int MAX_SALES = 30;
		final int MIN_RETURNS = 0;
		final int MAX_RETURNS = 3;

		int randomSales = ThreadLocalRandom.current().nextInt(MIN_SALES, MAX_SALES + 1);
		int randomReturns = ThreadLocalRandom.current().nextInt(MIN_RETURNS, MAX_RETURNS + 1);
		double randomAmount;
		
		// Simulate the sales for the day 
		for (int i = 0; i < randomSales; i++) {
			randomAmount = 	(double) ThreadLocalRandom.current().nextInt(1000, 25000) / 100;
			emp.ringup(randomAmount);
			System.out.println(emp.getName() + " rang up $" + randomAmount);
		}
		
		// Simulate the returns for the day 
		for (int i = 0; i < randomReturns; i++) {
			randomAmount = 	(double) ThreadLocalRandom.current().nextInt(1000, 25000) / 100;
			emp.completeReturn(randomAmount);
			System.out.println(emp.getName() + " processed return of $" + randomAmount);
		}
	}

	private static void makeSales(SalesAssociate emp) {
		// Set parameters for the simulation
		final int MIN_SALES = 0;
		final int MAX_SALES = 5;
		
		int randomSales = ThreadLocalRandom.current().nextInt(MIN_SALES, MAX_SALES + 1);
		double randomAmount;
		
		for (int i = 0; i < randomSales; i++) {
			randomAmount = 	(double) ThreadLocalRandom.current().nextInt(1000, 25000) / 100;
			emp.makeSale(randomAmount);
			System.out.println(emp.getName() + " made sale of $ " + randomAmount);
		}
	}

	/**
	 * This method loops through the employees
	 * and displays ALL information about each one
	 */
	private static void displayEmployees() {
		System.out.println("\nHere are the employees:");
		for (Employee employee : employees) {
			System.out.println();
			System.out.println(employee);
		}
	}

}
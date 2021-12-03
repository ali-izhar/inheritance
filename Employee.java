package deptStore;

/**
 * A class to create an Employee working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public abstract class Employee {
	protected String name;
	protected int employeeID;
	protected double hourlyWage;
	
	/**
	 * Create an employee with a give name, ID, and hourly wage.
	 */
	public Employee(String name, int employeeID, double hourlyWage) {
		this.name = name;
		this.employeeID = employeeID;
		this.hourlyWage = hourlyWage;
	}
	
	/**
	 * Get the name of the employee.
	 * @return employee's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the ID of the employee.
	 * @return employee's ID.
	 */
	public int getID() {
		return this.employeeID;
	}
	
	/**
	 * Get the hourly wage of the employee.
	 * @return employee's hourly wage.
	 */
	public double getHourlyWage() {
		return this.hourlyWage;
	}
	
	/**
	 * Abstract: calculate the employee's productivity.
	 */
	abstract double calculateProductivity();
	
	/**
	 * Print an employee object.
	 */
	public String toString() {
		return this.getClass().getSimpleName() + "\nName: " + this.name + "\nID: " + this.employeeID + "\nHourly Wage: " + this.hourlyWage
											   + "\nProductivity: " + this.calculateProductivity();
	}

}
//---------------------------------------------------------
//Assignment 4 
//Written by: Surur Khan & Thomas Acuna
//For COMP 248 Section 5745 – Fall 2022
//---------------------------------------------------------

package asmt_4;

public class Expense {
	/*
	 * Tracks expenses for budget program.
	 * 
	 */
	
	// attributes of Expense class declaration
	int dueDay;
	double dueAmount;
	int dueMonth;
	String expenseType;
	String businessName;
	
	// Default constructor 
	public Expense() {
		dueDay = 0;
		dueAmount = 0;
		dueMonth = 0;
		expenseType = "";
		businessName = "";
	}
	
	// Constructor to initialize attributes. If invalid data is entered, 0 is defaulted.
	public Expense(String type, double amt, String bus, int day, int month) {
		this.dueDay = (day >= 1 && day <= 31) ? day: 0;
		this.dueMonth = (month >=1 && month <= 12) ? month: 0;
		this.dueAmount = amt;
		this.expenseType = type;
		this.businessName = bus;
	}
	
	// Copy constructor
	public Expense(Expense exp) {
		this.dueDay = exp.dueDay;
		this.dueMonth = exp.dueMonth;
		this.dueAmount = exp.dueAmount;
		this.expenseType = exp.expenseType;
		this.businessName = exp.businessName;
	}
	
	// Getter for all attributes
	
	public int getDay() {
		return dueDay;
	}
	
	public int getMonth() {
		return dueMonth;
	}
	
	public double getAmount() {
		return dueAmount;
	}
	
	public String getExpense() {
		return expenseType;
	}
	
	public String getBusiness() {
		return businessName;
	}
	
	// Setter for Month. If invalid data is entered, 0 is defaulted.
	public void setMonth(int newMonth) {
		this.dueMonth = (newMonth >=1 && newMonth <= 12) ? newMonth: 0;
	}
	
	// Setter for Day. If invalid data is entered, 0 is defaulted.
	public void setDay(int newDay) {
		this.dueDay = (newDay >=1 && newDay <= 12) ? newDay: 0;
	}
	
	// New String method to display expense, business, and due date
	@Override public String toString() {
		String dueDayString;
		String dueMonthString;
		
		
		// Control formatting for Day to include 0 at beginning if less than 10
		if (dueDay < 10) {
			dueDayString = "0" + dueDay;
		}
		else {
			dueDayString = Integer.toString(dueDay);
		}
		
		// Control formatting for Month to include 0 at beginning if less than 10
		if (dueMonth < 10) {
			dueMonthString = "0" + dueMonth;
		}
		else {
			dueMonthString = Integer.toString(dueMonth);
		}
		
		return (expenseType + " - " + dueAmount + " - " + businessName + " - " + dueDayString + "/" + dueMonthString + ".");
	}
	
	// New equals method that returns true if the two objects of type Expense are identical, false otherwise
	public boolean equals(Expense objOne) {
		return objOne == this;
	}

}
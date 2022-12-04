package asmt_4;

import java.util.Scanner;
import java.util.Arrays;

//---------------------------------------------------------
//Assignment 4 
//Written by: Surur Khan & Thomas Acuna
//For COMP 248 Section 5745 – Fall 2022
//---------------------------------------------------------

public class HouseholdBudget {
		/*
		 * Contains fund and expenses as an objet of type Fund and an Array Expenses of objects of type Expense
		 * 
		 */
	
		// instantiating instances of fund, expense and scanner classes
		private Fund fundObject = new Fund();
		private Expense[] expenseObject;
		Scanner input = new Scanner(System.in);
		
		// default constructor
		public HouseholdBudget() {
			fundObject.setOnes(0);
			fundObject.setTwos(0);
			fundObject.setFives(0);
			fundObject.setTens(0);
			fundObject.setTwenties(0);
			for (int i = 0; i < expenseObject.length; i++) {
				expenseObject[i].setDay(0);
				expenseObject[i].setMonth(0);
			}
		}
		
		// householdBudget object builder
		public HouseholdBudget(Fund fund, Expense[] expArray) {
			fundObject = fund;
			expenseObject = expArray;
		}
		
		// getter for Fund
		public Fund getFund() {
			return fundObject;
		}
		
		// return true if the total value of the fund of two Householdbudget objects are equal and false otherwise
		public boolean compareTotalFunds(HouseholdBudget objOne) {
			return this.fundObject.fundTotal() == objOne.fundObject.fundTotal();
		}
		
		// return true if the breakdown of funds for two Householdbudget objects are equal and false otherwise
		public boolean compareFundBreakdown(HouseholdBudget object) {
			return object.fundObject.equals(this.getFund());
		}
		
		// return total money that a household has
		public double HouseholdBudgetFundTotal() {
			return this.fundObject.fundTotal();
		}
		
		// return the number of expenses a household has
		public int numExpenses() {
			return this.expenseObject.length; 
		}
		
		// add a new expense to a household
		public int addExpense() {
			Scanner input = new Scanner(System.in);
			Expense[] tempExpense = new Expense[expenseObject.length + 1];
			
			String type = "";
			double amt = 0.0;
			String bus = "";
			int day = 0;
			int mth = 0;
			
			System.out.println("Please enter the following information so that we may complete the expense--");
			
			System.out.print(" --> Type of expense (Bill, Purchase,...): ");
			type = input.nextLine();
			
			System.out.print(" --> Amount of the expense: ");
			amt = input.nextDouble();
			String junk1 = input.nextLine();
			
			System.out.print(" --> Business name: ");
			bus = input.nextLine();
			
			System.out.print(" --> Payment due day and month (Separated by a space): ");
			day = input.nextInt();
			mth = input.nextInt();
			
			String junk2 = input.nextLine();
			
			Expense newExpense = new Expense(type, amt, bus, day , mth);
			
			// algorithm to add a new expense to the object
			for (int i = 0; i < expenseObject.length; i++) {
				tempExpense[i] = expenseObject[i];
			}
			tempExpense[tempExpense.length - 1] = newExpense;
			expenseObject = tempExpense;
			
			System.out.println("You now have " + expenseObject.length + " expense(s)");
			return expenseObject.length;
		}
		
		// remove an expense from a householdBudget
		public boolean removeExpense(int idx) {
				Expense[] tempExpense = new Expense[expenseObject.length - 1];
				// algorithm to remove an expense from an object
				int count = 0;
				for (int i = 0; i < expenseObject.length; i++) {
					if (i != idx) {
						tempExpense[count] = expenseObject[i];
						count++;
					}
				}
				expenseObject = tempExpense;
				return true;
			}
		
		// update the duedate for a household expense
		public void updateDue(int newDay, int newMonth, int idx) {
			this.expenseObject[idx].setMonth(newMonth);
			this.expenseObject[idx].setDay(newDay);
		}
		
		// increase the funds of a household
		public double addHouseHoldFunds(int one, int two, int five, int ten, int twenty) {
			this.fundObject.setOnes(this.fundObject.getOnes() + one);
			this.fundObject.setTwos(this.fundObject.getTwos() + two);
			this.fundObject.setFives(this.fundObject.getFives() + five);
			this.fundObject.setTens(this.fundObject.getTens() + ten);
			this.fundObject.setTwenties(this.fundObject.getTwenties() + twenty);
			return this.fundObject.fundTotal();
		}
		
		// two households are equal if they have the same total funds and same number of expenses
		public boolean equals(HouseholdBudget object) {
			return this.compareTotalFunds(object) && this.expenseObject.length == object.expenseObject.length;
		}
		
		// new toString method relaying funds and expenses
		@Override public String toString() {
			String funds = this.fundObject.toString();
			String outExp = "";
			
				if (this.numExpenses() == 0) {
					outExp = "No expenses" + "\n";
				}
				else {
					for (int i = 0; i < this.expenseObject.length; i++) {
						outExp = outExp + this.expenseObject[i].toString() + "\n";
					}
				}
		  return ("Funds: " + funds + "\n" + "Expenses: " + "\n" + outExp + "\n");
		}

		// breakdown of denominations
		public String fundBreakdown() {
			return this.fundObject.toString();
		}
}
		



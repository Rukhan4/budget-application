//---------------------------------------------------------
//Assignment 4 
//Written by: Surur Khan & Thomas Acuna
//For COMP 248 Section 5745 – Fall 2022
//---------------------------------------------------------

package asmt_4;

import java.util.Scanner;

public class BudgetDemo {

	public static void main(String[] args) {
		/*
		 * Driver code that utilizes the Fund, Expense and HouseholdBudget classes to provide different
		 * features to the user
		 * 
		 */
		
		// variable declaration
		
		Scanner input = new Scanner(System.in);
		HouseholdBudget[] houses = new HouseholdBudget[5];
		
		// HouseholdBudget 0
		Fund f0 = new Fund(0,1,0,2,1); // 42
		Expense e0 = new Expense("Purchase", 70.5, "eBay", 25, 11);
		Expense e00 = new Expense("Bill", 150.75, "GameStop", 2, 12);
		Expense[] expense0 = {e0, e00};
		HouseholdBudget hb0 = new HouseholdBudget(f0, expense0);
		
		// HouseholdBudget 1
		Fund f1 = new Fund(0,1,0,2,1); // 42
		Expense e1 = new Expense("Purchase", 85.5, "eBay", 25, 11);
		Expense e11 = new Expense("Bill", 10, "Walmart", 17, 11);
		Expense[] expense1 = {e1,e11};
		HouseholdBudget hb1 = new HouseholdBudget(f1,expense1);
		
		// HouseholdBudget 2
		Fund f2 = new Fund(2,0,2,1,1); // 42
		Expense e2 = new Expense("Purchase", 80.25, "VGA", 4, 12);
		Expense e22 = new Expense("Purchase", 10.50, "Vogue", 18,12);
		Expense e222 = new Expense("Bill", 95.5, "Verizon", 5, 1);
		Expense[] expense2 = {e2,e22,e222};
		HouseholdBudget hb2 = new HouseholdBudget(f2,expense2);
		
		// HouseholdBudget 3
		Fund f3 = new Fund(5,0,5,1,5); // 140
		Expense[] expense3 = {};
		HouseholdBudget hb3 = new HouseholdBudget(f3,expense3);
		
		// HouseholdBudget 4
		Fund f4 = new Fund(5,0,5,1,5); // 140
		Expense[] expense4 = {};
		HouseholdBudget hb4 = new HouseholdBudget(f4, expense4);
		
		// occupying houses with hard coded HouseholdBudget objects
		houses[0] = hb0;
		houses[1] = hb1;
		houses[2] = hb2;
		houses[3] = hb3;
		houses[4] = hb4;
		
		// Opening Statement
		String open = "Welcome to Comp-248 Geek's Household_budget2022 Application";
		System.out.println("*".repeat(open.length()) + "\n");
		System.out.println(open + "\n");
		System.out.println("*".repeat(open.length()));
		
		System.out.println();
		
		// keep displaying menu to user 
		boolean on = true;
		while(on) {
		

		// Options Menu
		System.out.println("What would you like to do?");
		System.out.println("1.	See the possessions of all householdBudgets");
		System.out.println("2.	See the possessions of one householdBudget");
		System.out.println("3.	List householdBudgets with same total amount of fund");
		System.out.println("4.	List householdBudgets with same fund denomination(s)");
		System.out.println("5.	List householdBudgets with same total amount of fund and same number of expenses");
		System.out.println("6.	Add an expense to an existing householdBudget");
		System.out.println("7.	Remove an existing expense from a householdBudget");
		System.out.println("8.	Update the payment due date of an existing expense");
		System.out.println("9.	Add fund to a householdBudget");
		System.out.println("0.  	To quit");
		System.out.println();
		System.out.print("Please enter your choice and press <Enter>: ");
		
		int choice = input.nextInt();
		
		// handle invalid choice
		if (choice < 0 || choice > 10) {
			System.out.println("Sorry that is not a valid choice. Try again." + "\n");
			continue;
		}
		
		// open switch statement to handle menu choices
		switch(choice) {
		case 0: // exit program
			System.out.print("Thank you for using COMP248 Geek's HouseholdBudget application");
			on = false; // terminate loop
			break;
			
			
		case 1: // breakdown of all budgets
			System.out.println("Content of each HouseholdBudget:");
			System.out.println("-----------------------");
			for (int i = 0; i < houses.length; i++) {
				System.out.println("HouseholdBudget: #" + i);
				System.out.println(houses[i]);
			}
			break;
		
			
		case 2: // display content of one budget
			System.out.println("Which HouseholdBudget do you want to see the possessions of? (Enter number 0 to 4): ");
			int houseChoice = input.nextInt();
			// ensure valid household is chosen
			while (houseChoice < 0 || houseChoice > 4) {
				System.out.println("Sorry but there is no householdBudget number: " + houseChoice);
				System.out.println("Try again: (Enter number 0 to 4): ");
				houseChoice = input.nextInt();
			}
			System.out.println(houses[houseChoice]);
			continue;
			
			
		case 3: // list budgets with same total amount of fund
			System.out.println("List of householdBudgets with same total fund:");
			for (int i = 0; i < houses.length; i++) {
				for (int j = i; j < houses.length; j++) {
					if (i == j) {
						continue;
					}
					if (houses[i].compareTotalFunds(houses[j])) {
						System.out.println("HouseholdBudgets " + i + " and " + j + " both have " + houses[i].HouseholdBudgetFundTotal());
					}
						
				}
			}
			System.out.println();
			continue;
			
			
		case 4: // List budgets with the same fund denomination(s)
			System.out.println("List of HouseholdBudgets with same Fund:");
			for (int i = 0; i < houses.length; i++) {
				for (int j = i; j < houses.length; j++) {
					if (i == j) {
						continue;
					}
					if (houses[i].compareFundBreakdown(houses[j])) {
						System.out.println("HouseholdBudgets " + i + " and " + j + " both have " + houses[i].fundBreakdown());
					}
						
				}
			}
			System.out.println();
			continue;
			
			
		case 5: // List budgets with same total amount of fund and same number of expenses
			System.out.println("List of HouseholdBudgets with the same amount of money and same number of expenses:");
			for (int i = 0; i < houses.length; i++) {
				for (int j = i; j < houses.length; j++) {
					if (i == j) {
						continue;
					}
					if (houses[i].equals(houses[j])) {
						System.out.println("HouseholdBudgets " + i + " and " + j);
					}
						
				}
			}
			System.out.println();
			
			
		case 6: // add expense to an existing household
			System.out.println("Which HouseholdBudget do you want to add an Expense to? (Enter number 0 to 4): ");
			int addChoice = input.nextInt();
			// ensure valid household is chosen
			while (addChoice < 0 || addChoice > 4) {
				System.out.println("Sorry but there is no householdBudget number: " + addChoice);
				System.out.println("Try again: (Enter number 0 to 4): ");
				addChoice = input.nextInt();
			}
			System.out.println(houses[addChoice].addExpense());
			continue;
			
			
		case 7: // remove existing expense from a household
			System.out.print("Which HouseholdBudget do you want to remove an expense from? (Enter number 0 to 4): ");
			int remChoice = input.nextInt();
			// ensure valid household is chosen
			while (remChoice < 0 || remChoice > 4) {
				System.out.println("Sorry but there is no householdBudget number: " + remChoice);
				System.out.println("Try again: (Enter number 0 to 4): ");
				addChoice = input.nextInt();
			}
			if (houses[remChoice].numExpenses() != 0) {
				System.out.print("(Enter number 0 to " + (houses[remChoice].numExpenses() - 1) + "): ");
				int remExpense = input.nextInt();
				if (houses[remChoice].removeExpense(remExpense) == true) {
				System.out.println("Expense was removed successfully");
				}
			}
			else {
				System.out.println("Sorry, that householdBudget has no expenses");
			}
			continue;
			
			
		case 8: // update Due date and Month of an Expense for a particular household
			System.out.print("Which HouseholdBudget do you want to update an expense from? (Enter number 0 to 4): ");
			int whichHouseHold = input.nextInt();
			// ensure valid household is chosen
			while (whichHouseHold < 0 || whichHouseHold > 4) {
				System.out.println("Sorry but there is no householdBudget number: " + whichHouseHold);
				System.out.println("Try again: (Enter number 0 to 4): ");
				whichHouseHold = input.nextInt();
			}
			System.out.println("Which expense do you want to update? (Enter number 0 to " + (houses[whichHouseHold].numExpenses()-1) + ")");
			int whichExpense = input.nextInt();
			while (whichExpense > houses[whichHouseHold].numExpenses() || whichExpense < 0) {
				System.out.println("Sorry, there is no expense number " + whichExpense);
				System.out.println(" --> Try again:" + "\n" + "(Enter number 0 to " + (houses[whichHouseHold].numExpenses()-1) + ")");
				whichExpense = input.nextInt();
			}
			System.out.print(" --> Enter new payment due day number and month (separate by a space): ");
			int dueDay = input.nextInt();
			int dueMonth = input.nextInt();
			houses[whichHouseHold].updateDue(dueDay, dueMonth, whichExpense);
			System.out.println("Due Day and Month updated.");
			continue;
			
			
		case 9: // add new Funds to a particular household
			System.out.print("Which HouseholdBudget do you want to add Fund to? (Enter number 0 to 4): ");
			int chooser = input.nextInt();
			// ensure valid household is chosen
			while (chooser < 0 || chooser > 4) {
				System.out.println("Sorry but there is no householdBudget number: " + chooser);
				System.out.println("Try again: (Enter number 0 to 4): ");
				whichHouseHold = input.nextInt();
			}
			System.out.println("How many loonies, toonies, $5, $10 and $20 bill do you want to add?");
			System.out.println("Enter 5 numbers separated by a space: ");
			int tempOne = input.nextInt();
			int tempTwo = input.nextInt();
			int tempFive = input.nextInt();
			int tempTen = input.nextInt();
			int tempTwenty = input.nextInt();
			// updates householdbudget object with new fund data
			double newTotal = houses[chooser].addHouseHoldFunds(tempOne, tempTwo, tempFive, tempTen, tempTwenty);
			System.out.println("You now have: " + newTotal);
			continue;
		}	
		
	}
		input.close();

}
}


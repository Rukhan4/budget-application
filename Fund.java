//---------------------------------------------------------
//Assignment 4 
//Written by: Surur Khan & Thomas Acuna
//For COMP 248 Section 5745 – Fall 2022
//---------------------------------------------------------

package asmt_4;

public class Fund {
	/*
	 * Depicts cash flow for budget application. 
	 */
	
	// variable declaration for cash values
	static int one = 1;
	static int two = 2; 
	static int five = 5;
	static int ten = 10;
	static int twenty = 20;
	
	// variable declaration for counting the amount of each type of fund present
	int countOnes;
	int countTwos;
	int countFives;
	int countTens;
	int countTwenties;
	
	// Default constructor to initialize variables
	public Fund() {
		countOnes = 0;
		countTwos = 0;
		countFives = 0;
		countTens = 0;
		countTwenties = 0;
	}
	
	// Constructor to set number of each Fund type a particular household owns
	public Fund(int c1, int c2, int c5, int c10, int c20) {
		countOnes = c1;
		countTwos = c2;
		countFives = c5;
		countTens = c10;
		countTwenties = c20;
	}
	
	// fund copy constructor 
	public Fund(Fund fund) {
		this.countOnes = fund.countOnes;
		this.countTwos = fund.countTwos;
		this.countFives = fund.countFives;
		this.countTens = fund.countTens;
		this.countTwenties = fund.countTwenties;
	}
	
	// Getters for different attributes
	
	public int getOnes() {
		return countOnes;
	}
	
	public int getTwos() {
		return countTwos;
	}
	
	public int getFives() {
		return countFives;
	}
	
	public int getTens() {
		return countTens;
	}
	
	public int getTwenties() {
		return countTwenties;
	}
	
	// Setters for different attributes
	
	  public void setOnes(int newOnes) {
		    this.countOnes = newOnes;
	  }
	  
	  public void setTwos(int newTwos) {
		    this.countTwos = newTwos;
	  }
	  
	  public void setFives(int newFives) {
		    this.countFives = newFives;
	  }
	  
	  public void setTens(int newTens) {
		    this.countTens = newTens;
	  }
	  
	  public void setTwenties(int newTwenties) {
		    this.countTwenties = newTwenties;
	  }
	
	// function to increase the number of each Fund type by the indicated number
	public void addFund(int incOne, int incTwo, int incFive, int incTen, int incTwenty) {
		setOnes(this.countOnes + incOne);
		setTwos(this.countTwos + incTwo);
		setFives(this.countFives + incFive);
		setTens(this.countTens + incTen);
		setTwenties(this.countTwenties + incTwenty);
	}
	
	// function that returns an integer indicating total value of funds possessed by household
	public double fundTotal() {
		return (countOnes * one) + (countTwos * two) + (countFives * five) + (countTens * ten) + (countTwenties * twenty);
	}
	
	// Recreate toString method for displaying funds
	@Override public String toString() {
		return ("(" + countOnes + " x " + "$1) " + "(" + countTwos + " x " + "$2) " + "(" + countFives + " x " + "$5) " + "(" + countTens + " x " + "$10) " + "(" + countTwenties + " x " + "$20) ");
	}
	
	// Returns true if two objects of type Fund have the same breakdown of cash type, false otherwise
	public boolean equals(Fund objOne) {
		return objOne.countOnes == this.countOnes &&
				objOne.countTwos == this.countTwos &&
				objOne.countFives == this.countFives &&
				objOne.countTens == this.countTens &&
				objOne.countTwenties == this.countTwenties;
	}
}
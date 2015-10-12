/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
	private int month, day, year;
	
  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  if (isValidDate(month,day,year)) {
	  this.month = month;
	  this.day = day;
	  this.year = year;
	  } else {
		  System.exit(0);
	  }
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
		String[] parts = s.split("/");
		if (parts.length != 3){
			System.exit(0);
		}else {
		int smonth = Integer.parseInt(parts[0]);
		int sday = Integer.parseInt(parts[1]);
		int syear = Integer.parseInt(parts[2]);
		if (sday < 1 || sday > 99){
			System.exit(0);
		} else if (smonth < 1 || smonth > 99) {
			System.exit(0);
		} else if (syear < 1 || syear > 9999) {
			System.exit(0);
		} else {
			this.day = sday;
			this.month = smonth;
			this.year = syear;
		}
		}
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
	  if (year % 400 == 0) {
		  return true;
	  }
	  else if (year % 100 == 0) {
				return false;
			} else if (year % 4 == 0){
					return true;
				}
				else {return false;
				
				}
	  }
                        // replace this line with your solution
  

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
			if (month == 2 && isLeapYear(year)) {
				return 29;
			} else if (month == 2){
				return 28;
			} else if (month < 8 && month % 2 != 0){
				return 31;
			} else if (month > 7 && month % 2 == 0){
				return 31;
			} else {
				return 30;
			}
	
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
		
		if (year < 1){
			return false;
		} else if (month < 1 || month > 12) {
			return false;
		} else if (day < 1 || day > daysInMonth(month,year)){
			return false;
		} else {
			return true;
		}
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    return (month + "/" + day + "/" + year);
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    if (this.year < d.year){
			return true;
	} else  if (d.year == this.year){
				if (this.month < d.month) {
					return true;
				} else if (d.month == this.month) {
							if (this.day < d.day) {
								return true;
							} else {
								return false;
							}
				} 		else {
							return false;
				}
				} else {
					return false;
				}
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    if (isBefore(d)) {
		return false;
	} else if (this.year == d.year && this.month == d.month && this.day == d.day){
		return false;
	} else {
		return true;
	}
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    	int days = 0;
		for(int i=1;i<this.month;i++){
			days = days + daysInMonth(i,this.year);
		}
		days = days + this.day;
		return days;
		
  }	

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    if (this.year == d.year){
			return this.dayInYear()-d.dayInYear();
		} else if(this.year > d.year){
			int diff = this.year - d.year - 1;
			
			int daysbetween;
			if (isLeapYear(d.year)){
				daysbetween = 366 - d.dayInYear();
                
			} else {
				daysbetween = 365 - d.dayInYear();
                
			}
            
			int i = 0;
			while(i<diff) {
				if (isLeapYear(i)){
					daysbetween = daysbetween + 366;
					i++;
				} else {
					daysbetween = daysbetween + 365;
					i++;
				}
			}
			daysbetween = daysbetween + this.dayInYear();
			return daysbetween;
		} else {
			return -d.difference(this);
		}
	
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);
	

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");
	Date d6 = new Date("2/29/2004");
    /* I recommend you write code to test the isLeapYear function! */
	System.out.println("1969 should be a " + isLeapYear(1969) + " Leap Year");
	System.out.println("2004 should be a " + isLeapYear(2004) + " Leap Year");
	System.out.println("2300 should be a " + isLeapYear(2300) + " Leap Year");
	
	System.out.println("No. Days in January: " + daysInMonth(1,1986));
	System.out.println("No. Days in February: " + daysInMonth(2,2004));
	System.out.println("No. Days in September: " + daysInMonth(9,1999));
	System.out.println("No. Days in August: " + daysInMonth(8,4004));
	
    System.out.println("Is date 12/32/2015 valid? : " + isValidDate(12,32,2015));
	System.out.println("Is date 02/29/2012 valid? : " + isValidDate(02,29,2012));
	System.out.println("Is date 12/31/-1000 valid? : " + isValidDate(12,31,-1000));
	
	System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

	
    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));
	System.out.println("");
	
	System.out.println("\nTesting Day in Year.");
	System.out.println("\n");
	System.out.println("Day on 2/29/2015 should be 60:" + d6.dayInYear());
    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
package model;

import java.util.ArrayList;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 5, 2023  
*/

public class ScheduleGenerator {
	
	private String bookTitle;
	private int bookPages;
	private int bookDays;
	private double bookPagesPerDay;
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<Double> pagesPer = new ArrayList<Double>();
	
	/**
	 * constructor for the ScheduleGenerator class 
	 * @param title
	 * @param pages
	 * @param days
	 */
	public ScheduleGenerator(String title, String pages, String days) {
		this.bookTitle = title;
		this.bookPages = Integer.parseInt(pages);
		this.bookDays = Integer.parseInt(days);
		this.calculatePagesPerDay(bookPages, bookDays);
		this.addTitle(this.bookTitle);
		this.addPagesPer(this.bookPagesPerDay);
	}

	/**
	 * retrieves the current value of the private bookTitle variable
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * retrieves the current value of the private bookPages variable
	 * @return the bookPages
	 */
	public int getBookPages() {
		return bookPages;
	}

	/**
	 * retrieves the current value of the private bookDays variable
	 * @return the bookDays
	 */
	public int getBookDays() {
		return bookDays;
	}
	
	/**
	 * retrieves the current value of the private bookPagesPerDay variable
	 * @return the bookPagesPerDay
	 */
	public double getPagesPerDay() {
		return this.bookPagesPerDay;
	}
	
	/**
	 * adds the specified book title to the titles array list 
	 * @param title the book title being added to the titles array list
	 */
	public void addTitle(String title) {
		ScheduleGenerator.titles.add(title);
	}
	
	/**
	 * adds the given pages per day to the pagesPer array list
	 * @param pagesPerDay the double resulting from the calculatePagesPerDay() 
	 */
	public void addPagesPer(double pagesPerDay) {
		ScheduleGenerator.pagesPer.add(pagesPerDay);
	}
	
	/**
	 * returns the title found at the given index of the titles array list
	 * @param index the integer value of the location in the title array list to be returned
	 * @return the found title at the given position
	 */
	public String retrieveTitle(int index) {
		String foundTitle = ScheduleGenerator.titles.get(index);
		return foundTitle;
	}
	
	/**
	 * returns the double number found at the given index of the pagesPer array list
	 * @param index the integer value of the location in the pagesPer array list to be returned
	 * @return the found number at the given position
	 */
	public double retrievePagesPerDay(int index) {
		double foundPagesPer = ScheduleGenerator.pagesPer.get(index);
		return foundPagesPer;
	}
	
	/**
	 * calculates the number of pages which must be read each day to finish a book and assigns the value to a variable
	 * @param pages the number of pages contained in the book
	 * @param days the number of days in which the book must be read
	 */
	public void calculatePagesPerDay(Integer pages, Integer days) {
		double pagesPerDay = (double)pages/ (double)days;
		this.bookPagesPerDay = pagesPerDay;
	}

}
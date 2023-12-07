package model;

import java.text.DecimalFormat;
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
	private String bookPagesPerDay;
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<String> pagesPer = new ArrayList<String>();
	private static StringBuilder previewAssembler = new StringBuilder();
	private DecimalFormat twoPositions = new DecimalFormat(".00");
	private static int objectsCreated = 0;
	
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
		addTitle(this.bookTitle);
		addPagesPer(this.bookPagesPerDay);
		ScheduleGenerator.objectsCreated++;
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
	public String getPagesPerDay() {
		return this.bookPagesPerDay;
	}
	
	/**
	 * retrieves the current value of the private static objectsCreated variable 
	 * @return the number of objects created 
	 */
	public static int getObjectsCreated() {
		return ScheduleGenerator.objectsCreated;
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
	 * @param pagesPerDay the String resulting from the calculatePagesPerDay() 
	 */
	public void addPagesPer(String pagesPerDay) {
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
	 * returns the formatted String value found at the given index of the pagesPer array list
	 * @param index the integer value of the location in the pagesPer array list to be returned
	 * @return the found number at the given position
	 */
	public String retrievePagesPerDay(int index) {
		String foundPagesPer = ScheduleGenerator.pagesPer.get(index);
		return foundPagesPer;
	}
	
	/**
	 * calculates the number of pages which must be read each day to finish a book and assigns the value to a variable
	 * @param pages the number of pages contained in the book
	 * @param days the number of days in which the book must be read
	 */
	public void calculatePagesPerDay(Integer pages, Integer days) {
		String pagesPerDay = twoPositions.format(pages/ (double)days);
		this.bookPagesPerDay = pagesPerDay;
	}
	
	/**
	 * creates and returns a StringBuilder that contains the current contents of the titles and pagesPer array lists for display
	 * @return the created StringBuilder for display to the pane
	 */
	public StringBuilder displaySchedulePreview() {
		//	referenced ChatGPT for assistance in understanding StringBuilder and static methods/variables
		previewAssembler.setLength(0);
		
		int i = 0;
		
		while(i < ScheduleGenerator.objectsCreated) {
			previewAssembler.append(retrieveTitle(i) + " ");
			previewAssembler.append(retrievePagesPerDay(i) + "\n");
			i++;
		}
		
		return previewAssembler;
	}
	
	/**
	 * determines if a String contains numeric information
	 * @param str the String to be evaluated
	 * @return true if the given String contains numeric information
	 * @return false if the given String does not contain numeric information
	 */
	public static boolean isNumeric(String str) {
		//	code was taken from forums.oracle.com
		try {
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException ex) {
			return false;
		}
	}
	
}
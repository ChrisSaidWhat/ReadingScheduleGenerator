package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 5, 2023  
*/

public class ScheduleGenerator {
	
	final private int EMPTY = 0;
	
	private String bookTitle;
	private int bookPages;
	private int bookDays;
	private String bookPagesPerDay;
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<Integer> days = new ArrayList<Integer>();
	private static ArrayList<String> pagesPer = new ArrayList<String>();
	private StringBuilder datesAssembler = new StringBuilder();
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
		addDays(this.bookDays);
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
	 * adds the specified days to read to the days array list
	 * @param days the number of days in which the corresponding title must be read
	 */
	public void addDays(int days) {
		ScheduleGenerator.days.add(days);
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
	 * returns the number of days found at the given index of the days array list
	 * @param index the integer value of the location in the days array list to be returned
	 * @return the found number of days at the given position
	 */
	public int retrieveDays(int index) {
		int foundDays = ScheduleGenerator.days.get(index);
		return foundDays;
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
	 * calculates, compiles, sorts, and prepares for display the title, dates, and pages per day for each item entered into the program
	 * @param titleIndex the integer value of the index containing the desired title in the titles array list
	 * @param daysIndex the integer value of the index containing the desired number of days in the days array list
	 * @param perDayIndex the integer value of the index containing the desired number of pages per day in the pagesPer array list
	 * @return the StringBuilder that contains the prepared text for display
	 */
	private StringBuilder prepareSchedulePreview(int titleIndex , int daysIndex ,int perDayIndex) {
		//	code taken and adapted as well as re-factored from ChatGPT
		final int INCREMENT_DAY_ONCE = 1;
		
		datesAssembler.setLength(EMPTY);
		
		String title = retrieveTitle(titleIndex);
		String pagesPerDay = retrievePagesPerDay(perDayIndex);
		LocalDate currentDate = LocalDate.now();
		LocalDate endDate = currentDate.plusDays(retrieveDays(daysIndex));
		DateTimeFormatter stdDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		List<String> associatedDates = new ArrayList<>();
		
		while(!currentDate.isAfter(endDate)) {
			associatedDates.add(currentDate.format(stdDateFormat));
			currentDate = currentDate.plus(INCREMENT_DAY_ONCE, ChronoUnit.DAYS);
			
			associatedDates.sort(Comparator
			        .comparing((String date) -> LocalDate.parse(date, stdDateFormat).getYear(), Comparator.naturalOrder())
			        .thenComparing(date -> LocalDate.parse(date, stdDateFormat).getMonthValue(), Comparator.reverseOrder())
			        .thenComparing(Comparator.naturalOrder()));
			
		}
		
		Object[] output = associatedDates.toArray();
		
		int i = 0;
		
		while(i < output.length - 1) {
			datesAssembler.append(title + "     ");
			datesAssembler.append(output[i] + "     ");
			datesAssembler.append(pagesPerDay + " Pages\n");
			i++;
		}
		
		return datesAssembler;
		
	}

	/**
	 * creates and returns a StringBuilder that contains the current contents of the titles and pagesPer array lists for display
	 * @return the created StringBuilder for display to the pane
	 */
	public StringBuilder displaySchedulePreview() {
		//	referenced ChatGPT for assistance in understanding StringBuilder and static methods/variables
		previewAssembler.setLength(EMPTY);
		
		int i = 0;
		
		while(i < ScheduleGenerator.objectsCreated) {
			previewAssembler.append(prepareSchedulePreview(i, i, i));
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
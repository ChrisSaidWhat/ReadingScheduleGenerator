package view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.ScheduleGenerator;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 4, 2023  
*/

@SuppressWarnings("serial")
public class GeneratorPanel extends JPanel {
	
	private JTextField title;
	private JTextField pagesInBook;
	private JTextField daysToRead;
	private boolean continueRunning = true;
	
	/**
	 * default constructor
	 */
	public GeneratorPanel() {
		add(createLabel("Book Title: "));
		title = (JTextField) add(createField(25));
		add(createLabel("Pages In Book: "));
		pagesInBook = (JTextField) add(createField(5));
		add(createLabel("Days To Read: "));
		daysToRead = (JTextField) add(createField(5));
		add(createAddBookButton("Add Book To Schedule"));
		add(createNextBookButton("Start Next Book"));
		add(createGenerateScheduleButton("Generate Schedule"));
		add(createScrollPane());
	}
	
	/**
	 * creates label for the GUI to describe text field
	 * @param text the content of the label
	 * @return new label component with specified text
	 */
	public JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		return label;
	}
	
	/**
	 * creates text field for the GUI to capture user input
	 * @param cols the width of the text field
	 * @return new text field component spanning the specified width
	 */
	public JTextField createField(int cols) {
		JTextField field = new JTextField(cols);
		return field;
	}
	
	/**
	 * creates add book button for the GUI to add book to array for display and eventual output
	 * @param text the content on the button 
	 * @return new button component with the specified text 
	 */
	public JButton createAddBookButton(String text) {
		JButton button = new JButton(text);
		ActionListener listener = new AddBookListener();
		button.addActionListener(listener);
		return button;
	}
	
	/**
	 * creates next book button for the GUI to clear the current entries in the fields so a new book can be entered
	 * @param text the content on the button 
	 * @return new button component with the specified text 
	 */
	public JButton createNextBookButton(String text) {
		JButton button = new JButton(text);
		ActionListener listener = new NextBookListener();
		button.addActionListener(listener);
		return button;
	}
	
	/**
	 * creates generate schedule button for the GUI to create txt file from array and terminate the program
	 * @param text the content on the button 
	 * @return new button component with the specified text 
	 */
	public JButton createGenerateScheduleButton(String text) {
		JButton button = new JButton(text);
		ActionListener listener = new GenerateScheduleListener();
		button.addActionListener(listener);
		return button;
	}
	
	/**
	 * creates scroll pane for the GUI where entered books will be stored until the schedule is generated
	 * @return new scroll pane component holding a predetermined text area
	 */
	@SuppressWarnings("static-access")
	public JScrollPane createScrollPane() {
		//	this code was taken from https://youtu.be/OJSAnlzXRDk?si=2AdB62mpg6QpLFGs
		
		final int AREA_WIDTH = 20;
		final int AREA_HEIGHT = 35;
		final int INSET = 5;
		
		JTextArea area = new JTextArea(AREA_WIDTH, AREA_HEIGHT);
		area.setLineWrap(true);
		area.setMargin(new Insets(INSET,INSET,INSET,INSET));
		JScrollPane scrollPane = new JScrollPane(area);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		return scrollPane;
	}
	
	class AddBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String titleField = title.getText();
			String pagesField = pagesInBook.getText();
			String daysField = daysToRead.getText();
			ScheduleGenerator schdGen = new ScheduleGenerator(titleField, pagesField, daysField);
			
		}
		
	}
	
	class NextBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			title.setText("");
			pagesInBook.setText("");
			daysToRead.setText("");
		}
		
	}
	
	class GenerateScheduleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			continueRunning = false;
		}
		
	}
	
}
package view;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 4, 2023  
*/

@SuppressWarnings("serial")
public class GeneratorPanel extends JPanel {
	
	/**
	 * default constructor
	 */
	public GeneratorPanel() {
		add(createLabel("Book Title: "));
		add(createField(25));
		add(createLabel("Pages In Book: "));
		add(createField(5));
		add(createLabel("Days To Read: "));
		add(createField(5));
		add(createButton("Add Book To Schedule"));
		add(createButton("Start Next Book"));
		add(createButton("Generate Schedule"));
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
	 * creates button for the GUI to execute calculations and output
	 * @param text the content on the button 
	 * @return new button component with the specified text 
	 */
	public JButton createButton(String text) {
		JButton button = new JButton(text);
		return button;
	}
	
	/**
	 * creates scroll pane for the GUI where entered books will be stored until the schedule is generated
	 * @return new scroll pane component holding a predetermined text area
	 */
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
	
}
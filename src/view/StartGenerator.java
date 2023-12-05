package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 4, 2023  
*/

public class StartGenerator {

	public static void main(String[] args) {
		
		/*	Algorithm
		 * 		-start program
		 * 		-render GUI fields and buttons
		 * 		-get book title, pages, days from user
		 * 		-calculate pages per day
		 * 		-add title and pages to array 
		 * 		get current date and from that assign dates to each days pages
		 * 		display date, title, pages per day in pane
		 * 		repeat user input, calculations, and display until user prints output
		 * 		when user finished output contents of pane to txt file
		 * 		end program
		*/
		
		final int FRAME_WIDTH = 750;
		final int FRAME_HEIGHT = 500;
		
		
		JFrame frame = new JFrame();
		JPanel panel = new GeneratorPanel();
		
		frame.add(panel);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
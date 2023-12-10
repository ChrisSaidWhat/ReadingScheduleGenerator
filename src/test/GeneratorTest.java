package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ScheduleGenerator;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 10, 2023  
*/

class GeneratorTest {
	
	ScheduleGenerator test1 = new ScheduleGenerator("Bible","2000", "50");
	ScheduleGenerator test2 = new ScheduleGenerator("How To Kill A Programmer","234", "23");
	ScheduleGenerator test3 = new ScheduleGenerator("Hiking Toward Data Structures", "673", "17");
	
	@Test
	void testCalculatePagesPerDay() {
		test1.calculatePagesPerDay(2000, 50);
		test2.calculatePagesPerDay(234, 23);
		test3.calculatePagesPerDay(673, 17);
		
		assertEquals("40.00", test1.getPagesPerDay());
		assertEquals("10.17", test2.getPagesPerDay());
		assertEquals("39.59", test3.getPagesPerDay());
	}
	
	@Test
	void testIsNumeric() {
		
		assertEquals(true, ScheduleGenerator.isNumeric("50"));
		assertEquals(false, ScheduleGenerator.isNumeric("Hello"));
		assertEquals(false, ScheduleGenerator.isNumeric("Hello50"));
		
	}

}
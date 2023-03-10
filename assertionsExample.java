package testingExample.addTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class assertionsExample {

	@Test
	public void test() {
		String obj1 = "junit";
		String obj2 = "junit";
		String obj3 = "test";
		String obj4 = "test";
		String obj5 = null;
		int var1 = 1;
		int var2 = 2;
		int[] arithmetic1 = { 1 , 2, 3};
		int[] arithmetic2 = { 1 , 2, 3};
		
		assertEquals(obj1 , obj2); //compare value
		assertSame(obj3 , obj4);  //check memory reference
		assertNotSame(obj2 , obj4);
		assertNotNull(obj1);
		assertNull(obj5);
		assertTrue(var1< var2);
		assertArrayEquals(arithmetic1 , arithmetic2);
		
	}

}

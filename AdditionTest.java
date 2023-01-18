package testingExample.addTest;

import org.junit.Test;

import junit.framework.TestCase;

public class AdditionTest extends TestCase {

	Addition a1 = new Addition();
	int sum = a1.sum(2, 5);
	int testSum = 7;
	
	@Test  //annotation
	public void test() {
		assertEquals(sum , testSum);  //predefined assertion method
	}
	
	int sub = a1.substract(5, 2);
	int testSub = 3;
	
	@Test
	public void test1() {
		assertEquals(sub , testSub); 
	}
	
}

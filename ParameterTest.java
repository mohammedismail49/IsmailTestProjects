package testingExample.addTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ParameterTest {

	private int expected;
	private int first;
	private int second;
	
	

	public ParameterTest(int expected, int first, int second) {
		super();
		this.expected = expected;
		this.first = first;
		this.second = second;
	}
	
	@Parameters
	
	public static Collection<Integer[]> addedNumbers() {
		return Arrays.asList(new Integer[][] {
			{
				3 , 1 , 2
			},
			{
				5 , 2 , 3
			},
			{
				7 , 3 , 4
			},
			{
				9 , 4 , 5
			},
		});
	}
	
	@Test
	
	public void sum() {
		Addition add = new Addition();
		System.out.println("Addition with parameters : "+first + " and "+second);
		assertEquals(expected, add.sum(first ,second));
	}
	
}

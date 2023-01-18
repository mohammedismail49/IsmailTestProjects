package testingExample.addTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class PsswVald {
	
	
	
	String s ="6LongEnough";



	@Test
	
	public void testUppercase() {
		boolean present = false;
		for(char i='A' ; i <='Z' ; i++) {
			if(s.indexOf(i)>0) {
				present = true;
			}
		}
		assertTrue(present);
	}
	
	@Test
	
	public void testDigit() {
		boolean present = false;
		for(int i = 0 ; i < s.length() ; i++){
          
            if(s.charAt(i)=='0'||s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9'){
            	present = true;
            }
            
        }
		assertTrue(present);
	}
	
	
	@Test
	
	public void testLength() {
	
	assertTrue(s.length()>6);
	}

}

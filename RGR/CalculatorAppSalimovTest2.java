package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorAppSalimovTest2 {

	@Test
	public void test() throws InterruptedException {
		Calculator c = new Calculator(); //create instance of the calculator
		c.textField1.setText("22"); //set test in the text field
		c.textField2.setText("23"); //set test in the text field
		c.textField3.setText("24"); //set test in the text field
		c.countB.doClick(); //do click on the button
		assertEquals("1", c.textField4.getText()); //check results
		
	}

}

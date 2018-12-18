package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorAppSalimovTest {

	@Test
	public void test() throws InterruptedException {
		Calculator c = new Calculator(); //create instance of the calculator
		c.textField1.setText("19"); //set test in the text field
		c.textField2.setText("20"); //set test in the text field
		c.textField3.setText("21"); //set test in the text field
		c.countB.doClick(); //do click on the button
		assertEquals("1", c.textField4.getText()); //check results
		
	}

}

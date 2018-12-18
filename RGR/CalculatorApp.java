package RGR;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorApp {

	public static void main(String[] args) throws InterruptedException {
		Calculator calc = new Calculator(); //create calculator's instance
		calc.setVisible(true); //set calculator visible

	}

}

class Calculator extends JFrame implements ActionListener{
	 JLabel label1, label2, label3, label4; //create labels
	 JButton countB; //create button
	 JTextField textField1, textField2, textField3, textField4; //create text fields
	 JPanel panel; //create panel
	 
	public Calculator() throws InterruptedException {
		super("Calculator"); //set calculator's title
		setBounds(350, 200, 350, 200); //set bounds
		
		textField1 = new JTextField("", 2); //dynamically allocates memory
		textField2 = new JTextField("", 2); //dynamically allocates memory
		textField3 = new JTextField("", 2); //dynamically allocates memory
		textField4 = new JTextField("", 2); //dynamically allocates memory
		
		label1 = new JLabel("Rate your progress"); //dynamically allocates memory
		label2 = new JLabel("How your classmates evaluate your performance?"); //dynamically allocates memory
		label3 = new JLabel("How your teachers evaluate your performance?"); //dynamically allocates memory
		label4 = new JLabel("Result");
		
		countB = new JButton("Do the count"); //dynamically allocates memory
		
		panel = new JPanel(new FlowLayout());  //dynamically allocates memory
		
		panel.add(label1); //add the label on the panel
		panel.add(textField1); //add the text field on the panel
		panel.add(label2); //add label on the panel
		panel.add(textField2); //add the text field on the panel
		panel.add(label3); //add the label on the panel
		panel.add(textField3); //add the text field on the panel
		panel.add(label4); //add the label on the panel
		panel.add(textField4); //add text field on the panel
		panel.add(countB); //add the button on the panel
		countB.addActionListener(this); //add action listener to the button
		add(panel); //add the panel on the frame

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit on close
	}

	public void actionPerformed(ActionEvent e) { //action on click to the button
			doCount();
	}
	
	public void doCount(){
		textField4.setText((20/(Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText()) + Integer.valueOf(textField3.getText()) ) + "." )); //do the count
	}
	
}

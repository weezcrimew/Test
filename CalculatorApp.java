package RGR;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorApp {

	public static void main(String[] args) throws InterruptedException {
		Calculator calc = new Calculator(args); //Создание объекта класса калькулятора
		calc.setVisible(true); //Сделать калькулятор видимым

	}

}

class Calculator extends JFrame implements ActionListener{
	 JLabel label1, label2, label3; //Создание объектов надписей
	 JButton countB; //Создание объекта кнопки
	 JTextField textField1, textField2, textField3; //Создание объектов текстовых полей
	 JPanel panel; //Создание объекта панели
	 
	public Calculator(String[] args) throws InterruptedException {
		super("Calculator"); //Указание названия окна
		setBounds(200, 200, 200, 200); //Указание размера окна
		if(args.length!=0) { //Если заранее были переданы входные данные, то они вводятся в поля ввода
			textField1 = new JTextField(args[0], 2); //Инициирование текстового поля
			textField2 = new JTextField(args[1], 2); //Инициирование текстового поля
			textField3 = new JTextField(args[2], 2); //Инициирование текстового поля
		}
		else { //Если заранее не были переданы входные данные, то поля будут пустыми
			textField1 = new JTextField("", 2); //Инициирование текстового поля
			textField2 = new JTextField("", 2); //Инициирование текстового поля
			textField3 = new JTextField("", 2); //Инициирование текстового поля
		}
		label1 = new JLabel("Оцените вашу успеваемость."); //Инициирование надписи
		label2 = new JLabel("Как оценивают вашу успеваемость преподаватели?"); //Инициирование надписи	
		label3 = new JLabel("Как оценивают вашу успеваемость другие ученики?"); //Инициирование надписи
		countB = new JButton("Провести расчёт"); //Инциирование кнопки
		panel = new JPanel(new FlowLayout());  //Инициирование панели
		panel.add(label1); //Добавление на панель надписи
		panel.add(textField1); //Добавление на панель текстового поля
		panel.add(label2); //Добавление на панель надписи
		panel.add(textField2); //Добавление на панель текстового поля
		panel.add(label3); //Добавление на панель надписи
		panel.add(textField3); //Добавление на панель текстового поля
		panel.add(countB); //Добавление на панель кнопки
		countB.addActionListener(this); //Добавление слушателя кнопке
		add(panel); //Добавление панель на окно
		pack(); //Устанавливает такой минимальный размер окна, который достаточен для отображения всех его компонентов
		Thread th = new Thread(new Runnable() { //Создание отдельного потока, предназначенного для ожидания и самовыключения
			public void run() {
				try {
					Thread.sleep(3000); //Ожидание 3 секунды
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countB.doClick(); //Вызвать нажатие кнопки
				try {
					Thread.sleep(3000); //Ожидание 3 секунды
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0); //Остановить программу
			}
		});
		if(args.length !=0)
			th.start(); //Запуск отдельного потока
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //При нажатии на крестик программа будет выключаться
	}

	public void actionPerformed(ActionEvent e) { //Что будет делать кнопка при нажатии
		if(!(textField1.getText().equals(" ") || textField2.getText().equals(" ") || textField3.getText().equals(" ")) ) //Если все три поля для ввода не пусты
			JOptionPane.showMessageDialog(null, "Вам необходимы дипломные руководители в количестве " + (20/(Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText()) + Integer.valueOf(textField3.getText()) ) + "." ) ); //Выдаст сообщение про количество дипломных руководителей
	}
}

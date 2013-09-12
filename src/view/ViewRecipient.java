package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import model.*;
import structs.TCommand;
import structs.TEvent;

public class ViewRecipient extends JFrame implements IRecipient {
	private Publisher publisher;
	private Controller controller;
	
	private JButton on, off, run;
	private JLabel label;
 
	public ViewRecipient(Publisher publisher) {
		controller = new Controller((IModel)publisher);
				
		this.publisher = publisher;
		publisher.subscribe(this);
	}
	
	public void edit(TCommand command) {
		this.controller.execute(command);
	}
	
	public void notification(TEvent event) {
		switch (event.type) {
			case 0: JOptionPane.showMessageDialog(null, event.error, "Error!", JOptionPane.ERROR_MESSAGE); break; 
			case 1: label.setText("Включено"); break; 
			case 2: label.setText("Выключено"); break; 
			case 3: JOptionPane.showMessageDialog(null, "Smth is running! :o"); break;
		}
	}
	
	public void showMain() {
		setLayout(new FlowLayout());
		on = new JButton("Вкл");
		off = new JButton("Выкл");
		run = new JButton("Запуск");
		label = new JLabel("Выключено");
		add(on);
		add(off);
		add(label);
		add(run);
		
		on.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(TCommand.CommandEnable);					
			}
		});
		
		off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(TCommand.CommandDisable);					
			}
		});
		
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(TCommand.CommandRun);					
			}
		});
		
		setTitle("MVC Example.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(150, 200);
	    setVisible(true);	
		
	}


}

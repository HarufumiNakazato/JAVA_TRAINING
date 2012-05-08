package gui1_1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.awt.Font;

public class ClockView extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 200;
	private int height = 100;
	private String dispDate;
	private Font f;
	
	public void createMainForm(){
		this.recieveCloseEvent();
		this.setMainForm();
	}

	public void paint(Graphics gr){
		setFont(f);
		gr.drawString(dispDate, 40, height/2 + 15);
	}
	
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private void setMainForm(){
		this.setSize(width,height);
		this.setVisible(true);
		this.setTitle("Clock");
		this.setResizable(false);
		f = new Font("TimesRoman",Font.BOLD,20);
	}
	
	public void setDispDate(String date){
		dispDate = date;
	}
	
}

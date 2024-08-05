import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{

	Calendar calendar;
	
	SimpleDateFormat timeFormat; // class for formatting dates(ex. to add a.m or p.m)
	JLabel timeLabel; // for time 
	
	SimpleDateFormat dayFormat;
	JLabel dayLabel; // for day 
	
	SimpleDateFormat dateFormat;
	JLabel dateLabel;
	
	String time; // used to get actual time 
	String day; // used to get todays day
	String date; // used for date
	
	
	MyFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock Program");
		this.setLayout(new FlowLayout());
		this.setSize(350,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a"); // we want out time to be set in the format hours, minutes, seconds.
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		timeLabel.setForeground(Color.black);
		timeLabel.setBackground(Color.white);
		timeLabel.setOpaque(true);
		
		dayFormat = new SimpleDateFormat("EEEE"); // E gives day of the week (ex. Sun), EEEE gives SUNDAY
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
		
		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy"); // month name, day and year 
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
	
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	
	// need to make a method that continuously updates the time
	public void setTime() {
		while(true) {// this while loop will keep running until the program is closed. so it will be continuous
			
			time = timeFormat.format(Calendar.getInstance().getTime()); // this will get the current time using Calendar class and set it to the time variable. 
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime()); // this will get the current day using Calendar class and set it to the day variable. 
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime()); // this will get the current date using Calendar class and set it to the date variable. 
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000); // have it update every second
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel beamLabel;
	public JLabel carLabel;
	public JTextArea text;
	public JTextField beams;
	public JTextField cars;
	public JButton button;
	public JPanel panel;
	public JLabel totalBeams;
	public static JLabel beamsText;
	public JLabel timeText;
	public static JLabel time;
	public JTextArea textArea;
	public PrintStream standardOut;
	public JScrollPane scrollPane;
	public static JTextArea result;
	public GUI()
	{
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        beamLabel = new JLabel("Beams needed:");
        beamLabel.setPreferredSize(new Dimension(100,100));
        panel.add(beamLabel);
        
        beams = new JTextField(10);
        beams.setPreferredSize(new Dimension(50,40));
        panel.add(beams);
        
        carLabel = new JLabel("Cars needed:");
        carLabel.setPreferredSize(new Dimension(100,50));
        panel.add(carLabel);
        
        cars = new JTextField(10);
        cars.setPreferredSize(new Dimension(50,40));
        panel.add(cars);
        
        button = new JButton("Start");
        button.setPreferredSize(new Dimension(100,50));
        panel.add(button);
        
        totalBeams = new JLabel("Beams received:");
        totalBeams.setPreferredSize(new Dimension(100,50));
        panel.add(totalBeams);
        
        beamsText = new JLabel("");
        beamsText.setPreferredSize(new Dimension(100,40));
        panel.add(beamsText);
        timeText = new JLabel("Execution time:");
        timeText.setPreferredSize(new Dimension(100,50));
        panel.add(timeText);
        
        time = new JLabel("");
        time.setPreferredSize(new Dimension(100,40));
        panel.add(time);
        
        result = new JTextArea();
        result.setWrapStyleWord(true);
     
        
        JScrollPane js = new JScrollPane(result,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js.setPreferredSize(new Dimension(500,400));
		panel.add(js);
    	button.addActionListener(new ActionListener(){ 
 		   public void actionPerformed(ActionEvent ae){
 			   	String beamText = beams.getText();
 		        int beamsNeeded = Integer.parseInt(beamText);
 		        String carsText = cars.getText();
 		        int CarsCounter = Integer.parseInt(carsText);
 		        WorkSite.AddReq(beamsNeeded, CarsCounter);
 		        
 		   }
 		  
    	});
   
    	add(panel);
        pack();
	}
	
}

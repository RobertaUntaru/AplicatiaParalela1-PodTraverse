
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.Semaphore;

import javax.swing.JTextArea;

public class WorkSite extends Thread{

	static volatile int totalNumberOfProcessedBeams = 0;
	public static int beamsNeeded; 
	public static int CarsCounter; 
	public static JTextArea textCar;
	public WorkSite(int beam, int car)
	{
		System.out.println(beam);
		System.out.println(car);
		beamsNeeded = beam;
		CarsCounter = car;
		//textCar = _textCar;
	}
	public static void AddReq(int beams, int cars)
	{
		   long start = System.currentTimeMillis();
		   PCMonitor monitor = new PCMonitor(); 
	       Semaphore semaphore = new Semaphore(1); 
	       
	       new WorkSite(beams, cars);
	       Beam BeamVector[] = new Beam[beams]; 
	       Cars CarsVector[] = new Cars[cars];
	      	for(int BeamsID = 0; BeamsID < beams; BeamsID++){
	      		BeamVector[BeamsID] = new Beam(monitor,BeamsID); 
	         	BeamVector[BeamsID].start();
	         
	      	}
	      	for(int CarID = 0; CarID < cars; CarID++){
		      	CarsVector[CarID] = new Cars(monitor,CarID,semaphore); 
		      	CarsVector[CarID].start(); 
	      	}
	      	long end = System.currentTimeMillis();
	        NumberFormat formatter = new DecimalFormat("#0.00000");
	        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	        GUI.time.setText(""+formatter.format((end - start) / 1000d)+" seconds");
	      	
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		GUI gui = new GUI();
		
	}
}

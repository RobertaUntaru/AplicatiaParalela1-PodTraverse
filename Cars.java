import java.util.concurrent.Semaphore;

public class Cars extends Thread{
	public PCMonitor monitor;	
	public int CarID;
	Semaphore semaphore;		
	
	public Cars(PCMonitor _monitor, int _CarID, Semaphore _semaphore) {
		monitor = _monitor;	
		this.CarID = _CarID;
		this.semaphore = _semaphore;	
	}
	

	 public void run() {
	     
		 for (int countBeam = 0; countBeam < WorkSite.beamsNeeded; countBeam++) {	
			 int BeamID;	
			 try {
				BeamID = monitor.get()-1; 
				
				System.out.println("Car no:[" + this.CarID + "] received beams no:[" + BeamID + "].");
				System.out.println("Car no :[" + this.CarID + "] is waiting to deliver..."); 
				
				semaphore.acquire();	
			
				System.out.println("Car no:[" + this.CarID + "] delivered beam no:[" + BeamID+ "].");
				
				WorkSite.totalNumberOfProcessedBeams++;
				
				System.out.println("Total number of beams received: "  + (WorkSite.totalNumberOfProcessedBeams));
				if(WorkSite.totalNumberOfProcessedBeams % 24 ==0)
				{
					System.out.println("Day completed");
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	         	semaphore.release();
	     
	      }
	 }

}

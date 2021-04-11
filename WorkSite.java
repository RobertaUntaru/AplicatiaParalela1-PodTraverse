import java.util.concurrent.Semaphore;

public class WorkSite{


	static volatile int totalNumberOfProcessedBeams = 0;
	public static int beamsNeeded = 156; 
	public static int CarsCounter = 5; 
	
	public static void main(String[] args) {
	PCMonitor monitor = new PCMonitor(); 
	Semaphore semaphore = new Semaphore(1); 
	Beam BeamVector[] = new Beam[beamsNeeded]; 
	Cars CarsVector[] = new Cars[CarsCounter];
    for(int BeamsID = 0; BeamsID < beamsNeeded; BeamsID++){
    	BeamVector[BeamsID] = new Beam(monitor,BeamsID); 
       	BeamVector[BeamsID].start(); 
    }
    for(int CarID = 0; CarID < CarsCounter; CarID++){
    	CarsVector[CarID] = new Cars(monitor,CarID,semaphore); 
    	CarsVector[CarID].start(); 
    }
	}
}

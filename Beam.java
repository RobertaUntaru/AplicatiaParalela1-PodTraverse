
public class Beam extends Thread{
	
    
	public PCMonitor monitor; 
	public int BeamID;
	public static int BeamNumber = 1; 
	
    Beam(PCMonitor _monitor, int _BeamID){ 
    	monitor = _monitor; 
    	this.BeamID = _BeamID;
    }
    
    public void run() { 
     System.out.println("Beam no:[" + BeamNumber +"] successfully created.");
     BeamNumber++;
     monitor.put(BeamNumber); 
    }
}


public class Beam extends Thread{
	
    
	public PCMonitor monitor; 
	public int BeamID;
	public static int BeamNumber = 1; 
	
    Beam(PCMonitor _monitor, int _BeamID){ 
    	monitor = _monitor; 
    	this.BeamID = _BeamID;
    }
    
    public void run() { 
     BeamNumber++;
     monitor.put(BeamNumber); 
    }
}

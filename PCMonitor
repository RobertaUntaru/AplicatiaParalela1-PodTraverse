
public class PCMonitor { 
	
	public int contents;	
	public boolean available = false;	
	
   
	   public synchronized int get() {
	      while (available == false) { 
	         try {
	            wait();
	         } catch (InterruptedException e) {}
	      }
	      available = false;
	      notifyAll();	
	      return contents; 
	   }
	   
	   public synchronized void put(int vaccine) {	
	      while (available == true) {	
	         try {
	            wait(); 
	         } catch (InterruptedException e) { } 
	      }
	      contents = vaccine;
	      available = true;
	      notifyAll(); 
	   }
	   
}

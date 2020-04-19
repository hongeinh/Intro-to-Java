package hust.soict.globalict.aims.thread;

public class MemoryDaemon implements Runnable {

	private long memoryUsed = 0;
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used ;
		while(true) {
			used = rt.totalMemory() - rt.freeMemory();
			if( used != memoryUsed) {
				memoryUsed = used;
				System.out.println("Memory used: " + memoryUsed);
			}
		}
	}
	

}

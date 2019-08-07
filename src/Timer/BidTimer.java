package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class BidTimer {
	
	Timer timer;
	private boolean active;
	private int i = 0;
	private int seconds;
	
	
	public BidTimer(int seconds) {
		this.seconds = seconds;
		timer = new Timer();
		System.out.println("Bid Started");
		active = true;
		timer.schedule(new Reminder(), seconds*1000);
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	class Reminder extends TimerTask{
		public void run() {
			System.out.println("Bid Closed");
			timer.cancel();
		}
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public int remainingTime() {
		return i;
	}
}
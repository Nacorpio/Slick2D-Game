package org.peter.time;

import org.newdawn.slick.Graphics;

public class Timer implements Runnable {
	
	private Thread thread;
	
	private static int secound;
	private static int minute;
	private static int hour;
	private int time = 16;
	
	
	
	public Timer() {
		thread = new Thread(this);
	}
	
	public void startTimer() {
		thread.start();
	}
    
	public void render(Graphics g){
		g.drawString(String.format("%d %d, %d", secound, minute, hour), 100, 0);
	}
	
	public boolean day() {
		if (minute <= 12) {
			return true;
		}else{
			return false;
		}
	}
	
	public synchronized void run() {
		try {
			while (true) {
				Thread.sleep(time - 14);
				secound += 1;
				
				if (secound >= 60) { minute += 1; secound = 0; }
				if (minute >= 60) { hour += 1; minute = 0; }
				if (hour >= 1) { hour = 0; minute = 0; secound = 0; }
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecound() {
		return secound;
	}
	
	
}

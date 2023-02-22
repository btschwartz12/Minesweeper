import java.util.Timer;
import java.util.TimerTask;

public class TimerClass {
	Timer timer;
	public TimerClass()
	{
		timer = new Timer();
	}
	public void runTimer()
	{
		timer.schedule(new TimerTask() {public void run() {MAIN.seconds++;}}, 0, 1000);
	}
	public void stopTimer()
	{
		timer.cancel();
	}
}
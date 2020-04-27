package _191120_Thread;


import _191120_Thread.ThreadState.StatePrintThread;
import _191120_Thread.ThreadState.TargetThread;

public class P551Thread_State
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
	}

}

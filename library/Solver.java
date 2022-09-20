package library;

import library.Util;

abstract class Solver extends Util implements Runnable {
	public static void main(final String[] args, Runnable solver) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, solver, "", 1 << 31).start();
	}
	@Override
	public void run() { solve(); flush(); }
	abstract public void solve();
}
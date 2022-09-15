package library;

public class Main implements Runnable {
	public static void main(final String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { e.printStackTrace(); System.exit(1); });
		new Thread(null, new Main(), "", 1 << 31).start();
	}

	@Override
	public void run() { solve(); }

	public void solve() {

	}
}
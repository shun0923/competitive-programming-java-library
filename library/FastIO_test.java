// verification-helper: PROBLEM https://judge.yosupo.jp/problem/aplusb
package library;

public class FastIO_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new FastIO_test(), "", 1 << 31).start();
	}

	public void solve() {
		prtln(nl() + nl());
	}
}
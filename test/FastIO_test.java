// verification-helper: PROBLEM https://judge.yosupo.jp/problem/aplusb
package test;

import library.Solver;

public class HelloWorld_test extends Solver {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new HelloWorld_test(), "", 1 << 31).start();
	}

	public void solve() {
		prtln(nl() + nl());
	}
}
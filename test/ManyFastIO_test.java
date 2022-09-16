// verification-helper: PROBLEM https://judge.yosupo.jp/problem/many_aplusb
package test;

import library.Util;

public class ManyFastIO_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new ManyFastIO_test(), "", 1 << 31).start();
	}

	public void solve() {
		int t = ni();
		for(int i = 0; i < t; i ++) prtln(nl() + nl());
	}
}
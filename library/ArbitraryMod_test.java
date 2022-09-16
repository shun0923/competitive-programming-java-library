// verification-helper: PROBLEM https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A
package library;

import library.ArbitraryMod;
import java.util.*;

public class ArbitraryMod_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new ArbitraryMod_test(), "", 1 << 31).start();
	}

	public void solve() {
		Random rnd = new Random(0);
		for(int i = 0; i < 10000000; i ++) checkAdd(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(Integer.MAX_VALUE - 1) + 1);
		for(int i = 0; i < 10000000; i ++) checkMul(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(Integer.MAX_VALUE - 1) + 1);
		for(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(), rnd.nextInt(), 998_244_353);
		for(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(), rnd.nextInt(), 1_000_000_007);
		for(int x = -100; x <= 100; x ++) {
			for(int y = -100; y <= 100; y ++) {
				for(int m = 1; m <= 1000; m ++) {
					checkAdd(x, y, m);
					checkMul(x, y, m);
				}
				checkDiv(x, y, 998_244_353);
			}
		}
		prtln("Hello World");
	}

	public void checkAdd(long x, long y, long m) {
		long z = (x + y) % m; if(z < 0) z += m;
		assertion(z == new ArbitraryMod(m).add(x, y));
	}
	public void checkMul(long x, long y, long m) {
		long z = (x * y) % m; if(z < 0) z += m;
		assertion(z == new ArbitraryMod(m).mul(x, y));
	}
	public void checkDiv(long x, long y, long m) {
		if(y == 0) return;
		long z = new ArbitraryMod(m).div(x, y);
		assertion(z >= 0 && z < m && (z * y - x) % m == 0);
	}
}
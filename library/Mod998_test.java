// verification-helper: PROBLEM https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A

package library;

import library.Mod998;
import java.util.*;

public class Mod998_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new Mod998_test(), "", 1 << 31).start();
	}

	public void solve() {
		Random rnd = new Random(0);
		for(int i = 0; i < 10000000; i ++) checkAdd(rnd.nextInt(), rnd.nextInt());
		for(int i = 0; i < 10000000; i ++) checkMul(rnd.nextInt(), rnd.nextInt());
		for(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(), rnd.nextInt());
		for(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(), rnd.nextInt());
		for(int x = -3000; x <= 3000; x ++) {
			for(int y = -3000; y <= 3000; y ++) {
				checkDiv(x, y);
			}
		}
		prtln("Hello World");
	}

	public void checkAdd(long x, long y) {
		long z = (x + y) % 998_244_353; if(z < 0) z += 998_244_353;
		assertion(z == library.Mod998.md.add(x, y));
	}
	public void checkMul(long x, long y) {
		long z = (x * y) % 998_244_353; if(z < 0) z += 998_244_353;
		assertion(z == library.Mod998.md.mul(x, y));
	}
	public void checkDiv(long x, long y) {
		if(y == 0) return;
		long z = library.Mod998.md.div(x, y);
		assertion(z >= 0 && z < 998_244_353 && (z * y - x) % 998_244_353 == 0);
	}
}
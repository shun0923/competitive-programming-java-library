// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A

package library;

import java.util.*;
import library.Solver;
import library.ArbitraryMod;

public class ArbitraryMod_random_test extends Solver {
	public static void main(final String[] args) { main(args, new ArbitraryMod_random_test()); }

	public void solve() {
		Random rnd = new Random();
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
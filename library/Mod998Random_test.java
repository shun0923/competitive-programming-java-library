// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A

package library;

import java.util.*;
import library.Solver;
import library.Mod;

public class Mod998Random_test extends Solver {
	public static void main(final String[] args) { main(args, new Mod998Random_test()); }

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
		assertion(z == Mod998.md.add(x, y));
	}
	public void checkMul(long x, long y) {
		long z = (x * y) % 998_244_353; if(z < 0) z += 998_244_353;
		assertion(z == Mod998.md.mul(x, y));
	}
	public void checkDiv(long x, long y) {
		if(y == 0) return;
		long z = Mod998.md.div(x, y);
		assertion(z >= 0 && z < 998_244_353 && (z * y - x) % 998_244_353 == 0);
	}
}
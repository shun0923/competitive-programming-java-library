// verification-helper: PROBLEM https://judge.yosupo.jp/problem/convolution_mod

package library;

import library.Solver;
import library.Fps;
import library.Convolution;

public class Fps_mul_test extends Solver {
	public static void main(final String[] args) { main(args, new Fps_mul_test()); }

	public void solve() {
		FpsOperator op = new CnvFpsOperator(Convolution998.cnv);
		int n = ni();
		int m = ni();
		Fps f = new Fps(op, nl(n));
		Fps g = new Fps(op, nl(m));
		prtln(op.mul(f, g).get());
	}
}
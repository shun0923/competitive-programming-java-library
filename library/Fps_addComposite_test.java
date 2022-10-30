// verification-helper: PROBLEM https://judge.yosupo.jp/problem/polynomial_taylor_shift

package library;

import library.Solver;
import library.Fps;
import library.Convolution;

public class Fps_addComposite_test extends Solver {
	public static void main(final String[] args) { main(args, new Fps_addComposite_test()); }

	public void solve() {
		FpsOperator op = new CnvFpsOperator(Convolution998.cnv);
		int n = ni();
		long c = nl();
		Fps f = new Fps(op, nl(n));
		prtln(op.addComposite(f, c).get());
	}
}
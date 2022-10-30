// verification-helper: PROBLEM https://judge.yosupo.jp/problem/composition_of_formal_power_series

package library;

import library.Solver;
import library.Fps;
import library.Convolution;

public class Fps_composite_test extends Solver {
	public static void main(final String[] args) { main(args, new Fps_composite_test()); }

	public void solve() {
		FpsOperator op = new CnvFpsOperator(Convolution998.cnv);
		int n = ni();
		Fps f = new Fps(op, nl(n));
		Fps g = new Fps(op, nl(n));
		prtln(op.composite(f, g).get());
	}
}
// verification-helper: PROBLEM https://judge.yosupo.jp/problem/log_of_formal_power_series

package library;

import library.Solver;
import library.Fps;
import library.Convolution;

public class Fps_log_test extends Solver {
	public static void main(final String[] args) { main(args, new Fps_log_test()); }

	public void solve() {
		FpsOperator op = new CnvFpsOperator(Convolution998.cnv);
		int n = ni();
		Fps f = new Fps(op, nl(n));
		prtln(op.log(f).get());
	}
}
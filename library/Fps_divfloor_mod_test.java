// verification-helper: PROBLEM https://judge.yosupo.jp/problem/division_of_polynomials

package library;

import library.Solver;
import library.Fps;
import library.Convolution;

public class Fps_divfloor_mod_test extends Solver {
	public static void main(final String[] args) { main(args, new Fps_divfloor_mod_test()); }

	public void solve() {
		FpsOperator op = new CnvFpsOperator(Convolution998.cnv);
		int n = ni();
		int m = ni();
		Fps f = new Fps(op, nl(n));
		Fps g = new Fps(op, nl(m));
		Fps q = op.divfloor(f, g);
		Fps r = op.mod(f, g);
		prtln(q.size(), r.size());
		prtln(q.get());
		prtln(r.get());
	}
}
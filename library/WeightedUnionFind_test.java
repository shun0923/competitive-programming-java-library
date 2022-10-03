// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1330

package library;

import library.Solver;
import library.WeightedUnionFind;

public class WeightedUnionFind_test extends Solver {
	public static void main(final String[] args) { main(args, new WeightedUnionFind_test()); }

	public void solve() {
		while(true) {
			int n = ni();
			int q = ni();
			if(n == 0) break;
			WeightedUnionFind uf = new WeightedUnionFind(n);
			for(int i = 0; i < q; i ++) {
				if(nc() == '!') uf.unite(ni() - 1, ni() - 1, nl());
				else {
					long w = uf.diff(ni() - 1, ni() - 1);
					prtln(isINF(w) ? "UNKNOWN" : w);
				}
			}
		}
	}
}
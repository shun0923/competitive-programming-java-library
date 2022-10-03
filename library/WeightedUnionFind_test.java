// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_1_B

package library;

import library.Solver;
import library.WeightedUnionFind;

public class WeightedUnionFind_test extends Solver {
	public static void main(final String[] args) { main(args, new WeightedUnionFind_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		WeightedUnionFind uf = new WeightedUnionFind(n);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) uf.unite(ni(), ni(), nl());
			else {
				long w = uf.diff(ni(), ni());
				prtln(isINF(w) ? "?" : w);
			}
		}
	}
}
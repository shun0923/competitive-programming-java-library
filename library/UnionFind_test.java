// verification-helper: PROBLEM https://judge.yosupo.jp/problem/unionfind

package library;

import library.Solver;
import library.UnionFind;

public class UnionFind_test extends Solver {
	public static void main(final String[] args) { main(args, new UnionFind_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		UnionFind uf = new UnionFind(n);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) uf.unite(ni(), ni());
			else prtln(uf.same(ni(), ni()) ? 1 : 0);
		}
	}
}
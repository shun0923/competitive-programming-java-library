// verification-helper: PROBLEM https://judge.yosupo.jp/problem/staticrmq

package library;

import library.Solver;
import library.SparseTable;

public class SparseTable_test extends Solver {
	public static void main(final String[] args) { main(args, new SparseTable_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		SparseTable st = new SparseTable(nl(n), (ele1, ele2) -> min(ele1, ele2));
		for(int i = 0; i < q; i ++) prtln(st.find(ni(), ni()));
	}
}
// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP2_7_D

package library;

import library.Solver;
import library.MultiSet;

public class TreeMultiSet_test extends Solver {
	public static void main(final String[] args) { main(args, new TreeMultiSet_test()); }

	public void solve() {
		TreeMultiSet<Integer> ms = new TreeMultiSet<>();
		int q = ni();
		for(int query = 0; query < q; query ++) {
			switch(ni()) {
			case 0: ms.add(ni()); prtln(ms.count()); break;
			case 1: prtln(ms.count(ni())); break;
			case 2: int x = ni(); ms.update(x, - ms.count(x)); break;
			case 3:
				Integer l = ni() - 1;
				int r = ni();
				while(true) {
					l = ms.higher(l);
					if(l == null || l > r) break;
					long cnt = ms.count(l);
					for(int i = 0; i < cnt; i ++) prtln(l);
				}
				break;
			}
		}
	}
}
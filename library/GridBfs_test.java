// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0558

package library;

import library.Solver;
import library.AbstractGrid;
import library.GridBfs;

public class GridBfs_test extends Solver {
	public static void main(final String[] args) { main(args, new GridBfs_test()); }

	public void solve() {
		int h = ni();
		int w = ni();
		int n = ni();
		BooleanGrids g = new BooleanGrids(h, w);
		BooleanGrid s[] = new BooleanGrid[n + 1];
		char c[][] = nc(h, w);
		boolean b[][] = new boolean[h][w];
		for(int i = 0; i < h; i ++) {
			for(int j = 0; j < w; j ++) {
				b[i][j] = c[i][j] == 'X';
				if(c[i][j] == 'S') s[0] = g.get(i, j);
				if(isNumber(c[i][j])) s[charToInt(c[i][j])] = g.get(i, j);
			}
		}
		g.init(b);

		long ans = 0;
		for(int i = 0; i < n; i ++) ans += GridBfs.dist(g, s[i])[s[i + 1].i];
		prtln(ans);
	}
}
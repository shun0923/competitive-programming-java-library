// verification-helper: PROBLEM https://atcoder.jp/contests/abc007/tasks/abc007_3


package library;

import library.Solver;
import library.AbstractGrid;
import library.GridBfs;

public class GridBfs_test extends Solver {
	public static void main(final String[] args) { main(args, new GridBfs_test()); }

	public void solve() {
		int h = ni();
		int w = ni();
		BooleanGrids g = new BooleanGrids(h, w);
		BooleanGrid start = g.get(ni() - 1, ni() - 1);
		BooleanGrid goal = g.get(ni() - 1, ni() - 1);
		boolean b[][] = nb(h, w, '#');
		g.init(b);

		int dist[] = GridBfs.dist(g, start);
		prtln(dist[goal.i]);
	}
}
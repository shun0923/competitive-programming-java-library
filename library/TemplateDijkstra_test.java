// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A

package library;

import java.util.*;
import library.Solver;
import library.AbstractGraph;
import library.TemplateDijkstra;

public class TemplateDijkstra_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateDijkstra_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int r = ni();
		ArrayTemplateGraph<Long> g = new ArrayTemplateGraph<>(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		TemplateDijkstra<Long> djk = new TemplateDijkstra<>(() -> 0l, (dist, cost) -> dist + cost,
			Comparator.comparing((ele) -> ele));
		for(Long ele : djk.dist(g, r)) prtln(ele == null ? "INF" : ele);
	}
}
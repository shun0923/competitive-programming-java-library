// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path

package library;

import java.util.*;
import library.Solver;
import library.AbstractGraph;
import library.PathRestoration;
import library.TemplateDijkstra;

public class TemplateDijkstra_pathEdge_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateDijkstra_pathEdge_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int s = ni();
		int t = ni();
		ArrayTemplateGraph<Long> g = new ArrayTemplateGraph<>(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		TemplateDijkstra<Long> djk = new TemplateDijkstra<>(() -> 0l, (dist, cost) -> dist + cost,
			Comparator.comparing((ele) -> ele));
		Long x = djk.dist(g, s, true).get(t);
		if(x == null) prtln(-1);
		else {
			int path[] = djk.path(s, t);
			prtln(x, path.length - 1);
			for(int i = 0; i < path.length - 1; i ++) prtln(path[i], path[i + 1]);
		}
	}
}
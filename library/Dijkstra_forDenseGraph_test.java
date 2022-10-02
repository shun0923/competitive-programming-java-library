// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0189

package library;

import library.Solver;
import library.AbstractGraph;
import library.Dijkstra;

public class Dijkstra_forDenseGraph_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_forDenseGraph_test()); }

	public void solve() {
		while(true) {
			int n = ni();
			if(n == 0) return;
			ArrayWeightedNode edges = new ArrayWeightedNode(-1);
			for(int i = 0; i < n; i ++) edges.add(new WeightedEdge(ni(), ni(), nl()));
			int m = 0;
			for(WeightedEdge e : edges) m = max(m, e.source, e.target);
			m ++;
			ArrayWeightedGraph g = new ArrayWeightedGraph(m, false);
			g.addAll(edges);
			long dist[][] = new long[m][];
			for(int i = 0; i < m; i ++) dist[i] = Dijkstra.distForDenseGraph(g, i);
			long sum[] = new long[m];
			for(int i = 0; i < m; i ++) sum[i] = sum(dist[i]);
			int idx = 0;
			for(int i = 0; i < m; i ++) if(sum[i] < sum[idx]) idx = i;
			prtln(idx, sum[idx]);
		}
	}
}
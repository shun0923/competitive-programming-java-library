// verification-helper: PROBLEM https://yukicoder.me/problems/no/468

package library;

import library.Solver;
import library.AbstractGraph;
import library.TopologicalSort;

public class TopologicalSort_test extends Solver {
	public static void main(final String[] args) { main(args, new TopologicalSort_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		long dist1[] = cal(n, g.nodes(), g.edges());
		long dist2[] = cal(n, g.reverseNodes(), g.reverseEdges());
		for(int i = 0; i < n; i ++) dist2[i] = dist1[0] - dist2[i];
		int cnt = 0;
		for(int i = 0; i < n; i ++) if(dist1[i] != dist2[i]) cnt ++;
		prtln(dist1[0]+" "+cnt+"/"+n);
	}

	long[] cal(int n, WeightedNode[] nodes, WeightedNode edges) {
		int sorted[] = TopologicalSort.sort(nodes, edges);
		reverse(sorted);
		long dist[] = new long[n];
		dist[sorted[0]] = 0;
		for(int i : sorted) {
			for(WeightedEdge e : nodes[i]) {
				dist[i] = max(dist[i], dist[e.target] + e.cost);
			}
		}
		return dist;
	}
}
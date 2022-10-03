// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0366

package library;

import library.Solver;
import library.AbstractGraph;
import library.Scc;

public class Scc_graph_test extends Solver {
	public static void main(final String[] args) { main(args, new Scc_graph_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		ArrayUnweightedGraph g = new ArrayUnweightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni());
		HashUnweightedGraph contracted = Scc.calGraph(g);
		int leaf = 0;
		for(UnweightedNode node : contracted.nodes()) if(node.size() == 0) leaf ++;
		int root = 0;
		for(UnweightedNode node : contracted.reverseNodes()) if(node.size() == 0) root ++;
		prtln(contracted.numNode == 1 ? 0 : max(root, leaf));
	}
}
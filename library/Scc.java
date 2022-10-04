package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;

final class Scc {
	private static int low[];
	private static int ord[];
	private static int ids[];
	private static int visited[];
	private static int ptr;
	private static int now;
	private static int numGroup;

	// O(V+E)
	public static final <Edge extends AbstractEdge<Edge>> int[][] calGroups(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return calGroups(g.numNode, g.nodes()); }
	public static final int[][] calGroups(final int numNode, final AbstractNode<? extends AbstractEdge>[] nodes) {
		calIds(numNode, nodes);
		int len[] = new int[numGroup];
		for(int x : ids) len[x] ++;
		int groups[][] = new int[numGroup][];
		for(int i = 0; i < numGroup; i ++) groups[i] = new int[len[i]];
		Arrays.fill(len, 0);
		for(int i = 0; i < numNode; i ++) groups[ids[i]][len[ids[i]] ++] = i;
		return groups;
	}
	public static final <Edge extends AbstractEdge<Edge>> HashUnweightedGraph calGraph(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return calGraph(g.numNode, g.nodes()); }
	public static final HashUnweightedGraph calGraph(final int numNode, final AbstractNode<? extends AbstractEdge>[] nodes) {
		calIds(numNode, nodes);
		HashUnweightedGraph contracted = new HashUnweightedGraph(numGroup, true);
		for(int i = 0; i < numNode; i ++) {
			for(AbstractEdge e : nodes[i]) {
				int s = ids[e.source];
				int t = ids[e.target];
				if(s != t) contracted.add(s, t);
			}
		}
		return contracted;
	}
	public static final <Edge extends AbstractEdge<Edge>> int[] calIds(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return calIds(g.numNode, g.nodes()); }
	public static final int[] calIds(final int numNode, final AbstractNode<? extends AbstractEdge>[] nodes) {
		low = new int[numNode];
		ord = new int[numNode];
		ids = new int[numNode];
		visited = new int[numNode];
		ptr = 0;
		now = 0;
		numGroup = 0;
		Arrays.fill(ord, -1);

		for(int i = 0; i < numNode; i ++) if(ord[i] == -1) dfs(i, numNode, nodes);
		for(int i = 0; i < numNode; i ++) ids[i] = numGroup - ids[i] - 1;
		return ids;
	}

	private static final void dfs(int v, final int numNode, final AbstractNode<? extends AbstractEdge>[] nodes) { // O(V+E)
		low[v] = now;
		ord[v] = now;
		now ++;
		visited[ptr ++] = v;
		for(AbstractEdge e : nodes[v]) {
			if(ord[e.target] == -1) {
				dfs(e.target, numNode, nodes);
				if(low[v] > low[e.target]) low[v] = low[e.target];
			}else if(low[v] > low[e.target]) low[v] = low[e.target];
		}
		if(low[v] == ord[v]) {
			while(true) {
				int u = visited[-- ptr];
				ord[u] = numNode;
				ids[u] = numGroup;
				if(u == v) break;
			}
			numGroup ++;
		}
	}
}
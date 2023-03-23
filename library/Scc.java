package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class Scc {
	private static int ids[];
	private static int numGroup;

	// O(V+E)
	public static final <Edge extends AbstractEdge<Edge>> int[][] calGroups(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return calGroups(g.numNode, g.numEdge(), g.nodes()); }
	public static final int[][] calGroups(final int numNode, final int numEdge, final AbstractNode<? extends AbstractEdge>[] nodes) {
		int ids[] = calIds(numNode, numEdge, nodes);
		int len[] = new int[numGroup];
		for(int x : ids) len[x] ++;
		int groups[][] = new int[numGroup][];
		for(int i = 0; i < numGroup; i ++) groups[i] = new int[len[i]];
		Arrays.fill(len, 0);
		for(int i = 0; i < numNode; i ++) groups[ids[i]][len[ids[i]] ++] = i;
		return groups;
	}
	public static final <Edge extends AbstractEdge<Edge>> HashUnweightedGraph calGraph(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return calGraph(g.numNode, g.numEdge(), g.nodes()); }
	public static final HashUnweightedGraph calGraph(final int numNode, final int numEdge, final AbstractNode<? extends AbstractEdge>[] nodes) {
		int ids[] = calIds(numNode, numEdge, nodes);
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
	public static final <Edge extends AbstractEdge<Edge>> int[] calIds(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return calIds(g.numNode, g.numEdge(), g.nodes()); }
	public static final int[] calIds(final int numNode, final int numEdge, final AbstractNode<? extends AbstractEdge>[] nodes) {
		int low[] = new int[numNode];
		int ids[] = new int[numNode];
		int visited[] = new int[numNode];
		int ptr1 = 0;
		int stack[] = new int[numEdge + 1];
		int ptr2 = 0;
		int now = 0;
		int numGroup = 0;
		Arrays.fill(low, -1);
		for(int i = 0; i < numNode; i ++) {
			if(low[i] != -1) continue;
			stack[ptr2 ++] = i;
			while(ptr2 != 0) {
				int v = stack[-- ptr2];
				if(v >= 0) {
					if(low[v] != -1) continue;
					low[v] = now ++;
					visited[ptr1 ++] = v;
					stack[ptr2 ++] = - v - 1;
					for(AbstractEdge e : nodes[v]) if(low[e.target] == -1) stack[ptr2 ++] = e.target;
				}else {
					v = - v - 1;
					boolean root = true;
					for(AbstractEdge e : nodes[v]) if(low[v] > low[e.target]) { low[v] = low[e.target]; root = false; }
					if(root) {
						while(true) {
							int u = visited[-- ptr1];
							low[u] = numNode;
							ids[u] = numGroup;
							if(u == v) break;
						}
						numGroup ++;
					}
				}
			}
		}

		for(int i = 0; i < numNode; i ++) ids[i] = numGroup - ids[i] - 1;
		Scc.ids = ids;
		Scc.numGroup = numGroup;
		return ids;
	}
}
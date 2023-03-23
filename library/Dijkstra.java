package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;
import library.PathRestoration;

final class Dijkstra {
	private static final class Dist implements Comparable<Dist> {
		public int target;
		public long cost;
		public Dist(final int target, final long cost) { this.target = target; this.cost = cost; }
		@Override public final String toString() { return " - "+cost+" -> "+target; }
		@Override public final int hashCode() { return Long.hashCode(target); }
		@Override
		public final boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			Dist that = (Dist) obj;
			if(this.target != that.target) return false;
			if(this.cost != that.cost) return false;
			return true;
		}
		@Override
		public final int compareTo(final Dist that) {
			int c = Long.compare(this.cost, that.cost);
			if(c == 0) c = Integer.compare(this.target, that.target);
			return c;
		}
	}

	// O((E+V)logV)
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] dist(final Graph g, final int start) { return dist(g, start, null, null); }
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] dist(final Graph g, final int start, final int[] prv) { return dist(g, start, prv, null); }
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] dist(final Graph g, final int start, final int[] prv, final WeightedEdge[] prvEdge) { return dist(g.numNode, g.nodes(), start, prv, prvEdge); }
	public static final long[] dist(final int numNode, final WeightedNode[] nodes, final int start) { return dist(numNode, nodes, start, null, null); }
	public static final long[] dist(final int numNode, final WeightedNode[] nodes, final int[] prv, final int start) { return dist(numNode, nodes, start, prv, null); }
	public static final long[] dist(final int numNode, final WeightedNode[] nodes, final int start, final int[] prv, final WeightedEdge[] prvEdge) {
		FastIO.rangeCheck(start, numNode);
		long dist[] = new long[numNode];
		if(prv != null) Arrays.fill(prv, -1);
		Queue<Dist> q = new PriorityQueue<>();

		Arrays.fill(dist, FastIO.INF);
		dist[start] = 0;
		q.add(new Dist(start, dist[start]));
		while(!q.isEmpty()) {
			Dist crt = q.poll();
			if(dist[crt.target] < crt.cost) continue;
			for(WeightedEdge e : nodes[crt.target]) {
				long updated = dist[e.source] + e.cost;
				if(dist[e.target] > updated) {
					dist[e.target] = updated;
					q.add(new Dist(e.target, updated));
					if(prv != null) prv[e.target] = e.source;
					if(prvEdge != null) prvEdge[e.target] = e;
				}
			}
		}
		return dist;
	}

	// O(V^2)
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] distForDenseGraph(final Graph g, final int start) { return distForDenseGraph(g, start, null, null); }
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] distForDenseGraph(final Graph g, final int start, final int[] prv) { return distForDenseGraph(g, start, prv, null); }
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] distForDenseGraph(final Graph g, final int start, final int[] prv, final WeightedEdge[] prvEdge) { return distForDenseGraph(g.numNode, g.nodes(), start, prv, prvEdge); }
	public static final long[] distForDenseGraph(final int numNode, final WeightedNode[] nodes, final int start) { return distForDenseGraph(numNode, nodes, start, null, null); }
	public static final long[] distForDenseGraph(final int numNode, final WeightedNode[] nodes, final int start, final int[] prv) { return distForDenseGraph(numNode, nodes, start, prv, null); }
	public static final long[] distForDenseGraph(final int numNode, final WeightedNode[] nodes, final int start, final int[] prv, final WeightedEdge[] prvEdge) {
		FastIO.rangeCheck(start, numNode);
		long dist[] = new long[numNode];
		boolean visited[] = new boolean[numNode];
		if(prv != null) Arrays.fill(prv, -1);

		Arrays.fill(dist, FastIO.INF);
		dist[start] = 0;
		int idx = start;
		int cnt = 0;
		while(cnt < numNode) {
			long minCost = FastIO.INF;
			for(int i = 0; i < numNode; i ++) {
				if(!visited[i] && dist[i] < minCost) {
					idx = i;
					minCost = dist[i];
				}
			}
			visited[idx] = true;
			cnt ++;
			for(WeightedEdge e : nodes[idx]) {
				long updated = dist[e.source] + e.cost;
				if(dist[e.target] > updated) {
					dist[e.target] = updated;
					if(prv != null) prv[e.target] = e.source;
					if(prvEdge != null) prvEdge[e.target] = e;
				}
			}
		}
		return dist;
	}
}
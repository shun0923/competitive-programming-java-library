package library;

import java.util.*;
import library.SimpleUtil;
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

	private static int prv[];
	private static WeightedEdge prvEdge[];

	// O((E+V)logV)
	public static final long[] dist(final WeightedGraph g, final int start) { return dist(g, start, false); }
	public static final long[] dist(final WeightedGraph g, final int start, final boolean memoize) { return dist(g.numNode, g.nodes(), start, memoize); }
	public static final long[] dist(final int numNode, final WeightedNode[] nodes, final int start) { return dist(numNode, nodes, start, false); }
	public static final long[] dist(final int numNode, final WeightedNode[] nodes, final int start, final boolean memoize) {
		SimpleUtil.rangeCheck(start, numNode);
		final long dist[] = new long[numNode];
		if(memoize) {
			prv = new int[numNode];
			Arrays.fill(prv, -1);
			prvEdge = new WeightedEdge[numNode];
		}
		Queue<Dist> q = new PriorityQueue<>();

		Arrays.fill(dist, SimpleUtil.INF);
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
					if(memoize) {
						prv[e.target] = e.source;
						prvEdge[e.target] = e;
					}
				}
			}
		}
		return dist;
	}

	// O(V^2)
	public static final long[] distForDenseGraph(final WeightedGraph g, final int start) { return distForDenseGraph(g, start, false); }
	public static final long[] distForDenseGraph(final WeightedGraph g, final int start, boolean memoize) { return distForDenseGraph(g.numNode, g.nodes(), start, memoize); }
	public static final long[] distForDenseGraph(final int numNode, final WeightedNode[] nodes, final int start) { return distForDenseGraph(numNode, nodes, start, false); }
	public static final long[] distForDenseGraph(final int numNode, final WeightedNode[] nodes, final int start, final boolean memoize) {
		SimpleUtil.rangeCheck(start, numNode);
		final long dist[] = new long[numNode];
		final boolean visited[] = new boolean[numNode];
		if(memoize) {
			prv = new int[numNode];
			Arrays.fill(prv, -1);
			prvEdge = new WeightedEdge[numNode];
		}

		Arrays.fill(dist, SimpleUtil.INF);
		dist[start] = 0;
		int idx = start;
		int cnt = 0;
		while(cnt < numNode) {
			long minCost = SimpleUtil.INF;
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
					if(memoize) {
						prv[e.target] = e.source;
						prvEdge[e.target] = e;
					}
				}
			}
		}
		return dist;
	}

	public static final int[] path(final int start, final int goal) { return PathRestoration.path(prv, start, goal); }
	public static final WeightedEdge[] pathEdge(final int start, final int goal) { return PathRestoration.pathEdge(prv, prvEdge, start, goal); }
}
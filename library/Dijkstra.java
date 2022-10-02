package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.RestorePath;

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
	public static final long[] dist(WeightedGraph g, int start) { return dist(g, start, false); }
	public static final long[] dist(WeightedGraph g, int start, boolean memoize) { return dist(g.numNode, g.nodes(), start, memoize); }
	public static final long[] dist(int numNode, WeightedNode[] nodes, int start) { return dist(numNode, nodes, start, false); }
	public static final long[] dist(int numNode, WeightedNode[] nodes, int start, boolean memoize) {
		SimpleUtil.rangeCheck(start, numNode);
		final long dist[] = new long[numNode];
		if(memoize) {
			prv = new int[numNode];
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

	public static final int[] path(final int start, final int goal) { return RestorePath.path(prv, start, goal); }
	public static final WeightedEdge[] pathEdge(final int start, final int goal) { return RestorePath.pathEdge(prv, prvEdge, start, goal); }
}
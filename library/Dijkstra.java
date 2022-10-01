package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.DistCalc;

final class Dijkstra extends WeightedRestorableDistCalc {
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

	private long dist[];

	public Dijkstra(WeightedGraph g) { super(g); };

	public final long[] dist(int start) { // O((E+V)logV)
		SimpleUtil.rangeCheck(start, g.numNode);
		dist = new long[g.numNode];
		prv = new int[g.numNode];
		prvEdge = new WeightedEdge[g.numNode];
		Queue<Dist> q = new PriorityQueue<>();

		Arrays.fill(dist, SimpleUtil.INF);
		dist[start] = 0;
		q.add(new Dist(start, dist[start]));
		while(!q.isEmpty()) {
			Dist crt = q.poll();
			if(dist[crt.target] < crt.cost) continue;
			for(WeightedEdge e : g.nodes()[crt.target]) {
				long updated = dist[e.source] + e.cost;
				if(dist[e.target] > updated) {
					dist[e.target] = updated;
					q.add(new Dist(e.target, updated));
					prv[e.target] = e.source;
					prvEdge[e.target] = e;
				}
			}
		}
		return dist;
	}
}
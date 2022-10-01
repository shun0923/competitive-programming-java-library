package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.DistCalc;

final class Dijkstra extends WeightedDistCalc {
	public Dijkstra(WeightedGraph g) { super(g); };

	public long dist[];
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
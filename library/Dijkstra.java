package library;

import java.util.*;
import library.SimpleUtil;
import library.Graph;
import library.DistCalc;

final class Dijkstra extends DistCalc {
	public static long dist[];
	public static final long[] dist(WeightedGraph g, int start) { // O((E+V)logV)
		SimpleUtil.rangeCheck(start, g.numNode);
		dist = new long[g.numNode];
		prv = new int[g.numNode];
		Arrays.fill(dist, SimpleUtil.INF);
		dist[start] = 0;

		Queue<Dist> q = new PriorityQueue<>();
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
				}
			}
		}
		return dist;
	}
}
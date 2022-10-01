package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.DistCalc;

final class BellmanFord extends WeightedDistCalc {
	public BellmanFord(WeightedGraph g) { super(g); };

	public final long[] dist(int start) { // O(VE)
		SimpleUtil.rangeCheck(start, g.numNode);
		dist = new long[g.numNode];
		prv = new int[g.numNode];
		prvEdge = new WeightedEdge[g.numNode];

		Arrays.fill(dist, SimpleUtil.INF);
		dist[start] = 0;
		for(int i = 0; i < g.numNode - 1; i ++) {
			for(WeightedEdge e : g.edges()) {
				long updated = dist[e.source] + e.cost;
				if(!SimpleUtil.isPlusINF(dist[e.source]) && dist[e.target] > updated) {
					dist[e.target] = updated;
					prv[e.target] = e.source;
					prvEdge[e.target] = e;
				}
			}
		}
		for(int i = 0; i < g.numNode; i ++) {
			for(WeightedEdge e : g.edges()) {
				if(!SimpleUtil.isPlusINF(dist[e.source]) && dist[e.target] > dist[e.source] + e.cost) {
					dist[e.target] = - SimpleUtil.INF;
				}
			}
		}
		return dist;
	}
}
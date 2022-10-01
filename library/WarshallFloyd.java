package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.DistCalc;

final class WarshallFloyd extends WeightedDistCalc {
	private long dist[][];

	public WarshallFloyd(WeightedGraph g) { super(g); };

	public long[][] dist() { // O(V^3)
		dist = new long[g.numNode][g.numNode];
		for(long[] ele : dist) Arrays.fill(ele, SimpleUtil.INF);
		for(int i = 0; i < g.numNode; i ++) dist[i][i] = 0;
		for(WeightedEdge e : g.edges()) {
			dist[e.source][e.target] = e.cost;
			if(!g.directed) dist[e.target][e.source] = e.cost;
		}
		for(int k = 0; k < g.numNode; k ++) {
			for(int i = 0; i < g.numNode; i ++) {
				for(int j = 0; j < g.numNode; j ++) {
					long updated = dist[i][k] + dist[k][j];
					if(updated < dist[i][j]) dist[i][j] = updated;
				}
			}
		}
		return dist;
	}
}
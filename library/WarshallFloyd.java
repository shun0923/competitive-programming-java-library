package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;

final class WarshallFloyd {
	// O(V^3)
	public static final long[][] dist(WeightedGraph g) { return dist(g.numNode, g.directed, g.edges()); }
	public static final long[][] dist(int numNode, boolean directed, WeightedNode edges) { 
		final long dist[][] = new long[numNode][numNode];
		for(long[] ele : dist) Arrays.fill(ele, SimpleUtil.INF);
		for(int i = 0; i < numNode; i ++) dist[i][i] = 0;
		for(WeightedEdge e : edges) {
			dist[e.source][e.target] = e.cost;
			if(!directed) dist[e.target][e.source] = e.cost;
		}
		for(int k = 0; k < numNode; k ++) {
			for(int i = 0; i < numNode; i ++) {
				for(int j = 0; j < numNode; j ++) {
					long updated = dist[i][k] + dist[k][j];
					if(updated < dist[i][j]) dist[i][j] = updated;
				}
			}
		}
		return dist;
	}
}
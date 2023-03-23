package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class PathRestoration {
	public static final int[] path(final int[] prv, final int start, int goal) { // O(V)
		FastIO.rangeCheck(start, prv.length);
		FastIO.rangeCheck(goal, prv.length);
		List<Integer> pathList = new ArrayList<>();
		pathList.add(goal);
		while(goal != start) pathList.add(goal = prv[goal]);
		final int path[] = new int[pathList.size()];
		for(int i = 0, j = path.length - 1; i < path.length; i ++, j --) path[i] = pathList.get(j);
		return path;
	}
	public static final <Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> Node pathEdge(Node pathEdge, final int[] prv, final Edge[] prvEdge, final int start, final int goal) {
		int path[] = path(prv, start, goal);
		for(int i = 1; i < path.length; i ++) pathEdge.add(prvEdge[path[i]]);
		return pathEdge;
	}
}
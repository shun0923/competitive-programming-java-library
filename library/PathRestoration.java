package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;

final class PathRestoration {
	public static final int[] path(final int[] prv, final int start, int goal) { // O(V)
		SimpleUtil.rangeCheck(start, prv.length);
		SimpleUtil.rangeCheck(goal, prv.length);
		final Deque<Integer> pathList = new ArrayDeque<>();
		pathList.addLast(goal);
		while(goal != start) pathList.addLast(goal = prv[goal]);
		final int path[] = new int[pathList.size()];
		for(int i = 0; i < path.length; i ++) path[i] = pathList.removeLast();
		return path;
	}
	public static final <Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> Node pathEdge(Node pathEdge, final int[] prv, final Edge[] prvEdge, final int start, final int goal) {
		final int path[] = path(prv, start, goal);
		for(int i = 1; i < path.length; i ++) pathEdge.add(prvEdge[path[i]]);
		return pathEdge;
	}
}
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
	@SuppressWarnings("unchecked")
	public static final <Edge extends AbstractEdge<Edge>> Edge[] pathEdge(final int[] prv, final Edge[] prvEdge, final int start, final int goal) {
		final int path[] = path(prv, start, goal);
		final Edge pathEdge[] = (Edge[]) new Object[path.length - 1];
		for(int i = 1; i < path.length; i ++) pathEdge[i - 1] = prvEdge[path[i]];
		return pathEdge;
	}
}
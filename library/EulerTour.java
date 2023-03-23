package library;

import java.util.*;
import library.AbstractGraph;

class EulerTour {
	public static int tour[];
	public static int pos[][];

	public static final <Edge extends AbstractEdge<Edge>> void cal(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g, final int start) { cal(g.numNode, g.nodes(), start); }
	public static final void cal(final int numNode, final AbstractNode<? extends AbstractEdge>[] nodes, int start) { // O(V)
		tour = new int[numNode * 2];
		pos = new int[numNode][2];
		int index = 0;

		Deque<Integer> s = new ArrayDeque<>();
		boolean visited[] = new boolean[numNode];

		s.addFirst(start);

		while(!s.isEmpty()) {
			int crt = s.removeFirst();
			if(visited[crt]) {
				pos[crt][1] = index;
				tour[index ++] = crt;
				continue;
			}
			visited[crt] = true;
			pos[crt][0] = index;
			tour[index ++] = crt;
			s.addFirst(crt);
			for(AbstractEdge e : nodes[crt]) {
				if(!visited[e.target]) {
					s.addFirst(e.target);
				}
			}
		}
	}
}
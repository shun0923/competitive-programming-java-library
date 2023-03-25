package library;

import java.util.*;
import library.FastIO;
import library.AbstractGrid;

final class GridBfs {
	// O(HW)
	public static final int[] dist(final BooleanGrids g, final BooleanGrid start) { return dist(g, start, null); }
	public static final int[] dist(final BooleanGrids g, final BooleanGrid start, final int[] prv) {
		int n = g.h * g.w;
		int dist[] = new int[n];
		Arrays.fill(dist, -1);
		boolean visited[] = new boolean[n];
		BooleanGrid dq[] = new BooleanGrid[n];
		int ptr = 0;
		int size = 0;
		if(prv != null) Arrays.fill(prv, -1);

		dist[start.i] = 0;
		visited[start.i] = true;
		dq[size ++] = start;
		while(ptr != size) {
			BooleanGrid crt = dq[ptr ++];
			for(int add = 1; add <= 4; add ++) {
				BooleanGrid next = g.next(crt, add);
				if(next == null || next.b) continue;
				if(!visited[next.i]) {
					dist[next.i] = dist[crt.i] + 1;
					visited[next.i] = true;
					dq[size ++] = next;
					if(prv != null) prv[next.i] = crt.i;
				}
			}
		}
		return dist;
	}
}
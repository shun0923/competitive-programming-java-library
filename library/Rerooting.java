package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;
import library.AbstractGraph;

class Rerooting {
	@FunctionalInterface
	interface MergeOperator { long apply(long x1, long x2); }
	interface AddEdgeOperator { long apply(WeightedEdge e, long x); }
	interface AddRootOperator { long apply(int v, long x); }
	interface CreateNodeOperator { long apply(int v); }

	private final int numNode;
	private final ArrayWeightedNode nodes[];
	private final int start;

	private final long id;
	private final MergeOperator merge;
	private final AddEdgeOperator addEdge;
	private final AddRootOperator addRoot;
	private final CreateNodeOperator createNode;

	private final int parents[];
	public final long dp[];
	public final long ans[];


	public Rerooting(final int numNode, final ArrayWeightedNode[] nodes, final int start, final long id,
		final MergeOperator merge, final AddEdgeOperator addEdge, final AddRootOperator addRoot, final CreateNodeOperator createNode) { // O(V)
		this.numNode = numNode;
		this.nodes = nodes;
		this.start = start;
		this.id = id;
		this.merge = merge;
		this.addEdge = addEdge;
		this.addRoot = addRoot;
		this.createNode = createNode;

		parents = new int[numNode];
		dp = new long[numNode];
		ans = new long[numNode];
	}

	public final long[] cal() { // O(V+E)
		dfs();
		return reroot();
	}

	public final long[] dfs() { // O(V+E)
		int dq[] = new int[numNode];
		int ptr = 0;
		int route[] = new int[numNode];
		int idx = numNode;

		dq[ptr ++] = start;
		parents[start] = -1;
		while(ptr > 0) {
			int crt = dq[-- ptr];
			route[-- idx] = crt;
			for(WeightedEdge e : nodes[crt]) {
				if(e.target == parents[crt]) continue;
				parents[e.target] = crt;
				dq[ptr ++] = e.target;
			}
		}
		for(int crt : route) {
			long tmp = createNode.apply(crt);
			for(WeightedEdge e : nodes[crt]) if(e.target != parents[crt]) tmp = merge.apply(tmp, addEdge.apply(e, dp[e.target]));
			dp[crt] = addRoot.apply(crt, tmp);
		}
		return dp;
	}

	public final long[] reroot() { // O(V+E)
		int dq[] = new int[numNode];
		long rootDq[] = new long[numNode];
		int ptr = 0;
		int size = 0;

		dq[size ++] = start;
		while(ptr < size) {
			int crt = dq[ptr];
			ArrayWeightedNode crtNode = nodes[crt];
			int len = crtNode.size();

			long dpL[] = new long[len + 1];
			dpL[0] = id;
			for(int i = 0; i < len; i ++) {
				WeightedEdge e = crtNode.get(i);
				long tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);
				dpL[i + 1] = merge.apply(dpL[i], tmp);
			}
			long dpR[] = new long[len + 1];
			dpR[len] = id;
			for(int i = len - 1; i >= 0; i --) {
				WeightedEdge e = crtNode.get(i);
				long tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);
				dpR[i] = merge.apply(dpR[i + 1], tmp);
			}
			ans[crt] = addRoot.apply(crt, dpL[len]);

			int idx = 0;
			for(WeightedEdge e : crtNode) {
				idx ++;
				if(e.target == parents[crt]) continue;
				long tmp = createNode.apply(crt);
				tmp = merge.apply(tmp, dpL[idx - 1]);
				tmp = merge.apply(tmp, dpR[idx]);
				rootDq[size] = addRoot.apply(crt, tmp);
				dq[size ++] = e.target;
			}

			ptr ++;
		}
		return ans;
	}
}
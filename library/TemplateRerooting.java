package library;

import java.util.*;
import java.util.function.*;
import library.FastIO;
import library.AbstractGraph;

final class TemplateRerooting<T> {
	@FunctionalInterface
	interface MergeOperator<T> { T apply(T x1, T x2); }
	interface AddEdgeOperator<T> { T apply(TemplateEdge<T> e, T x); }
	interface AddRootOperator<T> { T apply(int v, T x); }
	interface CreateNodeOperator<T> { T apply(int v); }

	private final int numNode;
	private final TemplateListNode<T> nodes[];
	private final int start;

	private final Supplier<T> eSupplier;
	private final MergeOperator<T> merge;
	private final AddEdgeOperator<T> addEdge;
	private final AddRootOperator<T> addRoot;
	private final CreateNodeOperator<T> createNode;

	private final int parents[];
	public final T dp[];
	public final T ans[];

	// O(V)
	public TemplateRerooting(TemplateListGraph<T> g, int start, Supplier<T> eSupplier,
			MergeOperator<T> merge, AddEdgeOperator<T> addEdge, AddRootOperator<T> addRoot, CreateNodeOperator<T> createNode) {
		this(g.numNode, g.nodes(), start, merge, addEdge, addRoot, createNode);
	}
	@SuppressWarnings("unchecked")
	public TemplateRerooting(int numNode, TemplateListNode<T>[] nodes, int start, Supplier<T> eSupplier,
			MergeOperator<T> merge, AddEdgeOperator<T> addEdge, AddRootOperator<T> addRoot, CreateNodeOperator<T> createNode) {
		this.numNode = numNode;
		this.nodes = nodes;
		this.start = start;
		this.eSupplier = eSupplier;
		this.merge = merge;
		this.addEdge = addEdge;
		this.addRoot = addRoot;
		this.createNode = createNode;

		parents = new int[numNode];
		dp = (T[]) new Object[numNode];
		ans = (T[]) new Object[numNode];
		for(int i = 0; i < numNode; i ++) dp[i] = eSupplier.get();
	}

	public final void cal() { // O(V+E)
		dfs();
		reroot();
	}
	public final T getDp(int i) { FastIO.rangeCheck(i, numNode); return dp[i]; } // O(1)
	public final T get(int i) { FastIO.rangeCheck(i, numNode); return ans[i]; } // O(1)

	public final void dfs() { // O(V+E)
		int dq[] = new int[numNode];
		int ptr = 0;
		int route[] = new int[numNode];
		int idx = numNode;

		dq[ptr ++] = start;
		parents[start] = -1;
		while(ptr > 0) {
			int crt = dq[-- ptr];
			route[-- idx] = crt;
			for(TemplateEdge<T> e : nodes[crt]) {
				if(e.target == parents[crt]) continue;
				parents[e.target] = crt;
				dq[ptr ++] = e.target;
			}
		}
		for(int crt : route) {
			T tmp = createNode.apply(crt);
			for(TemplateEdge<T> e : nodes[crt]) if(e.target != parents[crt]) tmp = merge.apply(tmp, addEdge.apply(e, dp[e.target]));
			dp[crt] = addRoot.apply(crt, tmp);
		}
	}

	@SuppressWarnings("unchecked")
	public final void reroot() { // O(V+E)
		int dq[] = new int[numNode];
		T rootDq[] = (T[]) new Object[numNode];
		int ptr = 0;
		int size = 0;

		dq[size ++] = start;
		while(ptr < size) {
			int crt = dq[ptr];
			TemplateListNode<T> crtNode = nodes[crt];
			int len = crtNode.size();

			T dpL[] = (T[]) new Object[len + 1];
			dpL[0] = eSupplier.get();
			for(int i = 0; i < len; i ++) {
				TemplateEdge<T> e = crtNode.get(i);
				T tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);
				dpL[i + 1] = merge.apply(dpL[i], tmp);
			}
			T dpR[] = (T[]) new Object[len + 1];
			dpR[len] = eSupplier.get();
			for(int i = len - 1; i >= 0; i --) {
				TemplateEdge<T> e = crtNode.get(i);
				T tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);
				dpR[i] = merge.apply(dpR[i + 1], tmp);
			}
			ans[crt] = addRoot.apply(crt, dpL[len]);

			int idx = 0;
			for(TemplateEdge<T> e : crtNode) {
				idx ++;
				if(e.target == parents[crt]) continue;
				T tmp = createNode.apply(crt);
				tmp = merge.apply(tmp, dpL[idx - 1]);
				tmp = merge.apply(tmp, dpR[idx]);
				rootDq[size] = addRoot.apply(crt, tmp);
				dq[size ++] = e.target;
			}

			ptr ++;
		}
	}
}
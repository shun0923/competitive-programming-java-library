---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord.java
    title: library/BellmanFord.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra.java
    title: library/TemplateDijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/UnionFind.java
    title: library/UnionFind.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd.java
    title: library/WarshallFloyd.java
  - icon: ':x:'
    path: library/WeightedUnionFind.java
    title: library/WeightedUnionFind.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord_reversed_test.java
    title: library/BellmanFord_reversed_test.java
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord_test.java
    title: library/BellmanFord_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_forDenseGraph_reversed_test.java
    title: library/Dijkstra_forDenseGraph_reversed_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_pathEdge_test.java
    title: library/Dijkstra_pathEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_path_test.java
    title: library/Dijkstra_path_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_reversed_test.java
    title: library/Dijkstra_reversed_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_test.java
    title: library/Dijkstra_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra_pathEdge_test.java
    title: library/TemplateDijkstra_pathEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra_test.java
    title: library/TemplateDijkstra_test.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd_reversed_test.java
    title: library/WarshallFloyd_reversed_test.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd_test.java
    title: library/WarshallFloyd_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nabstract\
    \ class AbstractGraph<Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>>\
    \ {\n\tpublic int numNode;\n\tpublic boolean directed;\n\tprivate Node edges;\n\
    \tprivate Node nodes[];\n\tprivate Node reversedEdges;\n\tprivate Node reversedNodes[];\n\
    \n\tprotected abstract Node createNode(final int id);\n\tprotected abstract Node[]\
    \ createNodeList(final int size);\n\n\tpublic AbstractGraph(final int numNode,\
    \ final boolean directed) {\n\t\tSimpleUtil.nonNegativeCheck(numNode);\n\t\tthis.numNode\
    \ = numNode;\n\t\tthis.directed = directed;\n\t\tedges = createNode(-1);\n\t\t\
    nodes = createNodeList(numNode);\n\t\tfor(int i = 0; i < numNode; i ++) nodes[i]\
    \ = createNode(i);\n\t}\n\n\tpublic final int numEdge() { return edges.size();\
    \ }\n\tpublic Node edges() { return edges; }\n\tpublic Node[] nodes() { return\
    \ nodes; }\n\tpublic Node reverseEdges() {\n\t\tif(reversedEdges == null) {\n\t\
    \t\treversedEdges = createNode(-1);\n\t\t\tfor(Edge e : edges) reversedEdges.add(e.reverse());\n\
    \t\t}\n\t\treturn reversedEdges;\n\t}\n\tpublic Node[] reverseNodes() {\n\t\t\
    if(reversedNodes == null) {\n\t\t\treversedNodes = createNodeList(numNode);\n\t\
    \t\tfor(int i = 0; i < numNode; i ++) reversedNodes[i] = createNode(i);\n\t\t\t\
    for(Edge e : edges) reversedNodes[e.target].add(e.reverse());\n\t\t}\n\t\treturn\
    \ reversedNodes;\n\t}\n\n\tpublic final void addAll(final Collection<? extends\
    \ Edge> edges) { for(Edge e : edges) add(e); }\n\tpublic final void add(final\
    \ Edge e) {\n\t\tedges.add(e);\n\t\tnodes[e.source].add(e);\n\t\tif(reversedEdges\
    \ != null) reversedEdges.add(e.reverse());\n\t\tif(reversedNodes != null) reversedNodes[e.target].add(e.reverse());\n\
    \t\tif(!directed) nodes[e.target].add(e.reverse());\n\t}\n\n\tpublic final void\
    \ remove(final Edge e) {\n\t\tedges.remove(e);\n\t\tnodes[e.source].remove(e);\n\
    \t\tif(reversedEdges != null) reversedEdges.add(e.reverse());\n\t\tif(reversedNodes\
    \ != null) reversedNodes[e.target].remove(e.reverse());\n\t\tif(!directed) nodes[e.target].remove(e.reverse());\n\
    \t}\n\n\tpublic final void clear() { edges.clear(); for(Node n : nodes) n.clear();\
    \ reversedEdges = null; reversedNodes = null; }\n}\nabstract class UnweightedGraph<Node\
    \ extends UnweightedNode> extends AbstractGraph<Node, UnweightedEdge> {\n\tpublic\
    \ UnweightedGraph(final int numNode, final boolean directed) { super(numNode,\
    \ directed); }\n\tpublic void add(final int source, final int target) { add(new\
    \ UnweightedEdge(source, target)); }\n\t@Override public Node edges() { return\
    \ super.edges(); }\n\t@Override public Node[] nodes() { return super.nodes();\
    \ }\n\t@Override public Node[] reverseNodes() { return super.reverseNodes(); }\n\
    }\nabstract class WeightedGraph<Node extends WeightedNode> extends AbstractGraph<Node,\
    \ WeightedEdge> {\n\tpublic WeightedGraph(final int numNode, final boolean directed)\
    \ { super(numNode, directed); }\n\tpublic void add(final int source, final int\
    \ target, final long cost) { add(new WeightedEdge(source, target, cost)); }\n\t\
    public void update(final WeightedEdge e, final long cost) { remove(e); e.cost\
    \ = cost; add(e); }\n\t@Override public Node edges() { return super.edges(); }\n\
    \t@Override public Node[] nodes() { return super.nodes(); }\n\t@Override public\
    \ Node[] reverseNodes() { return super.reverseNodes(); }\n}\nabstract class TemplateGraph<T\
    \ extends Comparable<T>, Node extends TemplateNode<T>> extends AbstractGraph<Node,\
    \ TemplateEdge<T>> {\n\tpublic TemplateGraph(final int numNode, final boolean\
    \ directed) { super(numNode, directed); }\n\tpublic void add(final int source,\
    \ final int target, final T cost) { add(new TemplateEdge<T>(source, target, cost));\
    \ }\n\tpublic void update(final TemplateEdge<T> e, final T cost) { remove(e);\
    \ e.cost = cost; add(e); }\n\t@Override public Node edges() { return super.edges();\
    \ }\n\t@Override public Node[] nodes() { return super.nodes(); }\n\t@Override\
    \ public Node[] reverseNodes() { return super.reverseNodes(); }\n}\nclass ArrayUnweightedGraph\
    \ extends UnweightedGraph<ArrayUnweightedNode> {\n\tpublic ArrayUnweightedGraph(final\
    \ int numNode, final boolean directed) { super(numNode, directed); }\n\t@Override\
    \ protected final ArrayUnweightedNode createNode(final int id) { return new ArrayUnweightedNode(id);\
    \ }\n\t@Override protected final ArrayUnweightedNode[] createNodeList(final int\
    \ size) { return new ArrayUnweightedNode[size]; }\n\t@Override public ArrayUnweightedNode\
    \ edges() { return super.edges(); }\n\t@Override public ArrayUnweightedNode[]\
    \ nodes() { return super.nodes(); }\n\t@Override public ArrayUnweightedNode[]\
    \ reverseNodes() { return super.reverseNodes(); }\n}\nclass ArrayWeightedGraph\
    \ extends WeightedGraph<ArrayWeightedNode> {\n\tpublic ArrayWeightedGraph(final\
    \ int numNode, final boolean directed) { super(numNode, directed); }\n\t@Override\
    \ protected final ArrayWeightedNode createNode(final int id) { return new ArrayWeightedNode(id);\
    \ }\n\t@Override protected final ArrayWeightedNode[] createNodeList(final int\
    \ size) { return new ArrayWeightedNode[size]; }\n\t@Override public ArrayWeightedNode\
    \ edges() { return super.edges(); }\n\t@Override public ArrayWeightedNode[] nodes()\
    \ { return super.nodes(); }\n\t@Override public ArrayWeightedNode[] reverseNodes()\
    \ { return super.reverseNodes(); }\n}\nclass ArrayTemplateGraph<T extends Comparable<T>>\
    \ extends TemplateGraph<T, ArrayTemplateNode<T>> {\n\tpublic ArrayTemplateGraph(final\
    \ int numNode, final boolean directed) { super(numNode, directed); }\n\t@Override\
    \ protected final ArrayTemplateNode<T> createNode(final int id) { return new ArrayTemplateNode<T>(id);\
    \ }\n\t@Override @SuppressWarnings(\"unchecked\") protected final ArrayTemplateNode<T>[]\
    \ createNodeList(final int size) { return new ArrayTemplateNode[size]; }\n\t@Override\
    \ public ArrayTemplateNode<T> edges() { return super.edges(); }\n\t@Override public\
    \ ArrayTemplateNode<T>[] nodes() { return super.nodes(); }\n\t@Override public\
    \ ArrayTemplateNode<T>[] reverseNodes() { return super.reverseNodes(); }\n}\n\
    class HashUnweightedGraph extends UnweightedGraph<HashUnweightedNode> {\n\tpublic\
    \ HashUnweightedGraph(final int numNode, final boolean directed) { super(numNode,\
    \ directed); }\n\t@Override protected final HashUnweightedNode createNode(final\
    \ int id) { return new HashUnweightedNode(id); }\n\t@Override protected final\
    \ HashUnweightedNode[] createNodeList(final int size) { return new HashUnweightedNode[size];\
    \ }\n\t@Override public HashUnweightedNode edges() { return super.edges(); }\n\
    \t@Override public HashUnweightedNode[] nodes() { return super.nodes(); }\n\t\
    @Override public HashUnweightedNode[] reverseNodes() { return super.reverseNodes();\
    \ }\n}\nclass HashWeightedGraph extends WeightedGraph<HashWeightedNode> {\n\t\
    public HashWeightedGraph(final int numNode, final boolean directed) { super(numNode,\
    \ directed); }\n\t@Override protected final HashWeightedNode createNode(final\
    \ int id) { return new HashWeightedNode(id); }\n\t@Override protected final HashWeightedNode[]\
    \ createNodeList(final int size) { return new HashWeightedNode[size]; }\n\t@Override\
    \ public HashWeightedNode edges() { return super.edges(); }\n\t@Override public\
    \ HashWeightedNode[] nodes() { return super.nodes(); }\n\t@Override public HashWeightedNode[]\
    \ reverseNodes() { return super.reverseNodes(); }\n}\nclass HashTemplateGraph<T\
    \ extends Comparable<T>> extends TemplateGraph<T, HashTemplateNode<T>> {\n\tpublic\
    \ HashTemplateGraph(final int numNode, final boolean directed) { super(numNode,\
    \ directed); }\n\t@Override protected final HashTemplateNode<T> createNode(final\
    \ int id) { return new HashTemplateNode<T>(id); }\n\t@Override @SuppressWarnings(\"\
    unchecked\") protected final HashTemplateNode<T>[] createNodeList(final int size)\
    \ { return new HashTemplateNode[size]; }\n\t@Override public HashTemplateNode<T>\
    \ edges() { return super.edges(); }\n\t@Override public HashTemplateNode<T>[]\
    \ nodes() { return super.nodes(); }\n\t@Override public HashTemplateNode<T>[]\
    \ reverseNodes() { return super.reverseNodes(); }\n}\n\ninterface AbstractNode<Edge\
    \ extends AbstractEdge<Edge>> extends Collection<Edge> {  }\ninterface UnweightedNode\
    \ extends AbstractNode<UnweightedEdge> {  }\ninterface WeightedNode extends AbstractNode<WeightedEdge>\
    \ {  }\ninterface TemplateNode<T extends Comparable<T>> extends AbstractNode<TemplateEdge<T>>\
    \ {  }\nclass ArrayUnweightedNode extends ArrayList<UnweightedEdge> implements\
    \ UnweightedNode { public final int id; public ArrayUnweightedNode(final int id)\
    \ { this.id = id; } }\nclass ArrayWeightedNode extends ArrayList<WeightedEdge>\
    \ implements WeightedNode { public final int id; public ArrayWeightedNode(final\
    \ int id) { this.id = id; } }\nclass ArrayTemplateNode<T extends Comparable<T>>\
    \ extends ArrayList<TemplateEdge<T>> implements TemplateNode<T> { public final\
    \ int id; public ArrayTemplateNode(final int id) { this.id = id; } }\nclass HashUnweightedNode\
    \ extends HashSet<UnweightedEdge> implements UnweightedNode { public final int\
    \ id; public HashUnweightedNode(final int id) { this.id = id; } }\nclass HashWeightedNode\
    \ extends HashSet<WeightedEdge> implements WeightedNode { public final int id;\
    \ public HashWeightedNode(final int id) { this.id = id; } }\nclass HashTemplateNode<T\
    \ extends Comparable<T>> extends HashSet<TemplateEdge<T>> implements TemplateNode<T>\
    \ { public final int id; public HashTemplateNode(final int id) { this.id = id;\
    \ } }\n\nabstract class AbstractEdge<Edge extends AbstractEdge> {\n\tpublic int\
    \ source, target;\n\tprotected Edge reversed = null;\n\tpublic AbstractEdge(final\
    \ int source, final int target) { this.source = source; this.target = target;\
    \ }\n\tpublic final Edge reverse() { return reversed == null ? reversed = createReversed()\
    \ : reversed; }\n\tprotected abstract Edge createReversed();\n\t@Override public\
    \ abstract String toString();\n\t@Override public final int hashCode() { return\
    \ Objects.hash(source, target); }\n\t@Override public abstract boolean equals(final\
    \ Object obj);\n}\nclass UnweightedEdge extends AbstractEdge<UnweightedEdge> implements\
    \ Comparable<UnweightedEdge> {\n\tpublic UnweightedEdge(final int source, final\
    \ int target) { super(source, target); }\n\tpublic UnweightedEdge(final int source,\
    \ final int target, final UnweightedEdge reversed) { this(source, target); this.reversed\
    \ = reversed; }\n\n\t@Override protected final UnweightedEdge createReversed()\
    \ { return new UnweightedEdge(target, source, this); }\n\t@Override public final\
    \ String toString() { return source+\" -> \"+target; }\n\t@Override\n\tpublic\
    \ final boolean equals(final Object obj) {\n\t\tif(this == obj) return true;\n\
    \t\tif(obj == null) return false;\n\t\tif(this.getClass() != obj.getClass()) return\
    \ false;\n\t\tUnweightedEdge that = (UnweightedEdge) obj;\n\t\tif(this.source\
    \ != that.source) return false;\n\t\tif(this.target != that.target) return false;\n\
    \t\treturn true;\n\t}\n\t@Override\n\tpublic final int compareTo(final UnweightedEdge\
    \ that) {\n\t\tint c = Integer.compare(this.source, that.source);\n\t\tif(c ==\
    \ 0) c = Integer.compare(this.target, that.target);\n\t\treturn c;\n\t}\n}\nclass\
    \ WeightedEdge extends AbstractEdge<WeightedEdge> implements Comparable<WeightedEdge>\
    \ {\n\tpublic long cost;\n\tpublic WeightedEdge(final int source, final int target,\
    \ final long cost) { super(source, target); this.cost = cost; }\n\tpublic WeightedEdge(final\
    \ int source, final int target, final long cost, final WeightedEdge reversed)\
    \ { this(source, target, cost); this.reversed = reversed; }\n\t@Override protected\
    \ final WeightedEdge createReversed() { return new WeightedEdge(target, source,\
    \ cost, this); }\n\t@Override public final String toString() { return source+\"\
    \ - \"+cost+\" -> \"+target; }\n\t@Override\n\tpublic final boolean equals(final\
    \ Object obj) {\n\t\tif(this == obj) return true;\n\t\tif(obj == null) return\
    \ false;\n\t\tif(this.getClass() != obj.getClass()) return false;\n\t\tWeightedEdge\
    \ that = (WeightedEdge) obj;\n\t\tif(this.source != that.source) return false;\n\
    \t\tif(this.target != that.target) return false;\n\t\tif(this.cost != that.cost)\
    \ return false;\n\t\treturn true;\n\t}\n\t@Override\n\tpublic final int compareTo(final\
    \ WeightedEdge that) {\n\t\tint c = Long.compare(this.cost, that.cost);\n\t\t\
    if(c == 0) c = Integer.compare(this.source, that.source);\n\t\tif(c == 0) c =\
    \ Integer.compare(this.target, that.target);\n\t\treturn c;\n\t}\n}\nclass TemplateEdge<T\
    \ extends Comparable<T>> extends AbstractEdge<TemplateEdge<T>> implements Comparable<TemplateEdge<T>>\
    \ {\n\tpublic T cost;\n\tpublic TemplateEdge(final int source, final int target,\
    \ final T cost) { super(source, target); this.cost = cost; }\n\tpublic TemplateEdge(final\
    \ int source, final int target, final T cost, final TemplateEdge<T> reversed)\
    \ { this(source, target, cost); this.reversed = reversed; }\n\n\t@Override protected\
    \ final TemplateEdge<T> createReversed() { return new TemplateEdge<T>(target,\
    \ source, cost, this); }\n\t@Override public final String toString() { return\
    \ source+\" - \"+cost.toString()+\" -> \"+target; }\n\t@Override\n\t@SuppressWarnings(\"\
    unchecked\")\n\tpublic final boolean equals(final Object obj) {\n\t\tif(this ==\
    \ obj) return true;\n\t\tif(obj == null) return false;\n\t\tif(this.getClass()\
    \ != obj.getClass()) return false;\n\t\tTemplateEdge<T> that = (TemplateEdge<T>)\
    \ obj;\n\t\tif(this.source != that.source) return false;\n\t\tif(this.target !=\
    \ that.target) return false;\n\t\tif(!this.cost.equals(that.cost)) return false;\n\
    \t\treturn true;\n\t}\n\t@Override\n\tpublic final int compareTo(final TemplateEdge<T>\
    \ that) {\n\t\tint c = this.cost.compareTo(that.cost);\n\t\tif(c == 0) c = Integer.compare(this.source,\
    \ that.source);\n\t\tif(c == 0) c = Integer.compare(this.target, that.target);\n\
    \t\treturn c;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/AbstractGraph.java
  requiredBy:
  - library/UnionFind.java
  - library/TemplateDijkstra.java
  - library/BellmanFord.java
  - library/WarshallFloyd.java
  - library/Dijkstra.java
  - library/WeightedUnionFind.java
  - library/PathRestoration.java
  timestamp: '2022-10-02 20:26:48+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Dijkstra_path_test.java
  - library/Dijkstra_pathEdge_test.java
  - library/BellmanFord_reversed_test.java
  - library/WarshallFloyd_reversed_test.java
  - library/WarshallFloyd_test.java
  - library/Dijkstra_forDenseGraph_reversed_test.java
  - library/Dijkstra_test.java
  - library/TemplateDijkstra_test.java
  - library/BellmanFord_test.java
  - library/Dijkstra_reversed_test.java
  - library/TemplateDijkstra_pathEdge_test.java
documentation_of: library/AbstractGraph.java
layout: document
redirect_from:
- /library/library/AbstractGraph.java
- /library/library/AbstractGraph.java.html
title: library/AbstractGraph.java
---

---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':x:'
    path: library/RestorePath.java
    title: library/RestorePath.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/Dijkstra_pathEdge_test.java
    title: library/Dijkstra_pathEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_path_test.java
    title: library/Dijkstra_path_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_test.java
    title: library/Dijkstra_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':question:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Dijkstra.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\nimport library.RestorePath;\n\nfinal class Dijkstra\
    \ {\n\tprivate static final class Dist implements Comparable<Dist> {\n\t\tpublic\
    \ int target;\n\t\tpublic long cost;\n\t\tpublic Dist(final int target, final\
    \ long cost) { this.target = target; this.cost = cost; }\n\t\t@Override public\
    \ final String toString() { return \" - \"+cost+\" -> \"+target; }\n\t\t@Override\
    \ public final int hashCode() { return Long.hashCode(target); }\n\t\t@Override\n\
    \t\tpublic final boolean equals(final Object obj) {\n\t\t\tif(this == obj) return\
    \ true;\n\t\t\tif(obj == null) return false;\n\t\t\tif(this.getClass() != obj.getClass())\
    \ return false;\n\t\t\tDist that = (Dist) obj;\n\t\t\tif(this.target != that.target)\
    \ return false;\n\t\t\tif(this.cost != that.cost) return false;\n\t\t\treturn\
    \ true;\n\t\t}\n\t\t@Override\n\t\tpublic final int compareTo(final Dist that)\
    \ {\n\t\t\tint c = Long.compare(this.cost, that.cost);\n\t\t\tif(c == 0) c = Integer.compare(this.target,\
    \ that.target);\n\t\t\treturn c;\n\t\t}\n\t}\n\n\tprivate static int prv[];\n\t\
    private static WeightedEdge prvEdge[];\n\n\t// O((E+V)logV)\n\tpublic static final\
    \ long[] dist(WeightedGraph g, int start) { return dist(g, start, false); }\n\t\
    public static final long[] dist(WeightedGraph g, int start, boolean memoize) {\
    \ return dist(g.numNode, g.nodes(), start, memoize); }\n\tpublic static final\
    \ long[] dist(int numNode, WeightedNode[] nodes, int start) { return dist(numNode,\
    \ nodes, start, false); }\n\tpublic static final long[] dist(int numNode, WeightedNode[]\
    \ nodes, int start, boolean memoize) {\n\t\tSimpleUtil.rangeCheck(start, numNode);\n\
    \t\tfinal long dist[] = new long[numNode];\n\t\tif(memoize) {\n\t\t\tprv = new\
    \ int[numNode];\n\t\t\tprvEdge = new WeightedEdge[numNode];\n\t\t}\n\t\tQueue<Dist>\
    \ q = new PriorityQueue<>();\n\n\t\tArrays.fill(dist, SimpleUtil.INF);\n\t\tdist[start]\
    \ = 0;\n\t\tq.add(new Dist(start, dist[start]));\n\t\twhile(!q.isEmpty()) {\n\t\
    \t\tDist crt = q.poll();\n\t\t\tif(dist[crt.target] < crt.cost) continue;\n\t\t\
    \tfor(WeightedEdge e : nodes[crt.target]) {\n\t\t\t\tlong updated = dist[e.source]\
    \ + e.cost;\n\t\t\t\tif(dist[e.target] > updated) {\n\t\t\t\t\tdist[e.target]\
    \ = updated;\n\t\t\t\t\tq.add(new Dist(e.target, updated));\n\t\t\t\t\tif(memoize)\
    \ {\n\t\t\t\t\t\tprv[e.target] = e.source;\n\t\t\t\t\t\tprvEdge[e.target] = e;\n\
    \t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n\n\tpublic static\
    \ final int[] path(final int start, final int goal) { return RestorePath.path(prv,\
    \ start, goal); }\n\tpublic static final WeightedEdge[] pathEdge(final int start,\
    \ final int goal) { return RestorePath.pathEdge(prv, prvEdge, start, goal); }\n\
    }"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/RestorePath.java
  isVerificationFile: false
  path: library/Dijkstra.java
  requiredBy: []
  timestamp: '2022-10-02 16:35:54+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - library/Dijkstra_path_test.java
  - library/Dijkstra_pathEdge_test.java
  - library/Dijkstra_test.java
documentation_of: library/Dijkstra.java
layout: document
redirect_from:
- /library/library/Dijkstra.java
- /library/library/Dijkstra.java.html
title: library/Dijkstra.java
---

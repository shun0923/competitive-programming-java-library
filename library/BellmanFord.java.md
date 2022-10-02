---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord_test.java
    title: library/BellmanFord_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/BellmanFord.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nfinal class BellmanFord {\n\tprivate static int prv[];\n\
    \tprivate static WeightedEdge prvEdge[];\n\n\t// O(VE)\n\tpublic static final\
    \ long[] dist(WeightedGraph g, int start) { return dist(g, start, false); }\n\t\
    public static final long[] dist(WeightedGraph g, int start, boolean memoize) {\
    \ return dist(g.numNode, g.edges(), start, memoize); }\n\tpublic static final\
    \ long[] dist(int numNode, WeightedNode edges, int start) { return dist(numNode,\
    \ edges, start, false); }\n\tpublic static final long[] dist(int numNode, WeightedNode\
    \ edges, int start, boolean memoize) {\n\t\tSimpleUtil.rangeCheck(start, numNode);\n\
    \t\tlong dist[] = new long[numNode];\n\t\tprv = new int[numNode];\n\t\tprvEdge\
    \ = new WeightedEdge[numNode];\n\n\t\tArrays.fill(dist, SimpleUtil.INF);\n\t\t\
    dist[start] = 0;\n\t\tfor(int i = 0; i < numNode - 1; i ++) {\n\t\t\tfor(WeightedEdge\
    \ e : edges) {\n\t\t\t\tlong updated = dist[e.source] + e.cost;\n\t\t\t\tif(!SimpleUtil.isPlusINF(dist[e.source])\
    \ && dist[e.target] > updated) {\n\t\t\t\t\tdist[e.target] = updated;\n\t\t\t\t\
    \tprv[e.target] = e.source;\n\t\t\t\t\tprvEdge[e.target] = e;\n\t\t\t\t}\n\t\t\
    \t}\n\t\t}\n\t\tfor(int i = 0; i < numNode; i ++) {\n\t\t\tfor(WeightedEdge e\
    \ : edges) {\n\t\t\t\tif(!SimpleUtil.isPlusINF(dist[e.source]) && dist[e.target]\
    \ > dist[e.source] + e.cost) {\n\t\t\t\t\tdist[e.target] = - SimpleUtil.INF;\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n\n\tpublic static final int[]\
    \ path(final int start, final int goal) { return RestorePath.path(prv, start,\
    \ goal); }\n\tpublic static final WeightedEdge[] pathEdge(final int start, final\
    \ int goal) { return RestorePath.pathEdge(prv, prvEdge, start, goal); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/BellmanFord.java
  requiredBy: []
  timestamp: '2022-10-02 16:35:54+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/BellmanFord_test.java
documentation_of: library/BellmanFord.java
layout: document
redirect_from:
- /library/library/BellmanFord.java
- /library/library/BellmanFord.java.html
title: library/BellmanFord.java
---

---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':x:'
    path: library/DistCalc.java
    title: library/DistCalc.java
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
    \ library.AbstractGraph;\nimport library.DistCalc;\n\nfinal class BellmanFord\
    \ extends WeightedRestorableDistCalc {\n\tprivate long dist[];\n\n\tpublic BellmanFord(WeightedGraph\
    \ g) { super(g); };\n\n\tpublic final long[] dist(int start) { // O(VE)\n\t\t\
    SimpleUtil.rangeCheck(start, g.numNode);\n\t\tdist = new long[g.numNode];\n\t\t\
    prv = new int[g.numNode];\n\t\tprvEdge = new WeightedEdge[g.numNode];\n\n\t\t\
    Arrays.fill(dist, SimpleUtil.INF);\n\t\tdist[start] = 0;\n\t\tfor(int i = 0; i\
    \ < g.numNode - 1; i ++) {\n\t\t\tfor(WeightedEdge e : g.edges()) {\n\t\t\t\t\
    long updated = dist[e.source] + e.cost;\n\t\t\t\tif(!SimpleUtil.isPlusINF(dist[e.source])\
    \ && dist[e.target] > updated) {\n\t\t\t\t\tdist[e.target] = updated;\n\t\t\t\t\
    \tprv[e.target] = e.source;\n\t\t\t\t\tprvEdge[e.target] = e;\n\t\t\t\t}\n\t\t\
    \t}\n\t\t}\n\t\tfor(int i = 0; i < g.numNode; i ++) {\n\t\t\tfor(WeightedEdge\
    \ e : g.edges()) {\n\t\t\t\tif(!SimpleUtil.isPlusINF(dist[e.source]) && dist[e.target]\
    \ > dist[e.source] + e.cost) {\n\t\t\t\t\tdist[e.target] = - SimpleUtil.INF;\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/DistCalc.java
  isVerificationFile: false
  path: library/BellmanFord.java
  requiredBy: []
  timestamp: '2022-10-01 18:33:09+09:00'
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

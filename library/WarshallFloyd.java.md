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
  - icon: ':x:'
    path: library/WarshallFloyd_test.java
    title: library/WarshallFloyd_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/WarshallFloyd.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\nimport library.DistCalc;\n\nfinal class WarshallFloyd\
    \ extends WeightedDistCalc {\n\tprivate long dist[][];\n\n\tpublic WarshallFloyd(WeightedGraph\
    \ g) { super(g); };\n\n\tpublic long[][] dist() { // O(V^3)\n\t\tdist = new long[g.numNode][g.numNode];\n\
    \t\tfor(long[] ele : dist) Arrays.fill(ele, SimpleUtil.INF);\n\t\tfor(int i =\
    \ 0; i < g.numNode; i ++) dist[i][i] = 0;\n\t\tfor(WeightedEdge e : g.edges())\
    \ {\n\t\t\tdist[e.source][e.target] = e.cost;\n\t\t\tif(!g.directed) dist[e.target][e.source]\
    \ = e.cost;\n\t\t}\n\t\tfor(int k = 0; k < g.numNode; k ++) {\n\t\t\tfor(int i\
    \ = 0; i < g.numNode; i ++) {\n\t\t\t\tfor(int j = 0; j < g.numNode; j ++) {\n\
    \t\t\t\t\tlong updated = dist[i][k] + dist[k][j];\n\t\t\t\t\tif(updated < dist[i][j])\
    \ dist[i][j] = updated;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/DistCalc.java
  isVerificationFile: false
  path: library/WarshallFloyd.java
  requiredBy: []
  timestamp: '2022-10-01 18:33:17+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/WarshallFloyd_test.java
documentation_of: library/WarshallFloyd.java
layout: document
redirect_from:
- /library/library/WarshallFloyd.java
- /library/library/WarshallFloyd.java.html
title: library/WarshallFloyd.java
---

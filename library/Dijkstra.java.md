---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/DistCalc.java
    title: library/DistCalc.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_test.java
    title: library/Dijkstra_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Dijkstra.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\nimport library.DistCalc;\n\nfinal class Dijkstra extends\
    \ DistCalc {\n\tpublic static long dist[];\n\tpublic static final long[] dist(WeightedGraph\
    \ g, int start) { // O((E+V)logV)\n\t\tSimpleUtil.rangeCheck(start, g.numNode);\n\
    \t\tdist = new long[g.numNode];\n\t\tprv = new int[g.numNode];\n\t\tArrays.fill(dist,\
    \ SimpleUtil.INF);\n\t\tdist[start] = 0;\n\n\t\tQueue<Dist> q = new PriorityQueue<>();\n\
    \t\tq.add(new Dist(start, dist[start]));\n\t\twhile(!q.isEmpty()) {\n\t\t\tDist\
    \ crt = q.poll();\n\t\t\tif(dist[crt.target] < crt.cost) continue;\n\t\t\tfor(WeightedEdge\
    \ e : g.nodes()[crt.target]) {\n\t\t\t\tlong updated = dist[e.source] + e.cost;\n\
    \t\t\t\tif(dist[e.target] > updated) {\n\t\t\t\t\tdist[e.target] = updated;\n\t\
    \t\t\t\tq.add(new Dist(e.target, updated));\n\t\t\t\t\tprv[e.target] = e.source;\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/DistCalc.java
  isVerificationFile: false
  path: library/Dijkstra.java
  requiredBy: []
  timestamp: '2022-10-01 13:33:40+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Dijkstra_test.java
documentation_of: library/Dijkstra.java
layout: document
redirect_from:
- /library/library/Dijkstra.java
- /library/library/Dijkstra.java.html
title: library/Dijkstra.java
---

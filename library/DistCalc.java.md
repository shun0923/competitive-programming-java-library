---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord.java
    title: library/BellmanFord.java
  - icon: ':question:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':x:'
    path: library/WarshallFloyd.java
    title: library/WarshallFloyd.java
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/Dijkstra_passEdge_test.java
    title: library/Dijkstra_passEdge_test.java
  - icon: ':x:'
    path: library/Dijkstra_pass_test.java
    title: library/Dijkstra_pass_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/DistCalc.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\ninterface DistCalc<Edge extends AbstractEdge<Edge>>\
    \ {  } // V=numNode, E=numEdge\nabstract class RestorableDistCalc<Edge extends\
    \ AbstractEdge<Edge>> implements DistCalc<Edge> {\n\tprotected int prv[];\n\t\
    protected int pass[];\n\n\tpublic final int[] pass(final int start, int goal)\
    \ { // O(V)\n\t\tSimpleUtil.rangeCheck(start, prv.length);\n\t\tSimpleUtil.rangeCheck(goal,\
    \ prv.length);\n\t\tfinal Deque<Integer> passList = new ArrayDeque<>();\n\t\t\
    passList.addLast(goal);\n\t\twhile(goal != start) passList.addLast(goal = prv[goal]);\n\
    \t\tpass = new int[passList.size()];\n\t\tfor(int i = 0; i < pass.length; i ++)\
    \ pass[i] = passList.removeLast();\n\t\treturn pass;\n\t}\n\tpublic abstract Edge[]\
    \ passEdge(final int start, final int goal);\n}\nabstract class WeightedDistCalc\
    \ implements DistCalc<WeightedEdge> {\n\tprotected WeightedGraph g;\n\tpublic\
    \ WeightedDistCalc(WeightedGraph g) { this.g = g; };\n}\nabstract class WeightedRestorableDistCalc\
    \ extends RestorableDistCalc<WeightedEdge> {\n\tprotected WeightedGraph g;\n\t\
    protected WeightedEdge prvEdge[];\n\tprotected WeightedEdge passEdge[];\n\n\t\
    public WeightedRestorableDistCalc(WeightedGraph g) { this.g = g; };\n\n\tpublic\
    \ final WeightedEdge[] passEdge(final int start, final int goal) {\n\t\tpass(start,\
    \ goal);\n\t\tpassEdge = new WeightedEdge[pass.length - 1];\n\t\tfor(int i = 1;\
    \ i < pass.length; i ++) passEdge[i - 1] = prvEdge[pass[i]];\n\t\treturn passEdge;\n\
    \t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/DistCalc.java
  requiredBy:
  - library/BellmanFord.java
  - library/WarshallFloyd.java
  - library/Dijkstra.java
  timestamp: '2022-10-01 18:33:09+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/Dijkstra_passEdge_test.java
  - library/Dijkstra_pass_test.java
documentation_of: library/DistCalc.java
layout: document
redirect_from:
- /library/library/DistCalc.java
- /library/library/DistCalc.java.html
title: library/DistCalc.java
---

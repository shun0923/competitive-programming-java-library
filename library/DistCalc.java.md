---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
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
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_passEdge_test.java
    title: library/Dijkstra_passEdge_test.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra_pass_test.java
    title: library/Dijkstra_pass_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/DistCalc.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nabstract class DistCalc<Edge extends AbstractEdge<Edge>>\
    \ { // V=numNode, E=numEdge\n\tprotected static final class Dist implements Comparable<Dist>\
    \ {\n\t\tpublic int target;\n\t\tpublic long cost;\n\t\tpublic Dist(final int\
    \ target, final long cost) { this.target = target; this.cost = cost; }\n\t\t@Override\
    \ public final String toString() { return \" - \"+cost+\" -> \"+target; }\n\t\t\
    @Override public final int hashCode() { return Long.hashCode(target); }\n\t\t\
    @Override\n\t\tpublic final boolean equals(final Object obj) {\n\t\t\tif(this\
    \ == obj) return true;\n\t\t\tif(obj == null) return false;\n\t\t\tif(this.getClass()\
    \ != obj.getClass()) return false;\n\t\t\tDist that = (Dist) obj;\n\t\t\tif(this.target\
    \ != that.target) return false;\n\t\t\tif(this.cost != that.cost) return false;\n\
    \t\t\treturn true;\n\t\t}\n\t\t@Override\n\t\tpublic final int compareTo(final\
    \ Dist that) {\n\t\t\tint c = Long.compare(this.cost, that.cost);\n\t\t\tif(c\
    \ == 0) c = Integer.compare(this.target, that.target);\n\t\t\treturn c;\n\t\t\
    }\n\t}\n\n\tprotected int prv[];\n\tprotected int pass[];\n\n\tpublic final int[]\
    \ pass(final int start, int goal) { // O(V)\n\t\tSimpleUtil.rangeCheck(start,\
    \ prv.length);\n\t\tSimpleUtil.rangeCheck(goal, prv.length);\n\t\tfinal Deque<Integer>\
    \ passList = new ArrayDeque<>();\n\t\tpassList.addLast(goal);\n\t\twhile(goal\
    \ != start) passList.addLast(goal = prv[goal]);\n\t\tpass = new int[passList.size()];\n\
    \t\tfor(int i = 0; i < pass.length; i ++) pass[i] = passList.removeLast();\n\t\
    \treturn pass;\n\t}\n\tpublic abstract Edge[] passEdge(final int start, final\
    \ int goal);\n}\nabstract class WeightedDistCalc extends DistCalc<WeightedEdge>\
    \ {\n\tprotected WeightedGraph g;\n\tprotected long dist[];\n\tprotected WeightedEdge\
    \ prvEdge[];\n\tprotected WeightedEdge passEdge[];\n\n\tpublic WeightedDistCalc(WeightedGraph\
    \ g) { this.g = g; };\n\n\tpublic abstract long[] dist(int start);\n\n\tpublic\
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
  - library/Dijkstra.java
  timestamp: '2022-10-01 17:43:23+09:00'
  verificationStatus: LIBRARY_ALL_AC
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
